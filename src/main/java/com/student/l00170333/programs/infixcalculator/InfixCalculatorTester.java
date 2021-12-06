package com.student.l00170333.programs.infixcalculator;

import com.student.l00170333.calculator.InfixCalculator;

import java.util.Scanner;

public class InfixCalculatorTester {
    public static void main(String[] args) throws Exception {
        System.out.println("Enter infix expression:");
        Scanner sc = new Scanner(System.in);
        String expression = sc.nextLine();
        System.out.println("Result: " + InfixCalculator.evaluate(expression));
    }
}