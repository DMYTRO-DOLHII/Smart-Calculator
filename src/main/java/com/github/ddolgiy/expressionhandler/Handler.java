package com.github.ddolgiy.expressionhandler;

import com.github.ddolgiy.expressionhandler.storage.Operands;
import com.github.ddolgiy.expressionhandler.storage.Operators;

import java.util.ArrayList;

public class Handler {

    private final Operands operands;
    private final Operators operators;
    private final Calculator calculator;

    public Handler() {
        operands = new Operands();
        operators = new Operators();
        calculator = new Calculator();
    }

    public void add(String str) {
        if (str.length() > 1) {
            operands.add(Double.parseDouble(str));
        } else {
            operators.add(str);
        }
    }

    public Double removeOperand(int i) {
        return operands.remove(i);
    }

    public String removeOperator(int i) {
        return operators.remove(i);
    }

    public Double solve() {
        while (operators.size() != 0) {
            for (int i = 0; i < operators.size(); i++) {

            }
        }

        return 0.;
    }

    public ArrayList<Double> getOperands(){
        return operands.getStorage();
    }

    public ArrayList<String> getOperators(){
        return operators.getStorage();
    }
}