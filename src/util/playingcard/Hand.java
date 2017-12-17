package util.playingcard;

import java.util.ArrayList;

public class Hand extends ArrayList<Card> {

    public void show() {
        if (showWhenEmpty()) return;
        for (Card card : this)
            System.out.print(card);
        System.out.println();
    }

    public void show(String param) {
        if (showWhenEmpty()) return;
        switch (param) {
            case "WITH_INDEX":
                for (int i = 0; i < this.size(); i++ )
                    System.out.println((i + 1) + ": " + this.get(i));
        }
    }

    private boolean showWhenEmpty() {
        if (isEmpty()) {
            System.out.println("(Empty)");
            return true;
        }
        return false;
    }

    public void sort() {
        super.sort(new CardSorter());
    }
}
