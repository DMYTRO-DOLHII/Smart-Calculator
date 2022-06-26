package com.github.ddolgiy.statemachine;

import com.github.ddolgiy.exception.UnexpectedSymbolException;
import com.github.ddolgiy.exception.UnresolvedException;
import com.github.ddolgiy.expressionhandler.expression.Expression;
import com.github.ddolgiy.expressionhandler.Handler;
import com.github.ddolgiy.statemachine.state.*;

import java.util.Set;

public class StateMachine {

    private final StateMachineSettings settings;
    private final Handler handler;


    public StateMachine(StateMachineSettings settings) {
        this.settings = settings;
        handler = new Handler();
    }


    public void run(Expression expression) throws UnexpectedSymbolException, UnresolvedException {
        State appliedState = settings.getInitState();
        Set<State> nextStates = settings.getPossibleStates(appliedState);

        while (nextStates.size() > 0) {
            appliedState = tryToApplyNextState(nextStates, expression);

            if (appliedState == null) {
                throw new UnresolvedException();
            }

            nextStates = settings.getPossibleStates(appliedState);

        }


    }

    public State tryToApplyNextState(Set<State> nextStates, Expression expression) throws UnexpectedSymbolException {
        for (State possibleState : nextStates) {
            if (settings.getApplier(possibleState).apply(expression, handler) != null) {
                return possibleState;
            }
        }

        return null;
    }
}
