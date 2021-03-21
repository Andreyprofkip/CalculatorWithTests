package org.example;

import org.example.MyExceptions.IncorrectExpressionException;
import org.example.MyExceptions.NanException;

import java.util.Scanner;

import static java.lang.Double.*;


public class Main {
    public static void main(String[] args) throws NanException, IncorrectExpressionException {
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
        CheckingInfixExpression.checking(expression);
        String postfixExpression = InfixToPostfix.infixToPostfix(TransformatorWithNegativeNumbersInfixExpression.preparingExpression(expression));
        double answer;

            System.out.println("postFix expression:    " + postfixExpression);

            answer = CalculatorPostFixExpression.PostfixToAnswer(postfixExpression);

        if(answer == NaN || answer == NEGATIVE_INFINITY || answer == POSITIVE_INFINITY) throw new NanException("Dividing by zero, Input new expression, please");

            System.out.println("answer:    " + answer);

       }


}
