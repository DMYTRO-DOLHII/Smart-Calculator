package com.github.ddolgiy.statemachine.applier;

import com.github.ddolgiy.exception.UnexpectedSymbolException;
import com.github.ddolgiy.exception.UnresolvedException;
import com.github.ddolgiy.expressionhandler.Handler;
import com.github.ddolgiy.expressionhandler.expression.Expression;
import com.github.ddolgiy.statemachine.StateMachine;
import com.github.ddolgiy.statemachine.StateMachineSettings;
import com.github.ddolgiy.statemachine.state.State;

import java.util.Set;

public class OpenParenthesisStateApplier extends StateApplier {

    private StateMachine internalSteteMachine;

    public OpenParenthesisStateApplier() {
        super(new String[]{"("});
    }

    @Override
    public State apply(Expression expression, Handler handler) {


        if (contains(expression.get())) {
            expression.cut();

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
                    Set.of(State.OPERATOR, State.CLOSE_PARENTHESIS),
                    new OpenParenthesisStateApplier()
            );

            settings.stateSetUp(
                    State.CLOSE_PARENTHESIS,
                    Set.of(),
                    new CloseParenthesisStateApplier()
            );

            internalSteteMachine = new StateMachine(settings);

            try {
                internalSteteMachine.run(expression);
            } catch (UnexpectedSymbolException | UnresolvedException e) {
                throw new RuntimeException(e);
            }

            handler.add(internalSteteMachine.getResult());

            return State.OPEN_PARENTHESIS;
        }

        return null;
    }
}
