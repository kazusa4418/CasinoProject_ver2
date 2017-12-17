package util.playingcard;

public enum CardSuit {
    JOKER("JOKER", 5),        //ordinal is 0
    SPADE("�X�y�[�h", 1),     //ordinal is 1
    HEART("�n�[�g", 2),       //ordinal is 2
    DIAMOND("�_�C��", 3),     //ordinal is 3
    CLOVER("�N���[�o�[", 4);  //ordinal is 4

    private String suit;
    private int strength;

    CardSuit(String suit, int strength) {
        this.suit = suit;
        this.strength = strength;
    }

    @Override
    public String toString() {
        return this.suit;
    }

    public int getStrength() {
        return strength;
    }
}
