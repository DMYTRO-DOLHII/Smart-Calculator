package com.github.ddolgiy.statemachine.applier;

import com.github.ddolgiy.expressionhandler.expression.Expression;

public class OpenParenthesisStateApplier extends StateApplier {
    public OpenParenthesisStateApplier() {
        super(new String[]{"("});
    }

    @Override
    public String apply(Expression expression) {
        return null;
    }
}
