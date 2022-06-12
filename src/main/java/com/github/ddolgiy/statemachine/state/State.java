package com.github.ddolgiy.statemachine.state;

import com.github.ddolgiy.statemachine.applier.StateApplier;

abstract public class State {

    protected final StateApplier applier;

    public State(StateApplier applier) {
        this.applier = applier;
    }

    public StateApplier getApplier(){
        return applier;
    }
}
