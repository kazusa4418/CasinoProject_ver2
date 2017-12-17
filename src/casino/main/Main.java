package casino.main;

import casino.poker.PokerManager;
import util.checker.Checker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        do {
            PokerManager pm = new PokerManager();
            pm.runGame();
        } while(askContinue());
    }

    private static boolean askContinue() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("もう一度プレイしますか？(yes[y] or no[n])\n> ");
            String ans = sc.nextLine();
            if (Checker.stringCheck(ans, "yes", "y", "no", "n"))
                return yesOrNo(ans);
            System.out.println("入力が間違っています。");
        }
    }

    private static boolean yesOrNo(String ans) {
        return ans.equalsIgnoreCase("yes")
                || ans.equalsIgnoreCase("y");
    }
}
