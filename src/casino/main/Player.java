package casino.main;

import util.playingcard.Hand;

public class Player implements CharEntity {
    private static Player ourInstance = new Player();

    public static Player getInstance() {
        return ourInstance;
    }

    private Hand hand = new Hand();

    private PlayData data = new PlayData("GUEST");

    private Player() {
    }

    public PlayData getPlayData() {
        return data;
    }

    public void setPlayData(PlayData data) {
        this.data = data;
    }

    @Override
    public Hand getHand() {
        return hand;
    }

    @Override
    public void showHand() {
        hand.show();
    }

    public void showHand(String param) {
        hand.show(param);
    }
}
