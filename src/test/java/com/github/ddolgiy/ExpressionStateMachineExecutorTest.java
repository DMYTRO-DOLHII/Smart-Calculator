package com.github.ddolgiy;

import com.github.ddolgiy.expressionhandler.expression.Expression;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.google.common.truth.Truth.assertThat;

public class ExpressionStateMachineExecutorTest {

    private static ExpressionStateMachineExecutor executor;

    @BeforeEach
    void setup() {
        executor = new ExpressionStateMachineExecutor();
    }

    @ParameterizedTest
    @MethodSource("values")
    void execute(String input, double expectedResult) {
        double actual = executor.execute(new Expression(input));

        assertThat(actual).isWithin(0.9).of(expectedResult);
    }

    private static Stream<Arguments> values() {
        return Stream.of(
                Arguments.of("8173-(17739+928/222+19*154)/554-1000", 7135d),
                Arguments.of("1414+3849*10/1111-14", 1434d),
                Arguments.of("2+2*2", 6d),
                Arguments.of("-4+4", 0d),
                Arguments.of("2+(-2)", 0d),
                Arguments.of("5-(2+(-2))*3", 5d),
                Arguments.of("((2+2)*2)", 8d)
        );
    }
}
