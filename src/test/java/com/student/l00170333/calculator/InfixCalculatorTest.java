package com.student.l00170333.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InfixCalculatorTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void evaluate() throws NumberFormatException  {
        assertEquals(5, InfixCalculator.evaluate("( ((  4 +  1 ) * 2) / 2  ) "));
        assertEquals(45, InfixCalculator.evaluate("((10 + 5) * 3)"));
        assertEquals(45, InfixCalculator.evaluate("((1 0 + 5       ) * 3)"));

        // Test that exception is thrown when invalid characters are found in the expression.
        assertThrows(NumberFormatException.class, () -> InfixCalculator.evaluate("(abc * 2 + 3)"));

        // Test that exception is thrown when start or end bracket is missing.
        assertThrows(NumberFormatException.class, () -> InfixCalculator.evaluate("2 * 2 + 3)"));
        assertThrows(NumberFormatException.class, () -> InfixCalculator.evaluate("(2 * 2 + 3"));
    }

    @Test
    void divideByZero()  {
        assertThrows(NumberFormatException.class, () -> InfixCalculator.evaluate("(1/0)"));
    }

    @Test
    void doubleOperandTest() throws NumberFormatException  {
        // Test for negative numbers. In this case we can have what appears to be an operand before
        // any digits. We can also have multiple operands appearing together e.g. +-1.
        assertEquals(-5, InfixCalculator.evaluate("(  -4 +  -1 )"));
        assertEquals(-2, InfixCalculator.evaluate("(-1+-1)"));
        assertEquals(1, InfixCalculator.evaluate("(-1*-1)"));
        assertEquals(-5, InfixCalculator.evaluate("( ((  -4 +  -1 ) * 2) / 2  ) "));
    }
}