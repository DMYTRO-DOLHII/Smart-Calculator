package com.github.ddolgiy.expressionhandler;

import org.junit.jupiter.api.Test;

public class HandlerTest {

    @Test
    public void initializeHandlerTest(){
        Handler handler = new Handler();
    }

    @Test
    public void addOperandsTest(){
        Handler handler = new Handler();
        handler.add(1231.);
        handler.add(-123.);
        handler.add(0.245);
        handler.add(-90.245);

        System.out.println(handler.getOperands());
    }

    @Test
    public void addOperatorsTest(){
        Handler handler = new Handler();
        handler.add("-");
        handler.add("+");
        handler.add("/");
        handler.add("*");
        handler.add("-");

        System.out.println(handler.getOperators());
    }

    @Test
    public void expressionWithTwoOperandsTest(){
        Handler handler = new Handler();

        handler.add(124.);
        handler.add(4.);
        handler.add("/");

        System.out.println(handler.getOperators());
        System.out.println(handler.getOperands());

        System.out.println(handler.solve());
    }

    @Test
    public void expressionWithBigOperandsAmountTest(){
        Handler handler = new Handler();

        handler.add(1233.);
        handler.add(0.122);
        handler.add(92.654);
        handler.add("-");
        handler.add("/");
        handler.add(888.11);
        handler.add("*");

        System.out.println(handler.getOperands());
        System.out.println(handler.getOperators());

        System.out.println(handler.solve());
    }

    @Test
    public void divisionByZeroTest(){
        Handler handler = new Handler();

        handler.add(13.);
        handler.add("/");
        handler.add(0.);

        try {
            System.out.println(handler.solve());
        } catch (ArithmeticException e){
            e.printStackTrace();
        }
    }
}
