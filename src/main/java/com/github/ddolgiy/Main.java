package com.github.ddolgiy;

import com.github.ddolgiy.expressionhandler.expression.Expression;

public class Main {
    public static void main(String[] args) {
        ExpressionStateMachineExecutor executor = new ExpressionStateMachineExecutor();
        Expression expression = new Expression("9.5+1.1*0.1");
        executor.execute(expression);
    }
}
