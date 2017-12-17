package casino.poker;

import util.playingcard.Card;
import util.playingcard.Hand;

public class TestClass {
    public static void main(String[] args) {
        Hand hand = new Hand();
        hand.add(new Card(11, 1));
        hand.add(new Card(11, 2));
        hand.add(new Card(11, 1));
        hand.add(new Card(11, 1));
        hand.add(new Card(11, 2));

        PokerRoll roll = new PokerRoll(hand);
        roll.judgeRoll();
        int score = roll.getRoll();
        System.out.println(score);
        switch(score) {
            case 1:
                System.out.println("ハイカード");
                break;
            case 2:
                System.out.println("ワンペア");
                break;
            case 3:
                System.out.println("ツーペア");
                break;
            case 4:
                System.out.println("スリーカード");
                break;
            case 5:
                System.out.println("ストレート");
                break;
            case 6:
                System.out.println("フラッシュ");
                break;
            case 7:
                System.out.println("フルハウス");
                break;
            case 8:
                System.out.println("フォーカード");
                break;
            case 9:
                System.out.println("ストレートフラッシュ");
                break;
            case 10:
                System.out.println("ロイヤルストレートフラッシュ");
                break;
            case 11:
                System.out.println("ファイブカード");
                break;
        }

    }
}
