package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InfixToPostfixTest {

    @ParameterizedTest
    @ValueSource(strings = "1+2-3/1000+(-1)+21-124*234/342-(-1-3)-265*1000000/234")
    void checkingInfixToPostfixTest(String argument) {
        Assertions.assertEquals("1 2 +3 1000 /- 1 - +21 +124 234 *342 /- 1 -3 - -265 1000000 *234/-", InfixToPostfix.infixToPostfix(argument));
    }

    @ParameterizedTest
    @ValueSource(strings = "12+123*1321")
    void checkingNegativeInfixToPostfixTest(String argument){
        Assertions.assertNotEquals("333", InfixToPostfix.infixToPostfix(argument));
    }
}