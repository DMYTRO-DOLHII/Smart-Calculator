package com.github.ddolgiy.statemachine;

import com.github.ddolgiy.statemachine.state.InitialState;

import java.util.Set;

public class StateMachine {

    private final StateMachineSettings settings;

    public StateMachine() {
        this.settings = new StateMachineSettings();

        settings.stateSetUp(
                new InitialState(null),
                Set.of(
                        null
                ));
    }
}
