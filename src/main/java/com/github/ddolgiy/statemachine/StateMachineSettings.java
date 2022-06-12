package com.github.ddolgiy.statemachine;

import com.github.ddolgiy.statemachine.states.States;
import com.github.ddolgiy.statemachine.states.StateApplier;

import java.util.Map;
import java.util.Set;

public class StateMachineSettings<Content, State, Applier extends StateApplier<Content>> {


    private Map<State, Set<State>> transitions;
    private Map<State, Applier> handlers;


    public void createNewTransition(State state, Set<State> possibleStates, Applier applier){
        transitions.put(state, possibleStates);
        handlers.put(state, applier);
    }

    public Set<State> getPossibleStates(State state){
        return transitions.get(state);
    }

    public Applier getApplier(State state){
        return handlers.get(state);
    }
}
