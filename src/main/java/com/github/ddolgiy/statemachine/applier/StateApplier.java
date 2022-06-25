package com.github.ddolgiy.statemachine.applier;

import com.github.ddolgiy.exception.UnexpectedSymbolException;
import com.github.ddolgiy.expressionhandler.expression.Expression;

abstract public class StateApplier {

    protected String[] characters;

    public StateApplier(String[] characters){
        this.characters = characters;
    }

    public abstract String apply(Expression expression) throws UnexpectedSymbolException;

    public boolean contains(String character){
        for (String c : characters){
            if (c.equals(character)){
                return true;
            }
        }
        return false;
    }
}
