package com.github.ddolgiy.statemachine.applier;

import com.github.ddolgiy.expressionhandler.expression.Expression;

public class CloseParenthesisStateApplier extends StateApplier {
    public CloseParenthesisStateApplier() {
        super(new String[]{")"});
    }

    @Override
    public String apply(Expression expression) {
        return null;
    }
}
