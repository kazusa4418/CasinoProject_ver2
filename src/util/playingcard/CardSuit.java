package util.playingcard;

public enum CardSuit {
    JOKER("JOKER", 5),        //ordinal is 0
    SPADE("スペード", 1),     //ordinal is 1
    HEART("ハート", 2),       //ordinal is 2
    DIAMOND("ダイヤ", 3),     //ordinal is 3
    CLOVER("クローバー", 4);  //ordinal is 4

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
