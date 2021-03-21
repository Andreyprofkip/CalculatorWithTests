package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TransformatorWithNegativeNumbersInfixExpressionTest {

        @ParameterizedTest
        @ValueSource(strings = "-32424.1241/(-1+2)*234.234914-124.24241-(-324+234)*(-124)")
        void checkPostfixToAnwerTest(String argument) {
            Assertions.assertEquals("0-32424.1241/(0-1+2)*234.234914-124.24241-(0-324+234)*(0-124)",
                    TransformatorWithNegativeNumbersInfixExpression.preparingExpression(argument));
        }
}



