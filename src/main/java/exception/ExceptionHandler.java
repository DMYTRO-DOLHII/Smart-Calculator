package exception;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExceptionHandler {

    private final char[] unexpectedSymbols = {'+', '-', '*', '/', ')'};

    public boolean exceptions(String expression) throws UnexpectedSymbolException, NotArithmeticSymbolException {

        // Checking if expression has not math symbol
        Pattern pattern = Pattern.compile("[^0-9-+/*()]");
        Matcher matcher = pattern.matcher(expression);
        if (matcher.find()) {
            throw new NotArithmeticSymbolException();
        }

        for (int i = 0; i < expression.length(); i++) {
            if (i != expression.length() - 1) {
                unexpectedSymbol(expression.charAt(i), expression.charAt(i + 1));

                if(expression.charAt(i) == '/' && expression.charAt(i + 1) == '0'){
                    throw new ArithmeticException();
                }
            } else{
                if (expression.charAt(i) == '+') throw new UnexpectedSymbolException();
                if (expression.charAt(i) == '-') throw new UnexpectedSymbolException();
                if (expression.charAt(i) == '*') throw new UnexpectedSymbolException();
                if (expression.charAt(i) == '/') throw new UnexpectedSymbolException();
                if (expression.charAt(i) == '(') throw new UnexpectedSymbolException();
            }
        }
        return false;
    }

    private void unexpectedSymbol(char current, char next) throws UnexpectedSymbolException {
        if (current == '+' || current == '-' || current == '*' || current == '/' || current == '(') {
            for (char unexpectedSymbol : unexpectedSymbols) {
                if (next == unexpectedSymbol) throw new UnexpectedSymbolException();
            }
        }

        if (current == ')' && next == '(') throw new UnexpectedSymbolException();

        if (current == '(' && next == ')') throw new UnexpectedSymbolException();
    }
}
