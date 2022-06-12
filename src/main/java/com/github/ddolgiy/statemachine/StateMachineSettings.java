package com.github.ddolgiy.statemachine;

import com.github.ddolgiy.statemachine.applier.StateApplier;
import com.github.ddolgiy.statemachine.state.InitialState;
import com.github.ddolgiy.statemachine.state.State;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * State Machine settings class.
 */
public class StateMachineSettings {

    private final Map<State, Set<State>> transitions;
    private State initialState;

    /**
     * Initialize new objects
     */
    public StateMachineSettings(){
        transitions = new HashMap<>();
        initialState = new InitialState(null);
    }

    public void stateSetUp(State state, Set<State> possibleStates){
        transitions.put(state, possibleStates);
    }


    public Set<State> getPossibleStates(State state){
        return transitions.get(state);
    }
}
