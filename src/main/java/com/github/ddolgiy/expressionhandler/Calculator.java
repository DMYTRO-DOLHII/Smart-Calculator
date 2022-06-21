package com.github.ddolgiy.expressionhandler;

public class Calculator {

    public Calculator(){

    }

    public Double plus(Double operand1, Double operand2){
        return operand1 + operand2;
    }

    public Double minus(Double operand1, Double operand2){
        return operand1 - operand2;
    }

    public Double multiply(Double operand1, Double operand2){
        return operand1 * operand2;
    }

    public Double division(Double operand1, Double operand2) throws ArithmeticException{
        return operand1 / operand2;
    }
}
