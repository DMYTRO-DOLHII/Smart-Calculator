package com.github.ddolgiy;

import com.github.ddolgiy.exception.UnexpectedSymbolException;
import com.github.ddolgiy.exception.UnresolvedException;
import com.github.ddolgiy.expressionhandler.expression.Expression;
import com.github.ddolgiy.statemachine.StateMachine;
import com.github.ddolgiy.statemachine.StateMachineSettings;
import com.github.ddolgiy.statemachine.applier.FinishStateApplier;
import com.github.ddolgiy.statemachine.applier.OpenParenthesisStateApplier;
import com.github.ddolgiy.statemachine.applier.OperandStateApplier;
import com.github.ddolgiy.statemachine.applier.OperatorStateApplier;
import com.github.ddolgiy.statemachine.state.State;

import java.util.Set;

public class ExpressionStateMachineExecutor {

    private final StateMachine globalStateMachine;

    public ExpressionStateMachineExecutor(){
        StateMachineSettings settings = new StateMachineSettings();

        settings.stateSetUp(
                State.INITIAL,
                Set.of(State.OPERAND, State.OPEN_PARENTHESIS),
                null);

        settings.stateSetUp(
                State.OPERAND,
                Set.of(
                        State.OPERATOR,
                        State.FINISH),
                new OperandStateApplier()
        );

        settings.stateSetUp(
                State.OPERATOR,
                Set.of(
                        State.OPERAND,
                        State.OPEN_PARENTHESIS),
                new OperatorStateApplier()
        );

        settings.stateSetUp(
                State.OPEN_PARENTHESIS,
                Set.of(State.OPERATOR, State.FINISH),
                new OpenParenthesisStateApplier()
        );

        settings.stateSetUp(
                State.FINISH,
                Set.of(),
                new FinishStateApplier()
        );

        globalStateMachine = new StateMachine(settings);
    }

    public void execute(Expression expression){
        try {
            globalStateMachine.run(expression);
        } catch (UnexpectedSymbolException | UnresolvedException e) {
            e.printStackTrace();
        }
    }

    public void printResult(){
        System.out.println(globalStateMachine.getResult());
    }
}
