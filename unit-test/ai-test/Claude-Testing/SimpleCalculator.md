# Prompt

Bạn là một kỹ sư kiểm thử phần mềm.  
Hãy viết unit test cho đoạn code sau bằng JUnit 5.

Yêu cầu:
1. Sử dụng cấu trúc Arrange–Act–Assert.
2. Bao phủ trường hợp bình thường, trường hợp biên và trường hợp lỗi.
3. Đặt tên test case rõ ràng.
4. Không thay đổi logic của mã nguồn gốc.
5. Giải thích ngắn gọn các nhóm test đã viết.

Đây là mã nguồn cần test:

```java
public class SimpleCalculator {

    /**
     * Thực hiện phép tính giữa hai số dựa trên toán tử được cung cấp.
     *
     * @param num1     số thứ nhất
     * @param num2     số thứ hai
     * @param operator toán tử: "+", "-", "*", "x" (hoặc "X"), "/"
     * @return kết quả của phép tính
     * @throws IllegalArgumentException nếu toán tử là null hoặc không được hỗ trợ
     * @throws ArithmeticException      nếu chia cho 0
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

    public double add(double num1, double num2) {
        return num1 + num2;
    }

    public double subtract(double num1, double num2) {
        return num1 - num2;
    }

    public double multiply(double num1, double num2) {
        return num1 * num2;
    }

    public double divide(double num1, double num2) {
        if (num2 == 0) {
            throw new ArithmeticException("cannot divide by 0");
        }
        return num1 / num2;
    }
}
```

---

# Claude-generated Unit Tests

