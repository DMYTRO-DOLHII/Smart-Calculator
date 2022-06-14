package com.github.ddolgiy.expressionhandler.storage;

import java.util.ArrayList;

abstract public class Storage {

    private final ArrayList<Double> operands;
    private final ArrayList<String> operators;

    public Storage(){
        operands = new ArrayList<>();
        operators = new ArrayList<>();
    }

    public void addOperand(Double operand){
        operands.add(operand);
    }

    public void addOperator(String operator){
        operators.add(operator);
    }

    public Double removeOperand(int i){
        return operands.remove(i);
    }

    public String removeOperator(int i){
        return operators.remove(i);
    }
}
