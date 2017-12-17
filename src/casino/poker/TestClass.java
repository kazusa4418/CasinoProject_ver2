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
                System.out.println("�n�C�J�[�h");
                break;
            case 2:
                System.out.println("�����y�A");
                break;
            case 3:
                System.out.println("�c�[�y�A");
                break;
            case 4:
                System.out.println("�X���[�J�[�h");
                break;
            case 5:
                System.out.println("�X�g���[�g");
                break;
            case 6:
                System.out.println("�t���b�V��");
                break;
            case 7:
                System.out.println("�t���n�E�X");
                break;
            case 8:
                System.out.println("�t�H�[�J�[�h");
                break;
            case 9:
                System.out.println("�X�g���[�g�t���b�V��");
                break;
            case 10:
                System.out.println("���C�����X�g���[�g�t���b�V��");
                break;
            case 11:
                System.out.println("�t�@�C�u�J�[�h");
                break;
        }

    }
}
