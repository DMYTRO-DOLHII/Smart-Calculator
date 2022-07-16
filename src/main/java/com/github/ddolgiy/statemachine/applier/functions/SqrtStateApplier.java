package com.github.ddolgiy.statemachine.applier.functions;

import com.github.ddolgiy.exception.UnexpectedSymbolException;
import com.github.ddolgiy.exception.UnresolvedException;
import com.github.ddolgiy.expressionhandler.Handler;
import com.github.ddolgiy.expressionhandler.expression.Expression;
import com.github.ddolgiy.statemachine.StateMachine;
import com.github.ddolgiy.statemachine.StateMachineSettings;
import com.github.ddolgiy.statemachine.applier.*;
import com.github.ddolgiy.statemachine.state.State;

import java.util.Set;

public class SqrtStateApplier extends StateApplier {
    public SqrtStateApplier(String[] characters) {
        super("sqrt(");
    }

    @Override
    public State apply(Expression expression, Handler handler) throws UnexpectedSymbolException {
        if(expression.startWith(this.function)){
            expression.cut(5);

            StateMachineSettings settings = new StateMachineSettings();

            settings.stateSetUp(
                    State.INITIAL,
                    Set.of(State.OPERAND, State.OPEN_PARENTHESIS),
                    null
            );

            settings.stateSetUp(
                    State.OPERAND,
                    Set.of(State.OPERATOR, State.CLOSE_PARENTHESIS),
                    new OperandStateApplier()
            );

            settings.stateSetUp(
                    State.OPERATOR,
                    Set.of(State.OPERAND, State.OPEN_PARENTHESIS),
                    new OperatorStateApplier()
            );

            settings.stateSetUp(
                    State.OPEN_PARENTHESIS,
                    Set.of(State.OPERATOR, State.OPEN_PARENTHESIS),
                    new OpenParenthesisStateApplier()
            );

            settings.stateSetUp(
                    State.CLOSE_PARENTHESIS,
                    Set.of(),
                    new CloseParenthesisStateApplier()
            );


            StateMachine functionStateMachine = new StateMachine(settings);

            try {
                functionStateMachine.run(expression);
            } catch (UnresolvedException e) {
                throw new RuntimeException(e);
            }

            handler.add(Math.sqrt(functionStateMachine.getResult()));

            return State.SQRT;
        }

        return null;
    }
}
