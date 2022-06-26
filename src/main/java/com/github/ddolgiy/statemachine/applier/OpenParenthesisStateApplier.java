package com.github.ddolgiy.statemachine.applier;

import com.github.ddolgiy.expressionhandler.Handler;
import com.github.ddolgiy.expressionhandler.expression.Expression;
import com.github.ddolgiy.statemachine.state.State;

public class OpenParenthesisStateApplier extends StateApplier {
    public OpenParenthesisStateApplier() {
        super(new String[]{"("});
    }

    @Override
    public State apply(Expression expression, Handler handler) {
        return null;
    }
}
