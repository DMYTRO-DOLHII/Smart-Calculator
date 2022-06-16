package com.github.ddolgiy.statemachine.applier;

import com.github.ddolgiy.exception.UnexpectedSymbolException;
import com.github.ddolgiy.expressionhandler.Expression;
import com.github.ddolgiy.expressionhandler.Handler;
import com.github.ddolgiy.statemachine.state.State;
import org.junit.jupiter.api.Test;


public class OperandStateApplierTest {

    @Test
    public void positiveIntegerTest() {
        Expression expression = new Expression("12333-11");

        Handler handler = new Handler();

        OperandStateApplier operandStateApplier = new OperandStateApplier();

        try {
            State state = operandStateApplier.apply(expression, handler);
        } catch (UnexpectedSymbolException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void negativeIntegerTest() {
        Expression expression = new Expression("-231/11");

        Handler handler = new Handler();

        OperandStateApplier operandStateApplier = new OperandStateApplier();

        try {
            State state = operandStateApplier.apply(expression, handler);
        } catch (UnexpectedSymbolException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void positiveDoubleTest() {
        Expression expression = new Expression("231.894304000/11");

        Handler handler = new Handler();

        OperandStateApplier operandStateApplier = new OperandStateApplier();

        try {
            State state = operandStateApplier.apply(expression, handler);
        } catch (UnexpectedSymbolException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void negativeDoubleTest() {
        Expression expression = new Expression("-0.123503/11");

        Handler handler = new Handler();

        OperandStateApplier operandStateApplier = new OperandStateApplier();

        try {
            State state = operandStateApplier.apply(expression, handler);
        } catch (UnexpectedSymbolException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void twoPointsTest(){
        Expression expression = new Expression("-0.12.3503/11");

        Handler handler = new Handler();

        OperandStateApplier operandStateApplier = new OperandStateApplier();

        try {
            State state = operandStateApplier.apply(expression, handler);
        } catch (UnexpectedSymbolException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void emptyExpressionTest(){
        Expression expression = new Expression("");

        Handler handler = new Handler();

        OperandStateApplier operandStateApplier = new OperandStateApplier();

        try {
            State state = operandStateApplier.apply(expression, handler);
        } catch (UnexpectedSymbolException e) {
            e.printStackTrace();
        }
    }
}
