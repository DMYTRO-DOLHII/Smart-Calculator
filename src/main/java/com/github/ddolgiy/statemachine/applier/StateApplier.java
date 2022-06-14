package com.github.ddolgiy.statemachine.applier;

import com.github.ddolgiy.expressionhandler.Expression;
import com.github.ddolgiy.statemachine.state.State;

abstract public class StateApplier {

    protected String[] characters;

    public StateApplier(String[] characters){
        this.characters = characters;
    }

    public abstract State apply(Expression expression);
}
