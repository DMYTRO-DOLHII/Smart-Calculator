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
                        new OperatorState(),
                        new OpenParenthesisState()),
                null);

        settings.stateSetUp(
                new OperandState(),
                Set.of(
                        new OperandState(),
                        new OperatorState()),
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


    public void launch(){

    }

    public State applyState(){
        return null;
    }


}
