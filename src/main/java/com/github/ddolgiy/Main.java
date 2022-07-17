package com.github.ddolgiy;

import com.github.ddolgiy.expressionhandler.expression.Expression;

public class Main {
    public static void main(String[] args) {
        ExpressionStateMachineExecutor executor = new ExpressionStateMachineExecutor();
        Expression expression = new Expression("sqrt((-4))");
        executor.execute(expression);
        executor.printResult();
    }
}
