package com.github.ddolgiy.statemachine;

import com.github.ddolgiy.statemachine.states.StateApplier;

import java.util.logging.Logger;

public class StateMachine<
        Content,
        State,
        Applier extends StateApplier<Content>,
        Settings extends StateMachineSettings<Content, State, Applier>> {

    private final static Logger logger = Logger.getAnonymousLogger();

    private final Settings settings;

    public StateMachine(Settings settings) {
        this.settings = settings;
    }
}
