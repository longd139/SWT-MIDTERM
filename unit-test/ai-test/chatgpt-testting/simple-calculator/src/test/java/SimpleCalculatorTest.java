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
