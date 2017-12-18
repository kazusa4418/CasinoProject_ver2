package util.checker;

import java.text.Format;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Checker {
    public static boolean numberCheck(int number, int range) {
        //number‚ª1~count‚Ü‚Å‚Ì®”‚©‚Ç‚¤‚©‚ğ”»•Ê‚µ‚Ü‚·
        return numberCheck(number, 0, range);
    }

    public static boolean numberCheck(int number, int fromRange, int toRange) {
        return number > fromRange && number < toRange;
    }

    public static boolean numberCheck(String number, int range) {
        Pattern pt = Pattern.compile("[0-9]+");
        return stringCheck(number, pt) &&
                numberCheck(Integer.parseInt(number), 0, range);
    }

    public static boolean numberCheck(String number, int fromRange, int toRange) {
        Pattern pt = Pattern.compile("[0-9]+");
        return stringCheck(number, pt) &&
                numberCheck(Integer.parseInt(number), fromRange, toRange);
    }

    public static boolean stringCheck(String sentence, Pattern format) {
        Matcher mc = format.matcher(sentence);
        return mc.matches();
    }

    public static boolean stringCheck(String sentence, String... formats) {
        for (String format : formats)
            if (sentence.equalsIgnoreCase(format)) return true;
        return false;
    }

    public static boolean isNumber(String text) {
        return text.matches("[0-9]+");
    }
}
