package com.github.ddolgiy.statemachine;

import com.github.ddolgiy.StateMachineExecutor;
import com.github.ddolgiy.exception.UnexpectedSymbolException;
import com.github.ddolgiy.exception.UnresolvedException;
import com.github.ddolgiy.expressionhandler.expression.Expression;
import com.github.ddolgiy.expressionhandler.Handler;
import org.junit.jupiter.api.Test;

public class StateMachineTest {

    private StateMachineExecutor machine;

    @Test
    public void initializeStateMachineTest() {
        machine = new StateMachineExecutor();
    }

    @Test
    public void runStateMachineTest() {
        machine = new StateMachineExecutor();

        Expression expression = new Expression("15+11");

        machine.execute(expression);
    }
}
