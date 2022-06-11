package com.github.ddolgiy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String expression = "1-1";


        Pattern pattern = Pattern.compile("(-)?(([0-9]+[.]?[0-9]*)|([0-9]*[.]?[0-9]+))");
        Matcher matcher = pattern.matcher(expression);

        System.out.println(matcher.results().count());
    }
}
