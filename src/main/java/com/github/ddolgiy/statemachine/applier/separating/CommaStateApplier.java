package com.github.ddolgiy.statemachine.applier.separating;

import com.github.ddolgiy.exception.UnexpectedSymbolException;
import com.github.ddolgiy.expressionhandler.Handler;
import com.github.ddolgiy.expressionhandler.expression.Expression;
import com.github.ddolgiy.statemachine.applier.StateApplier;
import com.github.ddolgiy.statemachine.state.State;

public class CommaStateApplier extends StateApplier {
    public CommaStateApplier() {
        super(new String[]{","});
    }

    @Override
    public State apply(Expression expression, Handler handler) throws UnexpectedSymbolException {
        if(contains(expression.get())){
            return State.COMMA;
        }
        return null;
    }
}
