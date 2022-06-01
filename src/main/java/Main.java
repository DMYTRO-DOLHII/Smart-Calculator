import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String expression = "10*14+(22/11)";


//        Pattern forNumbers = Pattern.compile("(\\d+(?:\\.\\d+)?)");
//        Pattern forSign = Pattern.compile("[+*/-]");
//        Matcher matcherForNumbers = forNumbers.matcher(input);
//        Matcher matcherForSign = forSign.matcher(input);
//
//        List<String> signs = new ArrayList<String>();
//        List<String> nums = new ArrayList<String>();
//
//        while (matcherForSign.find()) {
//            signs.add(matcherForSign.group());
//        }
//
//        while (matcherForNumbers.find()) {
//            nums.add(matcherForNumbers.group());
//        }
//
//        int i = signs.indexOf("+");
//
//        System.out.println(nums.get(i).concat(signs.get(i)).concat(nums.get(i+1)));

        Handler handler = new Handler();

        float result = handler.solve(expression);

//        System.out.println(result);
    }
}
