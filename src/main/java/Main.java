import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String input = "5+10a";
        String regex = "[^0-9-+/*()]";

        Handler handler = new Handler(input);
        System.out.println(handler.checkForExceptions());
    }
}
