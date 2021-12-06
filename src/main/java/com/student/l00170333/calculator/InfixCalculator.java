package com.student.l00170333.calculator;

import com.student.l00170333.generics.GenericArrayList;
import com.student.l00170333.generics.GenericStack;

public class InfixCalculator {
    /**
     * This method evaluates an Infix expression.
     *
     * @param expression A fully parenthesized infix arithmetic expression must start a '(' character
     *                   and end with a ')' character.
     * @return the result of the evaluated infix expression.
     * @throws NumberFormatException if the inputted expression does not start with '(' and end with ')'
     */
    public static double evaluate(String expression) throws NumberFormatException {
        // check that the expression starts with '(' and ends with ')'
        if (!expression.trim().startsWith("("))
            throw new NumberFormatException("Your input must start with a '('");
        if (!expression.trim().endsWith(")"))
            throw new NumberFormatException("Your input must end with a ')'");

        GenericStack<String> operators = new GenericStack<>();
        GenericStack<Double> operands = new GenericStack<>();

        // Parse/break up each part of the expression into our GenericArrayList
        GenericArrayList<String> expressionParts = InfixCalculator.parseExpression(expression);

        for (String part : expressionParts) {
            if (part.trim().equals("")) {
                continue;
            }

            switch (part) {
                case ("("):
                    break;
                case ("+"):
                case ("-"):
                case ("*"):
                case ("/"):
                    operators.push(part);
                    break;
                case (")"):
                    double rightOperands = operands.pop();
                    double leftOperands = operands.pop();
                    double result = 0;
                    String operator = operators.pop();
                    switch (operator) {
                        case ("+") -> result = leftOperands + rightOperands;
                        case ("-") -> result = leftOperands - rightOperands;
                        case ("*") -> result = leftOperands * rightOperands;
                        case ("/") -> {
                            if (rightOperands == 0) {
                                throw new NumberFormatException("You cannot divide by zero.");
                            }
                            result = leftOperands / rightOperands;
                        }
                    }
                    operands.push(result);
                    break;
                default:
                    // prevent adding non-numeric parts
                    try {
                        operands.push(Double.parseDouble(part));
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input detected. Rogue input:" + part);
                        throw e;
                    }
            }
        }
        return operands.pop();
    }

    /**
     * In this method we loop through the characters in the expression. We do this to parse out each part
     * of the infix expression from the string. The resulting parts are added to a GenericArrayList and returned.
     * @param expression raw expression
     * @return GenericArrayList<String>
     */
    public static GenericArrayList<String> parseExpression(String expression) {
        GenericArrayList<String> list = new GenericArrayList<>();
        StringBuilder sb = new StringBuilder();

        // There is one interesting 'gotcha' with this.
        // We want to parse up the expression splitting the digits and operands. However, what if the
        // digit was negative? Wouldn't it appear to have an operand in front of it and possibly even at the
        // start of the expression.
        boolean lastWasDigit = false;

        for (int i = 0; i <= expression.length() - 1; i++) {
            char character = expression.charAt(i);

            if (Character.isWhitespace(character)) {
                // ignore whitespace inputted by the user.
                continue;
            }

            if (Character.isDigit(character)) {
                // append this digit character to our StringBuilder
                sb.append(character);
                lastWasDigit = true;
            } else if (!lastWasDigit && character == '-') {
                sb.append(character);
            } else {
                // This is not a number. We must now move the digits in our StringBuilder onto the ArrayList
                // and then reset the StringBuilder.
                if (sb.length() > 0) {
                    list.add(sb.toString());
                    sb = new StringBuilder();
                }

                lastWasDigit = false;

                // add operators to GenericArrayList
                list.add(String.valueOf(character));
            }
        }
        return list;
    }
}