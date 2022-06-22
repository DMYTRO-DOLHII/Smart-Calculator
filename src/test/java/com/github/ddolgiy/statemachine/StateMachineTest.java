package com.github.ddolgiy.statemachine;

import com.github.ddolgiy.expressionhandler.Expression;
import com.github.ddolgiy.expressionhandler.Handler;
import org.junit.jupiter.api.Test;

public class StateMachineTest {

    @Test
    public void findEverythingTest(){
        Handler handler = new Handler();

        Expression expression = new Expression("155-11");

        StateMachine stateMachine = new StateMachine();

        stateMachine.run(expression);
    }
}
