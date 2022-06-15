package com.github.ddolgiy.expressionhandler;

import com.github.ddolgiy.expressionhandler.storage.OperandsOperatorsStorage;

import java.util.ArrayList;

public class Handler {

    private OperandsOperatorsStorage storage;
    private Calculator calculator;

    public Handler(){
        storage = new OperandsOperatorsStorage();
        calculator = new Calculator();
    }

    public void addOperand(Double operand){
        storage.addOperand(operand);
    }

    public ArrayList<Double> getOperands(){
        return storage.getOperands();
    }
}
