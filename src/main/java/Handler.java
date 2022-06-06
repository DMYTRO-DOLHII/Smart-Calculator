import exception.ExceptionHandler;
import exception.NotArithmeticSymbolException;
import exception.UnexpectedSymbolException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class connects exception.ExceptionHandler and Calculator
 *
 * @author Dmytro Dolhii
 */
public class Handler {


    private final ExceptionHandler exceptionHandler;
    private final Calculator calculator;


    /**
     * Constructor. Stores the given expression
     *
     */
    public Handler() {
        exceptionHandler = new ExceptionHandler();
        calculator = new Calculator();
    }


    /**
     * @return true if exception has detected, and false if not
     */
    public void hasExceptions(String expression) throws UnexpectedSymbolException, NotArithmeticSymbolException {
        exceptionHandler.exceptions(expression);
    }

    public float solve(String expression) {

        try {
            return Float.parseFloat(expression);
        } catch (Exception e) {
            String newNumber = "";
            String newExpression = "";

            if (expression.contains("(")) {

                int start = 0;
                int end = 0;


                for (int i = 0; i < expression.length(); i++) {
                    if (expression.charAt(i) == '(') {
                        start = i;
                        continue;
                    }

                    if (expression.charAt(i) == ')') {
                        end = i;
                        break;
                    }
                }

                String shortExpression = expression.substring(start, end + 1);

                newNumber = String.valueOf(solveSimpleExpression(shortExpression.
                        replace("(", "").
                        replace(")", "")));

                newExpression = expression.replace(shortExpression, newNumber);
            } else {
                newExpression = String.valueOf(solveSimpleExpression(expression));
            }

            return solve(newExpression);
        }
    }

    private float solveSimpleExpression(String expression){
        try{
            return Float.parseFloat(expression);
        } catch(Exception e) {
            String newNumber = "";
            String newExpression = "";

//            Pattern forNumbers = Pattern.compile("(\\d+(?:\\.\\d+)?)");
            Pattern forNumbers = Pattern.compile("/(\\d+(?:\\.\\d+)?)/");
            Pattern forSign = Pattern.compile("[+*/-]");
            Matcher matcherForNumbers = forNumbers.matcher(expression);
            Matcher matcherForSign = forSign.matcher(expression);

            List<String> signs = new ArrayList<String>();
            List<String> nums = new ArrayList<String>();

            int signIndex = 0;

            while (matcherForSign.find()) {
                signs.add(matcherForSign.group());
            }

            while (matcherForNumbers.find()) {
                nums.add(matcherForNumbers.group());
            }

            System.out.println("List of ");

            if (signs.contains("*")) {
                if (signs.contains("/")) {
                    if (signs.indexOf("*") < signs.indexOf("/")) {
                        signIndex = signs.indexOf("*");
                    } else {
                        signIndex = signs.indexOf("/");
                    }
                } else {
                    signIndex = signs.indexOf("*");
                }
            } else if (signs.contains("/")) {
                if (signs.contains("*")) {
                    if (signs.indexOf("/") < signs.indexOf("*")) {
                        signIndex = signs.indexOf("/");
                    } else {
                        signIndex = signs.indexOf("*");
                    }
                } else {
                    signIndex = signs.indexOf("/");
                }
            } else if (signs.contains("+")) {
                if (signs.contains("-")) {
                    if (signs.indexOf("+") < signs.indexOf("-")) {
                        signIndex = signs.indexOf("+");
                    } else {
                        signIndex = signs.indexOf("-");
                    }
                } else {
                    signIndex = signs.indexOf("+");
                }
            } else if (signs.contains("-")) {
                if (signs.contains("+")) {
                    if (signs.indexOf("-") < signs.indexOf("+")) {
                        signIndex = signs.indexOf("-");
                    } else {
                        signIndex = signs.indexOf("+");
                    }
                } else {
                    signIndex = signs.indexOf("-");
                }
            }

            newNumber = String.valueOf(calculator.calculate(
                    Float.parseFloat(nums.get(signIndex)),
                    Float.parseFloat(nums.get(signIndex + 1)),
                    signs.get(signIndex)));

            String oldShortExpression = nums.get(signIndex).concat(signs.get(signIndex)).concat(nums.get(signIndex + 1));

            newExpression = expression.replace(oldShortExpression, newNumber);

            return solveSimpleExpression(newExpression);
        }
    }


}
