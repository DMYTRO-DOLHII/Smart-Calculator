package com.github.ddolgiy.expressionhandler;

public class Calculator {

    private Double lastResult;

    public Calculator(){
        lastResult = 0.;
    }

    public void plus(Double operand1, Double operand2){
        lastResult =  operand1 + operand2;
    }

    public void minus(Double operand1, Double operand2){
        lastResult = operand1 - operand2;
    }

    public void multiply(Double operand1, Double operand2){
        lastResult = operand1 * operand2;
    }

    public void division(Double operand1, Double operand2) throws ArithmeticException{
        lastResult = operand1 / operand2;
    }

    public Double getLastResult(){
        return lastResult;
    }
}
