package com.github.ddolgiy.statemachine.applier;

import com.github.ddolgiy.expressionhandler.Expression;
import com.github.ddolgiy.expressionhandler.Handler;
import com.github.ddolgiy.statemachine.state.OperandState;
import com.github.ddolgiy.statemachine.state.OperatorState;
import com.github.ddolgiy.statemachine.state.State;

public class OperatorStateApplier extends StateApplier {
    public OperatorStateApplier() {
        super(new String[]{"+", "-", "*", "/"});
    }

    @Override
    public State apply(Expression expression) {

        if (expression.isNotEnd() && contains(expression.get())) {
            OperatorState state = new OperatorState();
            state.set(expression.cut());

            return state;
        }
        return null;
    }
}
