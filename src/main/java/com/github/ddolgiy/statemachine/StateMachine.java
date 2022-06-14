package com.github.ddolgiy.statemachine;

import com.github.ddolgiy.statemachine.applier.OpenParenthesisStateApplier;
import com.github.ddolgiy.statemachine.applier.OperandStateApplier;
import com.github.ddolgiy.statemachine.applier.OperatorStateApplier;
import com.github.ddolgiy.statemachine.state.*;

import java.util.Set;

public class StateMachine {

    private final StateMachineSettings settings;

    private State currentState;


    public StateMachine() {
        this.settings = new StateMachineSettings();

        settings.stateSetUp(
                new InitialState(),
                Set.of(
                        new OperandState(),
                        new OpenParenthesisState()),
                null);

        settings.stateSetUp(
                new OperandState(),
                Set.of(
                        new OperatorState(),
                        new OperandState()),
                new OperandStateApplier()
        );

        settings.stateSetUp(
                new OperatorState(),
                Set.of(
                        new OperandState(),
                        new OpenParenthesisState()),
                new OperatorStateApplier()
        );

        settings.stateSetUp(
                new OpenParenthesisState(),
                Set.of(new OperandState()),
                new OpenParenthesisStateApplier()
        );

        currentState = new InitialState();
    }

    public State getCurrentState() {
        return currentState;
    }


    public void runStateMachine(){

    }

    public State tryToApplyState(){
        return null;
    }

    public State applyState(){
        return null;
    }


}
