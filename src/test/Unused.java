package test;

import util.playingcard.PlayingCard;
import util.playingcard.CardStock;
import util.playingcard.Hand;

public class Unused {
    public static void main(String[] args) {
        PlayingCard card = new PlayingCard(1, 1);
        card.strength();

        CardStock stock = new CardStock();
        stock.initialize();

        Hand hand = new Hand();
        hand.sort();

    }
}
