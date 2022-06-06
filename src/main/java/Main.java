import exception.NotArithmeticSymbolException;
import exception.UnexpectedSymbolException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String expression = "123/1233*(1-1)";
        Handler handler = new Handler();

        try{
            handler.hasExceptions(expression);
            System.out.println(handler.solve(expression));
        } catch (UnexpectedSymbolException | NotArithmeticSymbolException | ArithmeticException e) {
            e.printStackTrace();
        }
    }
}
