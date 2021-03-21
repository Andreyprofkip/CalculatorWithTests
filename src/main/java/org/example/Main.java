package org.example;

import org.example.MyExceptions.IncorrectExpressionException;
import org.example.MyExceptions.NanException;
import java.util.Scanner;
import static java.lang.Double.*;


public class Main {
    public static void main(String[] args) throws NanException, IncorrectExpressionException {
        getAnswer(new Scanner(System.in).nextLine());
    }
    public static double getAnswer(String expression)throws NanException, IncorrectExpressionException {
        CheckingInfixExpression.checking(expression);
        String postfixExpression = InfixToPostfix.infixToPostfix(TransformatorWithNegativeNumbersInfixExpression.preparingExpression(expression));
        System.out.println("postFix expression:    " + postfixExpression);
        double answer = CalculatorPostFixExpression.PostfixToAnswer(postfixExpression);
            if (answer == NaN || answer == NEGATIVE_INFINITY || answer == POSITIVE_INFINITY)
                throw new NanException("Dividing by zero, Input new expression, please");
            System.out.println("answer:    " + answer);
        return answer;
    }

}
