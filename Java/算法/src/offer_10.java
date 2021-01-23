import java.util.Scanner;
import java.util.regex.Pattern;

public class offer_10 {
    public static boolean isMatch(String s, String p) {
        String pattner = p;
        boolean Match = Pattern.matches(p,s);
        return Match;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.next();
        String p = input.next();
        boolean b = isMatch(s,p);
        System.out.println(b);

    }
}
