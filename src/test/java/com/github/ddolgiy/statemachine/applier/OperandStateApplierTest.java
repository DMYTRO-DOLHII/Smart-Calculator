package com.github.ddolgiy.statemachine.applier;

import com.github.ddolgiy.exception.UnexpectedSymbolException;
import com.github.ddolgiy.expressionhandler.Expression;
import com.github.ddolgiy.expressionhandler.Handler;
import com.github.ddolgiy.statemachine.state.State;
import org.junit.jupiter.api.Test;


public class OperandStateApplierTest {

    @Test
    public void testOperandStateApplier(){
        Expression expression = new Expression("12333-11");

        Handler handler = new Handler();

        OperandStateApplier operandStateApplier = new OperandStateApplier();

        try {
            State state = operandStateApplier.apply(expression, handler);
        } catch (UnexpectedSymbolException e) {
            e.printStackTrace();
        }

    }
}
