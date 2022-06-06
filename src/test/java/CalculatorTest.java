import exception.NotArithmeticSymbolException;
import exception.UnexpectedSymbolException;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    @Test
    public void TryCalculator() {
        Handler handler = new Handler();

        String[] expressions = {
                "123/1233*(1-1)",
//                "37483/63284*(8-19)",
                "1*123123123*11/(9-(-1714))"
        };

        try {
            for (String expression : expressions){
                handler.hasExceptions(expression);
                System.out.println(handler.solve(expression));
            }
        } catch (UnexpectedSymbolException | NotArithmeticSymbolException | ArithmeticException exception) {
            exception.printStackTrace();
        }
    }
}