package com.github.ddolgiy.statemachine.applier;

import com.github.ddolgiy.expressionhandler.Handler;
import com.github.ddolgiy.expressionhandler.expression.Expression;
import com.github.ddolgiy.statemachine.state.State;

public class CloseParenthesisStateApplier extends StateApplier {
    public CloseParenthesisStateApplier() {
        super(new String[]{")"});
    }

    @Override
    public State apply(Expression expression, Handler handler) {

        if(contains(expression.get())){
            expression.cut();
            return State.CLOSE_PARENTHESIS;
        }

        return null;
    }
}
