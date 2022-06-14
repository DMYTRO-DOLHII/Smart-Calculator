package com.github.ddolgiy.statemachine.applier;

import com.github.ddolgiy.expressionhandler.Expression;
import com.github.ddolgiy.statemachine.state.State;

public class OperandStateApplier extends StateApplier {

    public OperandStateApplier() {
        super(new String[]{"-", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "."});
    }

    @Override
    public State apply(Expression expression) {


        while(expression.isNotEnd()){

        }
        return null;
    }
}
