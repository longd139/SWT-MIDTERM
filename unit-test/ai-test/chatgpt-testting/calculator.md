# prompt

Bạn là một kỹ sư kiểm thử phần mềm. 
Hãy viết unit test cho đoạn code sau bằng JUnit 5.



Yêu cầu:
1. Sử dụng cấu trúc Arrange–Act–Assert.
2. Bao phủ trường hợp bình thường, trường hợp biên và trường hợp lỗi.
3. Đặt tên test case rõ ràng.
4. Không thay đổi logic của mã nguồn gốc.
5. Giải thích ngắn gọn các nhóm test đã viết.

Đây là mã nguồn cần test:

public class SimpleCalculator {

    /**
     * Performs a calculation between two numbers based on the given operator.
     *
     * @param num1     the first number
     * @param num2     the second number
     * @param operator the operator: "+", "-", "*", "x" (or "X"), "/"
     * @return the result of the calculation
     * @throws IllegalArgumentException if the operator is null or not supported
     * @throws ArithmeticException      if dividing by zero
     */
    public double calculate(double num1, double num2, String operator) {
        if (operator == null) {
            throw new IllegalArgumentException("operator is null");
        }

        if (operator.equals("+")) {
            return add(num1, num2);

        } else if (operator.equals("-")) {
            return subtract(num1, num2);

        } else if (operator.equals("*") || operator.equals("x") || operator.equals("X")) {
            return multiply(num1, num2);

        } else if (operator.equals("/")) {
            return divide(num1, num2);

        } else {
            throw new IllegalArgumentException("invalid operator: " + operator);
        }
    }

    /**
     * Adds two numbers.
     *
     * @param num1 the first number
     * @param num2 the second number
     * @return the sum of num1 and num2
     */
    public double add(double num1, double num2) {
        return num1 + num2;
    }

    /**
     * Subtracts the second number from the first.
     *
     * @param num1 the first number
     * @param num2 the second number
     * @return the result of num1 - num2
     */
    public double subtract(double num1, double num2) {
        return num1 - num2;
    }

    /**
     * Multiplies two numbers.
     *
     * @param num1 the first number
     * @param num2 the second number
     * @return the product of num1 and num2
     */
    public double multiply(double num1, double num2) {
        return num1 * num2;
    }

    /**
     * Divides the first number by the second.
     *
     * @param num1 the first number (dividend)
     * @param num2 the second number (divisor)
     * @return the result of num1 / num2
     * @throws ArithmeticException if num2 is zero
     */
    public double divide(double num1, double num2) {
        if (num2 == 0) {
            throw new ArithmeticException("cannot divide by 0");
        }
        return num1 / num2;
    }
}

