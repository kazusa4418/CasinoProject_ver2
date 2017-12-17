package casino.poker;

import casino.main.CharEntity;
import casino.main.ComPlayer;
import casino.main.Player;
import util.file.manager.ConsoleManager;
import util.playingcard.*;

import java.util.Scanner;

import static util.checker.Checker.numberCheck;

public class PokerManager {
    private CardStock stock = new CardStock();

    private Player pl = Player.getInstance();
    private ComPlayer com = ComPlayer.getInstance();

    public void runGame() {
        System.out.println("DEBUG:�Q�[�����J�n���܂����B");
        ConsoleManager.clear();
        distribute();
        pl.getHand().sort(new CardSorterOnPoker());
        handChange();
        pl.getHand().sort(new CardSorterOnPoker());
        battle();

        pl.getHand().clear();
        com.getHand().clear();
        stock.initialize();
    }

    private void distribute() {
        stock.shuffle();
        for (int i = 0; i < 5; i++ ) {
            pl.getHand().add(stock.takeCard());
            com.getHand().add(stock.takeCard());
        }
    }

    private void handChange() {
        while(true) {
            Card card = cardSelect();
            ConsoleManager.clear();
            if (card == null) break;
            pl.getHand().remove(card);
        }
        draw();
    }

    private Card cardSelect() {
        pl.showHand("WITH_INDEX");
        int no = input();
        if (no == -1) return null;
        return pl.getHand().get(no - 1);
    }

    private int input() {
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.print("> ");
            String input = sc.nextLine();
            if (input.equals("")) return -1;
            //TODO: ���� + 1 ���ƂĂ��C�ɐH��Ȃ��A�S�̓I�ɃR�R�̏������C�ɓ���Ȃ��̂łǂ��ɂ�����
            if (numberCheck(input, pl.getHand().size() + 1))
                return Integer.parseInt(input);
            System.out.println("���͂��Ԉ���Ă��܂��B\n�ē��͂��Ă��������B");
        }
    }

    private void draw() {
        while(pl.getHand().size() < 5) {
            pl.getHand().add(stock.takeCard());
        }
    }

    private void battle() {
        PokerRoll plRoll = new PokerRoll(pl.getHand());
        PokerRoll comRoll = new PokerRoll(com.getHand());
        int plScore = plRoll.judgeRoll().getRoll();
        int comScore = comRoll.judgeRoll().getRoll();
        System.out.println("====================================");
        showRoll(plRoll, pl);
        System.out.println("\n");
        showRoll(comRoll, com);
        System.out.println("====================================\n");
        System.out.println(compareRoll(plScore, comScore));
    }

    private void showRoll(PokerRoll roll, CharEntity chara) {
        if (chara instanceof Player) {
            System.out.println("���Ȃ��̎�D: \n");
            chara.showHand();
            System.out.println("���Ȃ��̖�: " + roll.toString());
        } else {
            System.out.println("���߭���̎�D: \n");
            chara.showHand();
            System.out.println("���߭���̖�: " + roll.toString());
        }
    }

    private String compareRoll(int pl, int com) {
        if (pl == com) return "DRAW";
        return (pl > com) ? "YOU WIN!" : "YOU LOSE";
    }
}