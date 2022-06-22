package com.github.ddolgiy.statemachine;

import com.github.ddolgiy.exception.UnexpectedSymbolException;
import com.github.ddolgiy.exception.UnresolvedException;
import com.github.ddolgiy.expressionhandler.Expression;
import com.github.ddolgiy.expressionhandler.Handler;
import com.github.ddolgiy.statemachine.applier.FinishStateApplier;
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

        settings.stateSetUp(
                new FinishState(),
                Set.of(),
                new FinishStateApplier()
        );

        handler = new Handler();
    }


    public void run(Expression expression) {
        State appliedState = settings.getInitState();
        Set<State> nextStates = settings.getPossibleStates(appliedState);

        while(nextStates.size() > 0){
            try {
                appliedState = tryToApplyNextState(nextStates, expression);

                if(appliedState == null){
                    throw new UnresolvedException();
                }

                handler.add(appliedState.get());
            } catch (UnexpectedSymbolException | UnresolvedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("State machine finished working!");

    }

    public State tryToApplyNextState(Set<State> nextStates, Expression expression) throws UnexpectedSymbolException {
        for (State possible : nextStates) {
            State next = settings.getApplier(possible).apply(expression);

            if (next != null) {
                return next;
            }
        }
        return null;
    }
}