# src unittest

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleCalculatorTest {

    private SimpleCalculator calculator;

    @BeforeEach
    void setUp() {
        // Arrange
        calculator = new SimpleCalculator();
    }

    // =========================
    // ADD TESTS
    // =========================

    @Test
    void testAdd_WithPositiveNumbers_ReturnsCorrectSum() {
        // Arrange
        double num1 = 10;
        double num2 = 5;

        // Act
        double result = calculator.add(num1, num2);

        // Assert
        assertEquals(15, result);
    }

    @Test
    void testAdd_WithZero_ReturnsSameNumber() {
        // Arrange
        double num1 = 8;
        double num2 = 0;

        // Act
        double result = calculator.add(num1, num2);

        // Assert
        assertEquals(8, result);
    }

    // =========================
    // SUBTRACT TESTS
    // =========================

    @Test
    void testSubtract_WithPositiveNumbers_ReturnsCorrectDifference() {
        // Arrange
        double num1 = 10;
        double num2 = 3;

        // Act
        double result = calculator.subtract(num1, num2);

        // Assert
        assertEquals(7, result);
    }

    @Test
    void testSubtract_ResultCanBeNegative() {
        // Arrange
        double num1 = 3;
        double num2 = 10;

        // Act
        double result = calculator.subtract(num1, num2);

        // Assert
        assertEquals(-7, result);
    }

    // =========================
    // MULTIPLY TESTS
    // =========================

    @Test
    void testMultiply_WithPositiveNumbers_ReturnsCorrectProduct() {
        // Arrange
        double num1 = 4;
        double num2 = 5;

        // Act
        double result = calculator.multiply(num1, num2);

        // Assert
        assertEquals(20, result);
    }

    @Test
    void testMultiply_ByZero_ReturnsZero() {
        // Arrange
        double num1 = 100;
        double num2 = 0;

        // Act
        double result = calculator.multiply(num1, num2);

        // Assert
        assertEquals(0, result);
    }

    // =========================
    // DIVIDE TESTS
    // =========================

    @Test
    void testDivide_WithValidNumbers_ReturnsCorrectQuotient() {
        // Arrange
        double num1 = 20;
        double num2 = 4;

        // Act
        double result = calculator.divide(num1, num2);

        // Assert
        assertEquals(5, result);
    }

    @Test
    void testDivide_WithDecimalResult_ReturnsCorrectValue() {
        // Arrange
        double num1 = 5;
        double num2 = 2;

        // Act
        double result = calculator.divide(num1, num2);

        // Assert
        assertEquals(2.5, result);
    }

    @Test
    void testDivide_ByZero_ThrowsArithmeticException() {
        // Arrange
        double num1 = 10;
        double num2 = 0;

        // Act & Assert
        ArithmeticException exception =
                assertThrows(ArithmeticException.class,
                        () -> calculator.divide(num1, num2));

        assertEquals("cannot divide by 0", exception.getMessage());
    }

    // =========================
    // CALCULATE TESTS
    // =========================

    @Test
    void testCalculate_WithAdditionOperator_ReturnsCorrectResult() {
        // Arrange

        // Act
        double result = calculator.calculate(10, 5, "+");

        // Assert
        assertEquals(15, result);
    }

    @Test
    void testCalculate_WithSubtractionOperator_ReturnsCorrectResult() {
        // Arrange

        // Act
        double result = calculator.calculate(10, 5, "-");

        // Assert
        assertEquals(5, result);
    }

    @Test
    void testCalculate_WithMultiplyOperatorStar_ReturnsCorrectResult() {
        // Arrange

        // Act
        double result = calculator.calculate(4, 5, "*");

        // Assert
        assertEquals(20, result);
    }

    @Test
    void testCalculate_WithMultiplyOperatorLowerCaseX_ReturnsCorrectResult() {
        // Arrange

        // Act
        double result = calculator.calculate(4, 5, "x");

        // Assert
        assertEquals(20, result);
    }

    @Test
    void testCalculate_WithMultiplyOperatorUpperCaseX_ReturnsCorrectResult() {
        // Arrange

        // Act
        double result = calculator.calculate(4, 5, "X");

        // Assert
        assertEquals(20, result);
    }

    @Test
    void testCalculate_WithDivisionOperator_ReturnsCorrectResult() {
        // Arrange

        // Act
        double result = calculator.calculate(20, 4, "/");

        // Assert
        assertEquals(5, result);
    }

    @Test
    void testCalculate_WithNullOperator_ThrowsIllegalArgumentException() {
        // Arrange

        // Act & Assert
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class,
                        () -> calculator.calculate(10, 5, null));

        assertEquals("operator is null", exception.getMessage());
    }

    @Test
    void testCalculate_WithInvalidOperator_ThrowsIllegalArgumentException() {
        // Arrange

        // Act & Assert
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class,
                        () -> calculator.calculate(10, 5, "%"));

        assertEquals("invalid operator: %", exception.getMessage());
    }

    @Test
    void testCalculate_DivideByZero_ThrowsArithmeticException() {
        // Arrange

        // Act & Assert
        assertThrows(
                ArithmeticException.class,
                () -> calculator.calculate(10, 0, "/")
        );
    }
}
