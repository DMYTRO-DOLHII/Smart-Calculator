package com.github.ddolgiy.statemachine.applier;

import com.github.ddolgiy.expressionhandler.Expression;
import com.github.ddolgiy.statemachine.state.State;

public interface StateApplier {

    public State apply(Expression expression);
}
