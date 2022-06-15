package com.github.ddolgiy.statemachine.applier;

import com.github.ddolgiy.exception.UnexpectedSymbolException;
import com.github.ddolgiy.expressionhandler.Expression;
import com.github.ddolgiy.expressionhandler.Handler;
import com.github.ddolgiy.statemachine.state.OperandState;
import com.github.ddolgiy.statemachine.state.State;

public class OperandStateApplier extends StateApplier {

    private boolean isNegative = false;
    private boolean isDouble = false;

    public OperandStateApplier() {
        super(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"});
    }

    @Override
    public State apply(Expression expression, Handler handler) throws UnexpectedSymbolException {
        StringBuilder operand = new StringBuilder();

        if (expression.getExpression().startsWith("-")) {
            isNegative = true;
            operand.append(expression.cut());
        }

        while (expression.isNotEnd()) {
            if (contains(expression.get())) {
                if (expression.get().equals(".") && isDouble) {
                    throw new UnexpectedSymbolException();
                } else {
                    operand.append(expression.cut());
                    isDouble = true;
                }
                System.out.println("Check character : " + expression.get());
                operand.append(expression.cut());
            }
        }


        if (!operand.isEmpty()) {
            Double number = Double.parseDouble(operand.toString());
            handler.addOperand(number);
            System.out.println(number);
            return new OperandState();
        }

        return null;
    }
}
