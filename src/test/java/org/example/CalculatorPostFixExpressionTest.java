package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculatorPostFixExpressionTest  {

    @ParameterizedTest      //1+12.34-141.410/12341-(1432-32414)/(-1234)*(-1234)+1324.124
    @ValueSource(strings = "1 12.34 +141.410 12341 /-1432 32414 - 0 1234 - /0 1234 - *-1324.124+")
    void checkPostfixToAnwerTest(String argument) {
        Assertions.assertEquals(32319.45254144721, CalculatorPostFixExpression.PostfixToAnswer(argument));
    }
}

