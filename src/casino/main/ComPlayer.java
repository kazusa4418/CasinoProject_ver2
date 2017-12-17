package casino.main;

import util.playingcard.Hand;

public class ComPlayer implements CharEntity {
    private static ComPlayer ourInstance = new ComPlayer();

    public static ComPlayer getInstance() {
        return ourInstance;
    }

    private Hand hand = new Hand();

    private ComPlayer() {
    }

    @Override
    public Hand getHand() {
        return hand;
    }

    @Override
    public void showHand() {
        hand.show();
    }
}
