package com.github.ddolgiy.statemachine.state;

import com.github.ddolgiy.statemachine.applier.StateApplier;

abstract public class State<InputContent> {

    private InputContent content;

    public void set(InputContent content){
        this.content = content;
    }

    public InputContent get(){
        return content;
    }

}
