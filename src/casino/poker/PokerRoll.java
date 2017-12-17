package casino.poker;

import util.playingcard.*;

import java.util.Arrays;

class PokerRoll {
    private Hand hand;
    private final int HAND_SIZE = 5;
    private CardNumber[] numbers = new CardNumber[HAND_SIZE];
    private int[] overlap = new int[CardNumber.values().length - 1];


    private int score = 0;
    private final int JOKER_NUMBER;

    PokerRoll(Hand hand) {
        this.hand = hand;
        hand.sort(new CardSorter());
        JOKER_NUMBER = jokerCount();
        setNumberArray();
        overlapCardCheck();
        Arrays.sort(overlap);
        addJokerToOverlap();
    }

    PokerRoll judgeRoll() {
        score = 1;
        judgeRoyalStraightFlush();
        judgeTwoPair();
        judgeFullHouse();
        judgeFourCard();
        judgeFiveCard();
        return this;
    }

    int getRoll() {
        return score;
    }

    @Override
    public String toString() {
        switch(score) {
            case 1:
                return "�n�C�J�[�h";
            case 2:
                return "�����y�A";
            case 3:
                return "�c�[�y�A";
            case 4:
                return "�X���[�J�[�h";
            case 5:
                return "�X�g���[�g";
            case 6:
                return "�t���b�V��";
            case 7:
                return "�t���n�E�X";
            case 8:
                return "�t�H�[�J�[�h";
            case 9:
                return "�X�g���[�g�t���b�V��";
            case 10:
                return "���C�����X�g���[�g�t���b�V��";
            case 11:
                return "�t�@�C�u�J�[�h";
            default:
                throw new RollNotFoundException();
        }
    }

    private int jokerCount() {
        int jokerNumber = 0;
        for (Card card : hand)
            if (card.getNum() == CardNumber.JOKER)
                jokerNumber++;
        return jokerNumber;
    }

    private void setNumberArray() {
        for (int i = 0; i < HAND_SIZE; i++)
            numbers[i] = hand.get(i).getNum();
    }

    //TODO: �����Ƃ������������肻���Ȃ̂ŏ�������
    private void overlapCardCheck() {
        for (int i = 0; i < overlap.length; i++)
            for (CardNumber num : numbers) {
                if (num.Strength() == (i + 1))
                    overlap[i]++;
            }
    }

    private void addJokerToOverlap() {
        overlap[overlap.length - 1] += JOKER_NUMBER;
    }

    private boolean judgeFlush() {
        for (int i = 1; i < HAND_SIZE; i++)
            if (hand.get(0).getSuit() != hand.get(i).getSuit()
                    && hand.get(i).getSuit() != CardSuit.JOKER)
                return false;
        setScore(6);
        return true;
    }

    private boolean judgeStraight() {
        int dif = 1;
        int usedJoker = 0;
        for (int i = 1; i < HAND_SIZE - JOKER_NUMBER; i++) {
            if (numbers[i].Strength() - numbers[0].Strength() != dif) {
                if (usedJoker < JOKER_NUMBER) {
                    usedJoker++;
                    i--;
                } else return false;
            }
            dif++;
        }
        setScore(5);
        return true;
    }

    private boolean judgeStraightFlush() {
        if (judgeStraight() && judgeFlush()) {
            setScore(9);
            return true;
        }
        return false;
    }

    //TODO: �A���S���Y�����v�������揑������
    private void judgeRoyalStraightFlush() {
        if (judgeStraightFlush()) {
            for (int i = 0; i < HAND_SIZE; i++)
                if (numbers[0].Strength() == 10)
                    setScore(10);
        }
    }

    private boolean judgeOnePair() {
        if (overlap[overlap.length - 1] == 2) {
            setScore(2);
            return true;
        }
        return false;
    }

    private void judgeTwoPair() {
        if (judgeOnePair())
            if (overlap[overlap.length - 2] == 2) {
                setScore(3);
            }
    }

    private boolean judgeThreeCard() {
        if (overlap[overlap.length - 1] == 3) {
            setScore(4);
            return true;
        }
        return false;
    }

    private void judgeFullHouse() {
        if (judgeThreeCard())
            if (overlap[overlap.length - 2] == 2) {
                setScore(7);
            }
    }

    private void judgeFourCard() {
        if (overlap[overlap.length - 1] == 4)
            setScore(8);
    }

    private void judgeFiveCard() {
        if (overlap[overlap.length - 1] == 5)
            setScore(11);
    }

    private void setScore(int score) {
        if (this.score < score) this.score = score;
    }
}
