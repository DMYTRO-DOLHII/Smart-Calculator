package com.github.ddolgiy.statemachine.applier;

import com.github.ddolgiy.expressionhandler.Handler;
import com.github.ddolgiy.expressionhandler.expression.Expression;
import com.github.ddolgiy.statemachine.state.State;

public class OperatorStateApplier extends StateApplier {

    public OperatorStateApplier() {
        super(new String[]{"+", "-", "*", "/"});
    }

    @Override
    public State apply(Expression expression, Handler handler) {

        if (expression.isNotEnd() && contains(expression.get())) {
            handler.add(expression.cut());
            return State.OPERATOR;
        }
        return null;
    }
}
