package com.github.ddolgiy.statemachine;

import com.github.ddolgiy.exception.UnexpectedSymbolException;
import com.github.ddolgiy.expressionhandler.Expression;
import com.github.ddolgiy.expressionhandler.Handler;
import com.github.ddolgiy.statemachine.applier.OpenParenthesisStateApplier;
import com.github.ddolgiy.statemachine.applier.OperandStateApplier;
import com.github.ddolgiy.statemachine.applier.OperatorStateApplier;
import com.github.ddolgiy.statemachine.state.*;

import java.util.Set;

public class StateMachine {

    private final StateMachineSettings settings;
    private final Handler handler;


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
                        new FinishState()),
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

        handler = new Handler();
    }


    public void run() {
        State appliedState = settings.getInitState();



    }

    public State tryToApplyNextState(State state, Expression expression) throws UnexpectedSymbolException {
        for (State possible : settings.getPossibleStates(state)) {
            State next = settings.getApplier(possible).apply(expression);

            if (next != null) {
                return next;
            }
        }
        return null;
    }
}
