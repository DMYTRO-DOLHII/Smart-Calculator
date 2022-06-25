package com.github.ddolgiy.statemachine.applier;

import com.github.ddolgiy.expressionhandler.expression.Expression;

public class OperatorStateApplier extends StateApplier {

    public OperatorStateApplier() {
        super(new String[]{"+", "-", "*", "/"});
    }

    @Override
    public String apply(Expression expression) {

        if (expression.isNotEnd() && contains(expression.get())) {
            return expression.cut();
        }
        return null;
    }
}