```java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleCalculatorTest {

    private SimpleCalculator calc;

    @BeforeEach
    void setUp() {
        calc = new SimpleCalculator();
    }

    // =====================================================
    // Phép cộng (add)
    // =====================================================

    @Test
    void add_TwoPositiveNumbers_ShouldReturnCorrectSum() {
        // Arrange
        double a = 15.0;
        double b = 27.0;

        // Act
        double result = calc.add(a, b);

        // Assert
        assertEquals(42.0, result, 0.0001);
    }

    @Test
    void add_PositiveAndNegative_ShouldReturnCorrectResult() {
        // Arrange
        double a = 50.0;
        double b = -17.0;

        // Act
        double result = calc.add(a, b);

        // Assert
        assertEquals(33.0, result, 0.0001);
    }

    @Test
    void add_TwoNegativeNumbers_ShouldReturnNegativeSum() {
        // Arrange
        double a = -12.5;
        double b = -7.5;

        // Act
        double result = calc.add(a, b);

        // Assert
        assertEquals(-20.0, result, 0.0001);
    }

    @Test
    void add_WithZero_ShouldReturnSameNumber() {
        // Arrange & Act & Assert
        assertEquals(99.0, calc.add(99.0, 0.0), 0.0001);
        assertEquals(0.0, calc.add(0.0, 55.0), 0.0001);
        assertEquals(0.0, calc.add(0.0, 0.0), 0.0001);
    }

    @Test
    void add_DecimalNumbers_ShouldHandlePrecisionCorrectly() {
        // Arrange
        double a = 0.1;
        double b = 0.2;

        // Act
        double result = calc.add(a, b);

        // Assert
        assertEquals(0.3, result, 0.0001);
    }

    // =====================================================
    // Phép trừ (subtract)
    // =====================================================

    @Test
    void subtract_LargerMinusSmaller_ShouldReturnPositive() {
        // Arrange
        double a = 100.0;
        double b = 35.0;

        // Act
        double result = calc.subtract(a, b);

        // Assert
        assertEquals(65.0, result, 0.0001);
    }

    @Test
    void subtract_SmallerMinusLarger_ShouldReturnNegative() {
        // Arrange
        double a = 10.0;
        double b = 85.0;

        // Act
        double result = calc.subtract(a, b);

        // Assert
        assertEquals(-75.0, result, 0.0001);
    }

    @Test
    void subtract_SameNumbers_ShouldReturnZero() {
        // Arrange
        double a = 64.0;
        double b = 64.0;

        // Act
        double result = calc.subtract(a, b);

        // Assert
        assertEquals(0.0, result, 0.0001);
    }

    @Test
    void subtract_NegativeNumber_ShouldBeEquivalentToAddition() {
        // Arrange
        double a = 30.0;
        double b = -12.0;

        // Act
        double result = calc.subtract(a, b);

        // Assert
        assertEquals(42.0, result, 0.0001);
    }

    // =====================================================
    // Phép nhân (multiply)
    // =====================================================

    @Test
    void multiply_TwoPositiveNumbers_ShouldReturnCorrectProduct() {
        // Arrange
        double a = 7.0;
        double b = 8.0;

        // Act
        double result = calc.multiply(a, b);

        // Assert
        assertEquals(56.0, result, 0.0001);
    }

    @Test
    void multiply_ByZero_ShouldAlwaysReturnZero() {
        // Arrange & Act & Assert
        assertEquals(0.0, calc.multiply(999.0, 0.0), 0.0001);
        assertEquals(0.0, calc.multiply(0.0, -42.0), 0.0001);
    }

    @Test
    void multiply_TwoNegativeNumbers_ShouldReturnPositive() {
        // Arrange
        double a = -6.0;
        double b = -9.0;

        // Act
        double result = calc.multiply(a, b);

        // Assert
        assertEquals(54.0, result, 0.0001);
    }

    @Test
    void multiply_PositiveAndNegative_ShouldReturnNegative() {
        // Arrange
        double a = 13.0;
        double b = -3.0;

        // Act
        double result = calc.multiply(a, b);

        // Assert
        assertEquals(-39.0, result, 0.0001);
    }

    @Test
    void multiply_ByOne_ShouldReturnSameNumber() {
        // Arrange
        double a = 256.0;
        double b = 1.0;

        // Act
        double result = calc.multiply(a, b);

        // Assert
        assertEquals(256.0, result, 0.0001);
    }

    // =====================================================
    // Phép chia (divide)
    // =====================================================

    @Test
    void divide_TwoPositiveNumbers_ShouldReturnCorrectQuotient() {
        // Arrange
        double a = 100.0;
        double b = 4.0;

        // Act
        double result = calc.divide(a, b);

        // Assert
        assertEquals(25.0, result, 0.0001);
    }

    @Test
    void divide_ResultIsDecimal_ShouldReturnCorrectValue() {
        // Arrange
        double a = 10.0;
        double b = 3.0;

        // Act
        double result = calc.divide(a, b);

        // Assert
        assertEquals(3.3333, result, 0.001);
    }

    @Test
    void divide_NegativeByPositive_ShouldReturnNegative() {
        // Arrange
        double a = -81.0;
        double b = 9.0;

        // Act
        double result = calc.divide(a, b);

        // Assert
        assertEquals(-9.0, result, 0.0001);
    }

    @Test
    void divide_NegativeByNegative_ShouldReturnPositive() {
        // Arrange
        double a = -60.0;
        double b = -12.0;

        // Act
        double result = calc.divide(a, b);

        // Assert
        assertEquals(5.0, result, 0.0001);
    }

    @Test
    void divide_ZeroByNumber_ShouldReturnZero() {
        // Arrange
        double a = 0.0;
        double b = 77.0;

        // Act
        double result = calc.divide(a, b);

        // Assert
        assertEquals(0.0, result, 0.0001);
    }

    @Test
    void divide_ByZero_ShouldThrowArithmeticException() {
        // Arrange
        double a = 42.0;
        double b = 0.0;

        // Act & Assert
        ArithmeticException ex = assertThrows(
            ArithmeticException.class,
            () -> calc.divide(a, b)
        );
        assertEquals("cannot divide by 0", ex.getMessage());
    }

    // =====================================================
    // Phương thức calculate() - tất cả các toán tử
    // =====================================================

    @Test
    void calculate_WithPlusOperator_ShouldAdd() {
        // Arrange
        double a = 25.0;
        double b = 17.0;

        // Act
        double result = calc.calculate(a, b, "+");

        // Assert
        assertEquals(42.0, result, 0.0001);
    }

    @Test
    void calculate_WithMinusOperator_ShouldSubtract() {
        // Arrange
        double a = 90.0;
        double b = 33.0;

        // Act
        double result = calc.calculate(a, b, "-");

        // Assert
        assertEquals(57.0, result, 0.0001);
    }

    @Test
    void calculate_WithAsteriskOperator_ShouldMultiply() {
        // Arrange
        double a = 9.0;
        double b = 11.0;

        // Act
        double result = calc.calculate(a, b, "*");

        // Assert
        assertEquals(99.0, result, 0.0001);
    }

    @Test
    void calculate_WithLowercaseX_ShouldMultiply() {
        // Arrange
        double a = 5.0;
        double b = 12.0;

        // Act
        double result = calc.calculate(a, b, "x");

        // Assert
        assertEquals(60.0, result, 0.0001);
    }

    @Test
    void calculate_WithUppercaseX_ShouldMultiply() {
        // Arrange
        double a = 7.0;
        double b = 6.0;

        // Act
        double result = calc.calculate(a, b, "X");

        // Assert
        assertEquals(42.0, result, 0.0001);
    }

    @Test
    void calculate_WithSlashOperator_ShouldDivide() {
        // Arrange
        double a = 144.0;
        double b = 12.0;

        // Act
        double result = calc.calculate(a, b, "/");

        // Assert
        assertEquals(12.0, result, 0.0001);
    }

    // =====================================================
    // Trường hợp lỗi và ngoại lệ
    // =====================================================

    @Test
    void calculate_WithNullOperator_ShouldThrowIllegalArgumentException() {
        // Arrange
        double a = 10.0;
        double b = 5.0;

        // Act & Assert
        IllegalArgumentException ex = assertThrows(
            IllegalArgumentException.class,
            () -> calc.calculate(a, b, null)
        );
        assertEquals("operator is null", ex.getMessage());
    }

    @Test
    void calculate_WithInvalidOperator_ShouldThrowIllegalArgumentException() {
        // Arrange
        double a = 10.0;
        double b = 5.0;

        // Act & Assert
        IllegalArgumentException ex = assertThrows(
            IllegalArgumentException.class,
            () -> calc.calculate(a, b, "^")
        );
        assertEquals("invalid operator: ^", ex.getMessage());
    }

    @Test
    void calculate_DivideByZero_ShouldThrowArithmeticException() {
        // Arrange
        double a = 99.0;
        double b = 0.0;

        // Act & Assert
        assertThrows(
            ArithmeticException.class,
            () -> calc.calculate(a, b, "/")
        );
    }

    // =====================================================
    // Trường hợp biên
    // =====================================================

    @Test
    void calculate_WithVeryLargeNumbers_ShouldNotOverflow() {
        // Arrange & Act
        double result = calc.add(Double.MAX_VALUE / 2, Double.MAX_VALUE / 2);

        // Assert
        assertTrue(result > 0);
    }

    @Test
    void calculate_WithVerySmallNumbers_ShouldWork() {
        // Arrange & Act
        double result = calc.multiply(Double.MIN_VALUE, 2.0);

        // Assert
        assertTrue(result > 0);
    }

    @Test
    void chainedOperations_ShouldProduceCorrectFinalResult() {
        // Arrange & Act
        double r1 = calc.add(10, 5);           // 15
        double r2 = calc.multiply(r1, 3);      // 45
        double r3 = calc.subtract(r2, 10);     // 35
        double r4 = calc.divide(r3, 5);        // 7

        // Assert
        assertEquals(7.0, r4, 0.0001);
    }
}
```

