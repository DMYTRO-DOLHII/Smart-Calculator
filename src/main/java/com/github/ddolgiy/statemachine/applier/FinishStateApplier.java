package com.github.ddolgiy.statemachine.applier;

import com.github.ddolgiy.exception.UnexpectedSymbolException;
import com.github.ddolgiy.expressionhandler.expression.Expression;

public class FinishStateApplier extends StateApplier{
    public FinishStateApplier() {
        super(new String[]{});
    }

    @Override
    public String apply(Expression expression) throws UnexpectedSymbolException {
        return null;
    }
}
