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
    private final Map<State, StateApplier> handlers;

    private State initialState;

    /**
     * Initialize new objects
     */
    public StateMachineSettings(){
        transitions = new HashMap<>();
        handlers = new HashMap<>();
        initialState = new InitialState();
    }

    /**
     * Set up map where key is state and value is set of possible states that can be applied
     * Set up map where key is state and value is state applier for this state
     *
     * @param state             Particular state
     * @param possibleStates    Set of possible states that can be applied
     * @param applier           State applier for particular state
     */
    public void stateSetUp(State state, Set<State> possibleStates, StateApplier applier){
        transitions.put(state, possibleStates);
        handlers.put(state, applier);
    }


    public Set<State> getPossibleStates(State state){
        return transitions.get(state);
    }

    public StateApplier getApplier(State state){
        return handlers.get(state);
    }
}
