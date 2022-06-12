package com.github.ddolgiy.statemachine.states;

public interface StateApplier<Content> {

    public void apply(Content content);
}
