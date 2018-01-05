package casino.poker;

import util.playingcard.PlayingCard;
import util.playingcard.Hand;

public class TestClass {
    public static void main(String[] args) {
        Hand hand = new Hand();
        hand.add(new PlayingCard(10, 1));
        hand.add(new PlayingCard(11, 1));
        hand.add(new PlayingCard(12, 1));
        hand.add(new PlayingCard(13, 1));
        hand.add(new PlayingCard(9, 2));

        PokerRoll roll = new PokerRoll(hand);
        roll.judgeRoll();
        System.out.println(roll);
    }
}
