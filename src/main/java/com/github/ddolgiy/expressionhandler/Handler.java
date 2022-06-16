package com.github.ddolgiy.expressionhandler;

import com.github.ddolgiy.expressionhandler.storage.Operands;
import com.github.ddolgiy.expressionhandler.storage.Operators;

public class Handler {

    private final Operands operands;
    private final Operators operators;
    private final Calculator calculator;

    public Handler(){
        operands = new Operands();
        operators = new Operators();
        calculator = new Calculator();
    }

    public void addOperand(Double operand){
        operands.add(operand);
    }

    public Double removeOperand(int i){
        return operands.remove(i);
    }

    public void addOperator(String operator){
        operators.add(operator);
    }

    public String removeOperator(int i){
        return operators.remove(i);
    }
}
