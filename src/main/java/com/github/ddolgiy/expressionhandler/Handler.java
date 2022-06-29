package com.github.ddolgiy.expressionhandler;

import com.github.ddolgiy.expressionhandler.storage.Operands;
import com.github.ddolgiy.expressionhandler.storage.Operators;

import java.util.ArrayList;
import java.util.logging.Logger;

public class Handler {

    private final Operands operands;
    private final Operators operators;
    private final Calculator calculator;


    public Handler() {
        operands = new Operands();
        operators = new Operators();
        calculator = new Calculator();
    }

    public void add(String operator) {
        operators.add(operator);
    }

    public void add(Double operand) {
        operands.add(operand);
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
                boolean isCalculated = false;

                switch (operators.get(i)) {
                    case "*":
                        calculator.multiply(operands.get(i), operands.get(i + 1));
                        isCalculated = true;
                        break;
                    case "/":
                        calculator.division(operands.get(i), operands.get(i + 1));
                        isCalculated = true;
                        break;
                    case "+":
                        if (i < operators.size() - 1) {
                            if (operators.get(i + 1).equals("+") || operators.get(i + 1).equals("-")) {
                                calculator.plus(operands.get(i), operands.get(i + 1));
                                isCalculated = true;
                            }
                        } else {
                            calculator.plus(operands.get(i), operands.get(i + 1));
                            isCalculated = true;
                        }
                        break;
                    case "-":
                        if (i < operators.size() - 1) {
                            if (operators.get(i + 1).equals("+") || operators.get(i + 1).equals("-")) {
                                if(operands.get(i + 1) == 0);
                                calculator.minus(operands.get(i), operands.get(i + 1));
                                isCalculated = true;
                            }
                        } else {
                            calculator.minus(operands.get(i), operands.get(i + 1));
                            isCalculated = true;
                        }
                        break;
                }



                if (isCalculated) {
                    System.out.println(operands.get(i) + operators.get(i) + operands.get(i + 1) + " = " + calculator.getLastResult());
                    operators.remove(i);
                    operands.remove(i + 1);
                    operands.replace(i, calculator.getLastResult());
                    break;
                }
            }
        }

        return operands.get(0);
    }

    public ArrayList<Double> getOperands() {
        return operands.getStorage();
    }

    public ArrayList<String> getOperators() {
        return operators.getStorage();
    }
}