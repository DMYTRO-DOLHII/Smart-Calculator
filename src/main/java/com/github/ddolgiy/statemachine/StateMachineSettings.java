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

    private final State initState;


    /**
     * Initialize new objects
     */
    public StateMachineSettings(){
        transitions = new HashMap<>();
        handlers = new HashMap<>();
        initState = new InitialState();
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


    /**
     * Gets set of states which contains states that can be applied from current state
     *
     * @param state Particular state as a key in map
     * @return      Possible set of states that can be next state
     */
    public Set<State> getPossibleStates(State state){
        return transitions.get(state);
    }

    /**
     * Gets state applier for state that was given as argument
     *
     * @param state Particular state
     * @return      State applier for given state
     */
    public StateApplier getApplier(State state){
        return handlers.get(state);
    }

    public State getInitState() {
        return initState;
    }
}
