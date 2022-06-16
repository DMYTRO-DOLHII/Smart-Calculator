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
}
