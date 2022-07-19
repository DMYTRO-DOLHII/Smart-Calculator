package com.github.ddolgiy.statemachine.applier.functions;

import com.github.ddolgiy.exception.UnexpectedSymbolException;
import com.github.ddolgiy.expressionhandler.Handler;
import com.github.ddolgiy.expressionhandler.expression.Expression;
import com.github.ddolgiy.statemachine.StateMachineSettings;
import com.github.ddolgiy.statemachine.applier.CloseParenthesisStateApplier;
import com.github.ddolgiy.statemachine.applier.OpenParenthesisStateApplier;
import com.github.ddolgiy.statemachine.applier.OperandStateApplier;
import com.github.ddolgiy.statemachine.applier.StateApplier;
import com.github.ddolgiy.statemachine.applier.separating.CommaStateApplier;
import com.github.ddolgiy.statemachine.state.State;

import java.util.Set;

public class MinStateApplier extends StateApplier {
    public MinStateApplier() {
        super("min(");
    }

    @Override
    public State apply(Expression expression, Handler handler) throws UnexpectedSymbolException {
        if(expression.startWith(this.function)){
            expression.cut(this.function.length());

            StateMachineSettings settings = new StateMachineSettings();

            settings.stateSetUp(
                    State.INITIAL,
                    Set.of(State.OPERAND, State.OPEN_PARENTHESIS),
                    null
            );

            settings.stateSetUp(
                    State.OPERAND,
                    Set.of(State.COMMA, State.CLOSE_PARENTHESIS),
                    new OperandStateApplier()
            );

            settings.stateSetUp(
                    State.COMMA,
                    Set.of(State.OPERAND),
                    new CommaStateApplier()
            );

            settings.stateSetUp(
                    State.OPEN_PARENTHESIS,
                    Set.of(State.COMMA, State.CLOSE_PARENTHESIS),
                    new OpenParenthesisStateApplier()
            );

            settings.stateSetUp(
                    State.CLOSE_PARENTHESIS,
                    Set.of(),
                    new CloseParenthesisStateApplier()
            );

            return State.MIN;
        }

        return null;
    }
}
