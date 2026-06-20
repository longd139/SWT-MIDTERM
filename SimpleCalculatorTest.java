import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SimpleCalculatorTest {

    private SimpleCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new SimpleCalculator();
    }

    @Test
    void testAddPositiveNumbers() {
        double result = calculator.calculate(5, 3, "+");
        assertEquals(8, result);
    }

    @Test
    void testSubtractPositiveNumbers() {
        double result = calculator.calculate(10, 4, "-");
        assertEquals(6, result);
    }

    @Test
    void testMultiplyWithStar() {
        double result = calculator.calculate(6, 7, "*");
        assertEquals(42, result);
    }

    @Test
    void testMultiplyWithLowercaseX() {
        double result = calculator.calculate(4, 5, "x");
        assertEquals(20, result);
    }

    @Test
    void testMultiplyWithUppercaseX() {
        double result = calculator.calculate(4, 5, "X");
        assertEquals(20, result);
    }

    @Test
    void testDividePositiveNumbers() {
        double result = calculator.calculate(10, 2, "/");
        assertEquals(5, result);
    }

    @Test
    void testAddDecimalNumbers() {
        double result = calculator.calculate(2.5, 1.2, "+");
        assertEquals(3.7, result, 0.000001);
    }

    @Test
    void testSubtractDecimalNumbers() {
        double result = calculator.calculate(5.5, 2.2, "-");
        assertEquals(3.3, result, 0.000001);
    }

    @Test
    void testMultiplyNegativeNumbers() {
        double result = calculator.calculate(-5, -3, "*");
        assertEquals(15, result);
    }

    @Test
    void testAddNegativeAndPositive() {
        double result = calculator.calculate(-5, 3, "+");
        assertEquals(-2, result);
    }

    @Test
    void testSubtractNegativeNumber() {
        double result = calculator.calculate(5, -3, "-");
        assertEquals(8, result);
    }

    @Test
    void testMultiplyByZero() {
        double result = calculator.calculate(9, 0, "*");
        assertEquals(0, result);
    }

    @Test
    void testAddZero() {
        double result = calculator.calculate(9, 0, "+");
        assertEquals(9, result);
    }

    @Test
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(10, 0, "/");
        });
    }

    @Test
    void testNullOperator() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate(1, 2, null);
        });
    }

    @Test
    void testInvalidOperator() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate(1, 2, "%");
        });
    }

    @Test
    void testEmptyOperator() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate(1, 2, "");
        });
    }

    @Test
    void testAddOperatorWithSpaces() {
        double result = calculator.calculate(1, 2, " + ");
        assertEquals(3, result);
    }

    @Test
    void testMultiplyXWithSpaces() {
        double result = calculator.calculate(4, 5, " x ");
        assertEquals(20, result);
    }

    @Test
    void testNaNInput() {
        double result = calculator.calculate(Double.NaN, 5, "+");
        assertTrue(Double.isNaN(result));
    }
}