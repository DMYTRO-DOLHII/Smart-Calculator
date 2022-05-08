package exception;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExceptionHandler {

    public boolean hasException(String expression){
        Pattern pattern = Pattern.compile("[^0-9-+/*()]");
        Matcher matcher = pattern.matcher(expression);

        if (matcher.find()){
            return true;
        }

        return false;
    }
}
