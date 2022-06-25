package com.github.ddolgiy.statemachine.applier;

import com.github.ddolgiy.exception.UnexpectedSymbolException;
import com.github.ddolgiy.expressionhandler.expression.Expression;

public class OperandStateApplier extends StateApplier {

    private boolean isDouble = false;

    public OperandStateApplier() {
        super(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "."});
    }

    @Override
    public String apply(Expression expression) throws UnexpectedSymbolException {
        StringBuilder operand = new StringBuilder();

        if (expression.getExpression().startsWith("-")) {
            operand.append(expression.cut());
        }

        while (expression.isNotEnd() && contains(expression.get())) {
            if(expression.get().equals(".")){
                if (isDouble) throw new UnexpectedSymbolException();
                else isDouble = true;
            } else {
                operand.append(expression.cut());
            }
        }


        if (!operand.isEmpty()) {
            return operand.toString();
        }

        return null;
    }
}
