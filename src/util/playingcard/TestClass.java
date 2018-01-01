package util.playingcard;

<<<<<<< HEAD
@SuppressWarnings("unused")
class TestClass {
    private void unused() {
        CardStock cs = new CardStock();
        cs.initialize();

        Hand hand = new Hand();
        distribute(hand);

        hand.sort();
    }

    private void distribute(Hand hand) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++ )
                hand.add(new Card(i, j));
        }
=======
public class TestClass {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        Hand hand = new Hand();
        hand.add(new Card(1, 2));
        hand.add(new Card(2, 3));
        hand.add(new Card(0, 0));
        hand.add(new Card(1, 3));
        hand.add(new Card(2, 2));

        hand.sort();
        hand.show();

>>>>>>> 1f192ba3a48ccbe6dbf6ca5e7db4032184e7469e
    }
}
