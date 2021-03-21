package org.example;

import org.example.MyExceptions.IncorrectExpressionException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;


public class CheckingInfixExpressionTest {

    @ParameterizedTest
    @MethodSource("org.example.StringsProviders#tinyStrings")
    void checkingIncorrectSymbolsTest(String tinyStrings) {
        Assertions.assertThrows(IncorrectExpressionException.class, () ->
                CheckingInfixExpression.checking(tinyStrings));
    }

    @ParameterizedTest
    @MethodSource("org.example.StringsProviders#RepeatSymbols")
    void checkingDoubleSymbolsTest(String RepeatSymbols) {
        Assertions.assertThrows(IncorrectExpressionException.class, () ->
                CheckingInfixExpression.checking(RepeatSymbols));
    }
}

class StringsProviders {
    static Stream<String> tinyStrings() {
        return Stream.of("H", ","," ", "@", "&", "!","?","%");
    }
    static Stream<String> RepeatSymbols() {
        return Stream.of("++", "--","** ", "//");
    }
}