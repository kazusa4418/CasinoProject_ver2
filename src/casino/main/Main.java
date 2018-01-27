package casino.main;

import casino.poker.PokerManager;
import util.checker.Checker;
import util.menu.Callback;
import util.menu.Menu;

import java.util.Scanner;

public class Main implements Callback {
    private Menu menu = new Menu();
    private Title title = new Title();

    private boolean flag = true;

    private Main() {
        menu.addMenu(1, "ポーカーをプレイする", this);
        menu.addMenu(2, "ブラックジャックをプレイする", this);
        menu.addMenu(3, "タイトルに戻る", this);
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.start();
    }

    @SuppressWarnings("all")
    private void start() {
        while(true) {
            title.menu();
            this.menu();
        }
    }

    private void menu() {
        flag = true;
        while(flag) {
            menu.show();
            menu.select();
        }
    }

    public void callback(int id) {
        switch(id) {
            case 1:
                playPoker();
                break;
            case 2:
                playBlackJack();
                break;
            case 3:
                System.out.println("DEBUG");
                flag = false;
                break;
        }
    }

    private void playPoker() {
        do {
            PokerManager pm = new PokerManager();
            pm.runGame();
        } while (askContinue());
    }

    private void playBlackJack() {

    }

    private boolean askContinue() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("もう一度プレイしますか？(yes[y] or no[n])\n> ");
            String input = sc.nextLine();
            if (Checker.stringCheck(input, "yes", "y", "no", "n"))
                return yesOrNo(input);
            System.out.println("入力が間違っています。");
        }
    }

    private boolean yesOrNo(String ans) {
        return ans.equalsIgnoreCase("yes")
                || ans.equalsIgnoreCase("y");
    }
}
