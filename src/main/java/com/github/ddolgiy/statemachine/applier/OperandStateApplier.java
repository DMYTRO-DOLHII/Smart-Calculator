package com.github.ddolgiy.statemachine.applier;

import com.github.ddolgiy.exception.UnexpectedSymbolException;
import com.github.ddolgiy.expressionhandler.Handler;
import com.github.ddolgiy.expressionhandler.expression.Expression;
import com.github.ddolgiy.statemachine.state.State;

public class OperandStateApplier extends StateApplier {

    private boolean isDouble = false;

    public OperandStateApplier() {
        super(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "."});
    }

    @Override
    public State apply(Expression expression, Handler handler) throws UnexpectedSymbolException {
        StringBuilder operand = new StringBuilder();

        if (expression.get().equals("-")) {
            operand.append(expression.cut());
        }

        while (expression.isNotEnd() && contains(expression.get())) {
            if(expression.get().equals(".")){
                if (isDouble) throw new UnexpectedSymbolException();
                else {
                    isDouble = true;
                    operand.append(expression.cut());
                }
            } else {
                operand.append(expression.cut());
            }
        }


        if (!operand.isEmpty()) {
            Double res = Double.parseDouble(operand.toString());
            handler.add(res);

            System.out.println("Found in expression operand : " + operand);
            return State.OPERAND;
        }

        return null;
    }
}
