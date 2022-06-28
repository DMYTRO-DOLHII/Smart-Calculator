package com.github.ddolgiy;

import com.github.ddolgiy.expressionhandler.expression.Expression;
import org.junit.jupiter.api.Test;

public class ExpressionStateMachineExecutorTest {

    @Test
    public void initializeTest(){
        ExpressionStateMachineExecutor executor = new ExpressionStateMachineExecutor();
    }

    @Test
    public void executeWithoutParenthesisTest(){
        ExpressionStateMachineExecutor executor = new ExpressionStateMachineExecutor();

        Expression expression = new Expression("1414+3849*10/1111-14");

        executor.execute(expression);

        executor.printResult();
    }

    @Test
    public void executeWithParenthesisTest(){
        ExpressionStateMachineExecutor executor = new ExpressionStateMachineExecutor();

        Expression expression = new Expression("8173-(17739+928/222+19*154)/554-1000");

//        Expression expression = new Expression("(5*(15-3-2)/2)/5");

        executor.execute(expression);

        executor.printResult();
    }
}
