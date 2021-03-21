package org.example;

import org.example.MyExceptions.IncorrectExpressionException;
import org.example.MyExceptions.NanException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.stream.Collectors;

public class MainTest {

    @Test
    public void shouldProcessUserInput() {
        ByteArrayInputStream in = new ByteArrayInputStream("1234+234124.9923".getBytes(Charset.defaultCharset()));
        String result = new BufferedReader(new InputStreamReader(in))
                .lines().collect(Collectors.joining("\n"));
        Assertions.assertEquals("1234+234124.9923", result);
    }

    @ParameterizedTest(name = "Find answer: {0} = -34943.750682356615 .")
    @ValueSource(strings = "1+2-234234/983414*92394-12939.9293477")
    public void checkGetAnswer(String argument) {
        try {
            Assertions.assertEquals(-34943.750682356615, Main.getAnswer(argument));
        } catch (NanException ex) {
            System.out.println("Dividing by zero");
        } catch (IncorrectExpressionException ex) {
            System.out.println("Incorrect symbols");
        }
    }

    @ParameterizedTest(name = "Catch Nanexception in: {0}  .")
    @ValueSource(strings = {"1+2-234234/983414*92394/0-12939.9293477", "1/0-1000","1/0+1000", "1/0"} )
    public void checkCatchNanexception(String argument) {
          Assertions.assertThrows(NanException.class, () ->
                    Main.getAnswer(argument));
    }
}
