package com.github.ddolgiy.statemachine.state;

import com.github.ddolgiy.statemachine.applier.StateApplier;

abstract public class State {

    private String content;

    public void set(String content){
        this.content = content;
    }

    public String get(){
        return content;
    }

    public boolean containsResult(){
        return content != null;
    }

}
