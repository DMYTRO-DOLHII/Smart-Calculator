package com.github.ddolgiy;

import com.github.ddolgiy.expressionhandler.content.StringExpressionContent;
import com.github.ddolgiy.statemachine.StateMachine;
import com.github.ddolgiy.statemachine.StateMachineSettings;
import com.github.ddolgiy.statemachine.states.StateApplier;
import com.github.ddolgiy.statemachine.states.States;

import java.util.EnumSet;

public class StateMachineExecutor {

    private final StateMachine<
            StringExpressionContent,
            States,
            StateApplier<StringExpressionContent>,
            StateMachineSettings<StringExpressionContent, States, StateApplier<StringExpressionContent>>> stateMachine;

    public StateMachineExecutor(){
        StateMachineSettings<
                StringExpressionContent,
                States,
                StateApplier<StringExpressionContent>> settings = new StateMachineSettings<>();

        settings.createNewTransition(States.INITIAL_STATE, EnumSet.of(
                States.OPERAND,
                States.FUNCTION,
                States.OPEN_BRACKET), null);


        stateMachine = new StateMachine<>(settings);
    }
}
