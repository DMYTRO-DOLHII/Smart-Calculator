package com.github.ddolgiy.statemachine;


import com.github.ddolgiy.statemachine.applier.FinishStateApplier;
import com.github.ddolgiy.statemachine.applier.OperandStateApplier;
import com.github.ddolgiy.statemachine.applier.OperatorStateApplier;
import com.github.ddolgiy.statemachine.state.State;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class StateMachineTest {

    private StateMachine machine;


    @Test
    public void initializeStateMachineWithoutSettingsTest(){
        machine = new StateMachine(null);
    }

    @Test
    public void initializeStateMachineWithSettings(){
        StateMachineSettings settings = new StateMachineSettings();

        settings.stateSetUp(
                State.INITIAL,
                Set.of(State.OPERAND, State.OPERATOR),
                null
        );

        settings.stateSetUp(
                State.OPERAND,
                Set.of(State.OPERATOR, State.FINISH),
                new OperandStateApplier()
        );

        settings.stateSetUp(
                State.OPERATOR,
                Set.of(State.OPERAND),
                new OperatorStateApplier()
        );

        settings.stateSetUp(
                State.FINISH,
                Set.of(),
                new FinishStateApplier()
        );

        machine = new StateMachine(settings);
    }
}