---

## Giải thích các nhóm test

**Phép cộng (add)**
- Hai số dương, số dương + số âm, hai số âm, cộng với 0, số thập phân.
- Xác minh `add()` trả về tổng chính xác trong mọi trường hợp dấu và giá trị.

**Phép trừ (subtract)**
- Số lớn trừ số nhỏ, số nhỏ trừ số lớn (kết quả âm), hai số bằng nhau (kết quả 0), trừ số âm.
- Xác minh `subtract()` trả về hiệu đúng và giữ dấu chính xác.

**Phép nhân (multiply)**
- Hai số dương, hai số âm (kết quả dương), dương × âm (kết quả âm), nhân với 0, nhân với 1.
- Xác minh `multiply()` trả về tích đúng và giữ quy tắc dấu.

**Phép chia (divide)**
- Chia hai số dương, kết quả thập phân, âm/chia/dương, âm/âm, 0 chia cho số, chia cho 0.
- Xác minh `divide()` trả về thương đúng và ném `ArithmeticException` khi chia 0.

**Phương thức calculate()**
- Kiểm tra tất cả toán tử hợp lệ: `+`, `-`, `*`, `x`, `X`, `/`.
- Kiểm tra toán tử `null`, toán tử không hợp lệ, chia 0 qua `calculate()`.
- Xác minh `calculate()` định tuyến chính xác đến từng phép toán.

**Trường hợp biên**
- Số rất lớn (`Double.MAX_VALUE`), số rất nhỏ (`Double.MIN_VALUE`).
- Chuỗi thao tác tuần tự nhiều bước.
