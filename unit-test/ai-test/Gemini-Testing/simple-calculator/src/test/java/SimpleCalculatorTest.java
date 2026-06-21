import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SimpleCalculatorTest {

    private SimpleCalculator calculator;
    private final double DELTA = 0.0001; // Sai số cho phép đối với số thực

    @BeforeEach
    public void setUp() {
        calculator = new SimpleCalculator();
    }

    // ==========================================
    // TESTS CHO PHƯƠNG THỨC ADD()
    // ==========================================

    @Test
    public void add_TwoPositiveNumbers_ShouldReturnCorrectSum() {
        // Arrange
        double num1 = 10.0;
        double num2 = 5.0;

        // Act
        double result = calculator.add(num1, num2);

        // Assert
        assertEquals(15.0, result, DELTA);
    }

    @Test
    public void add_OneNegativeNumber_ShouldReturnCorrectSum() {
        // Arrange
        double num1 = 10.0;
        double num2 = -3.0;

        // Act
        double result = calculator.add(num1, num2);

        // Assert
        assertEquals(7.0, result, DELTA);
    }

    @Test
    public void add_TwoZeros_ShouldReturnZero() {
        // Arrange
        double num1 = 0.0;
        double num2 = 0.0;

        // Act
        double result = calculator.add(num1, num2);

        // Assert
        assertEquals(0.0, result, DELTA);
    }

    @Test
    public void add_FloatingPointNumbers_ShouldReturnCorrectSum() {
        // Arrange
        double num1 = 2.5;
        double num2 = 3.1;

        // Act
        double result = calculator.add(num1, num2);

        // Assert
        assertEquals(5.6, result, DELTA);
    }

    // ==========================================
    // TESTS CHO PHƯƠNG THỨC SUBTRACT()
    // ==========================================

    @Test
    public void subtract_TwoPositiveNumbers_ShouldReturnCorrectDifference() {
        // Arrange
        double num1 = 10.0;
        double num2 = 4.0;

        // Act
        double result = calculator.subtract(num1, num2);

        // Assert
        assertEquals(6.0, result, DELTA);
    }

    @Test
    public void subtract_ResultIsNegative_ShouldReturnNegativeDifference() {
        // Arrange
        double num1 = 5.0;
        double num2 = 12.0;

        // Act
        double result = calculator.subtract(num1, num2);

        // Assert
        assertEquals(-7.0, result, DELTA);
    }

    @Test
    public void subtract_FloatingPointNumbers_ShouldReturnCorrectDifference() {
        // Arrange
        double num1 = 10.5;
        double num2 = 5.2;

        // Act
        double result = calculator.subtract(num1, num2);

        // Assert
        assertEquals(5.3, result, DELTA);
    }

    // ==========================================
    // TESTS CHO PHƯƠNG THỨC MULTIPLY()
    // ==========================================

    @Test
    public void multiply_TwoPositiveNumbers_ShouldReturnCorrectProduct() {
        // Arrange
        double num1 = 4.0;
        double num2 = 5.0;

        // Act
        double result = calculator.multiply(num1, num2);

        // Assert
        assertEquals(20.0, result, DELTA);
    }

    @Test
    public void multiply_OneNegativeNumber_ShouldReturnNegativeProduct() {
        // Arrange
        double num1 = 4.0;
        double num2 = -3.0;

        // Act
        double result = calculator.multiply(num1, num2);

        // Assert
        assertEquals(-12.0, result, DELTA);
    }

    @Test
    public void multiply_WithZero_ShouldReturnZero() {
        // Arrange
        double num1 = 15.0;
        double num2 = 0.0;

        // Act
        double result = calculator.multiply(num1, num2);

        // Assert
        assertEquals(0.0, result, DELTA);
    }

    @Test
    public void multiply_FloatingPointNumbers_ShouldReturnCorrectProduct() {
        // Arrange
        double num1 = 2.5;
        double num2 = 2.0;

        // Act
        double result = calculator.multiply(num1, num2);

        // Assert
        assertEquals(5.0, result, DELTA);
    }

    // ==========================================
    // TESTS CHO PHƯƠNG THỨC DIVIDE()
    // ==========================================

    @Test
    public void divide_NormalNumbers_ShouldReturnCorrectQuotient() {
        // Arrange
        double num1 = 20.0;
        double num2 = 4.0;

        // Act
        double result = calculator.divide(num1, num2);

        // Assert
        assertEquals(5.0, result, DELTA);
    }

    @Test
    public void divide_ResultIsFloatingPoint_ShouldReturnCorrectQuotient() {
        // Arrange
        double num1 = 5.0;
        double num2 = 2.0;

        // Act
        double result = calculator.divide(num1, num2);

        // Assert
        assertEquals(2.5, result, DELTA);
    }

    @Test
    public void divide_ByZero_ShouldThrowArithmeticException() {
        // Arrange
        double num1 = 10.0;
        double num2 = 0.0;

        // Act & Assert
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> {
            calculator.divide(num1, num2);
        });
        assertEquals("cannot divide by 0", exception.getMessage());
    }

    // ==========================================
    // TESTS CHO PHƯƠNG THỨC CALCULATE()
    // ==========================================

    @Test
    public void calculate_WithPlusOperator_ShouldInvokeAdd() {
        // Arrange
        double num1 = 5.0;
        double num2 = 3.0;
        String operator = "+";

        // Act
        double result = calculator.calculate(num1, num2, operator);

        // Assert
        assertEquals(8.0, result, DELTA);
    }

    @Test
    public void calculate_WithMinusOperator_ShouldInvokeSubtract() {
        // Arrange
        double num1 = 10.0;
        double num2 = 4.0;
        String operator = "-";

        // Act
        double result = calculator.calculate(num1, num2, operator);

        // Assert
        assertEquals(6.0, result, DELTA);
    }

    @Test
    public void calculate_WithAsteriskOperator_ShouldInvokeMultiply() {
        // Arrange
        double num1 = 3.0;
        double num2 = 4.0;
        String operator = "*";

        // Act
        double result = calculator.calculate(num1, num2, operator);

        // Assert
        assertEquals(12.0, result, DELTA);
    }

    @Test
    public void calculate_WithLowercaseXOperator_ShouldInvokeMultiply() {
        // Arrange
        double num1 = 3.0;
        double num2 = 4.0;
        String operator = "x";

        // Act
        double result = calculator.calculate(num1, num2, operator);

        // Assert
        assertEquals(12.0, result, DELTA);
    }

    @Test
    public void calculate_WithUppercaseXOperator_ShouldInvokeMultiply() {
        // Arrange
        double num1 = 3.0;
        double num2 = 4.0;
        String operator = "X";

        // Act
        double result = calculator.calculate(num1, num2, operator);

        // Assert
        assertEquals(12.0, result, DELTA);
    }

    @Test
    public void calculate_WithSlashOperator_ShouldInvokeDivide() {
        // Arrange
        double num1 = 10.0;
        double num2 = 2.0;
        String operator = "/";

        // Act
        double result = calculator.calculate(num1, num2, operator);

        // Assert
        assertEquals(5.0, result, DELTA);
    }

    @Test
    public void calculate_WithNullOperator_ShouldThrowIllegalArgumentException() {
        // Arrange
        double num1 = 10.0;
        double num2 = 5.0;
        String operator = null;

        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate(num1, num2, operator);
        });
        assertEquals("operator is null", exception.getMessage());
    }

    @Test
    public void calculate_WithInvalidOperator_ShouldThrowIllegalArgumentException() {
        // Arrange
        double num1 = 10.0;
        double num2 = 5.0;
        String operator = "^"; // Toán tử không hợp lệ

        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate(num1, num2, operator);
        });
        assertEquals("invalid operator: ^", exception.getMessage());
    }

    @Test
    public void calculate_DivideByZero_ShouldThrowArithmeticException() {
        // Arrange
        double num1 = 15.0;
        double num2 = 0.0;
        String operator = "/";

        // Act & Assert
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(num1, num2, operator);
        });
        assertEquals("cannot divide by 0", exception.getMessage());
    }
}
