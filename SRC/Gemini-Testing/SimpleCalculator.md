# Prompt Sinh Unit Test JUnit 5 - Bài 1: SimpleCalculator

Bạn là một kỹ sư kiểm thử phần mềm.

Hãy viết unit test cho đoạn mã Java sau bằng JUnit 5.

## Yêu cầu

1. Sử dụng cấu trúc Arrange – Act – Assert (AAA) cho tất cả test case.
2. Bao phủ các nhóm kiểm thử:

   * Trường hợp bình thường (Normal Cases)
   * Trường hợp biên (Boundary Cases)
   * Trường hợp lỗi/ngoại lệ (Exception Cases)
3. Đặt tên test case rõ ràng theo quy tắc:

```text
methodName_condition_expectedResult
```

Ví dụ:

```text
add_WithPositiveNumbers_ShouldReturnCorrectSum
divide_ByZero_ShouldThrowArithmeticException
```

4. Không thay đổi logic của mã nguồn gốc.
5. Sử dụng JUnit 5 và các assertion phù hợp.
6. Giải thích ngắn gọn mục đích của từng nhóm test.
7. Bao phủ tất cả các nhánh điều kiện trong phương thức `calculate()`.

## Các trường hợp cần kiểm thử

### Đối với add()

* Hai số dương
* Một số âm
* Hai số bằng 0
* Số thực

### Đối với subtract()

* Hai số dương
* Kết quả âm
* Số thực

### Đối với multiply()

* Hai số dương
* Một số âm
* Nhân với 0
* Số thực

### Đối với divide()

* Chia bình thường
* Kết quả là số thực
* Chia cho 0

### Đối với calculate()

Kiểm thử tất cả toán tử:

* "+"
* "-"
* "*"
* "x"
* "X"
* "/"

Kiểm thử các trường hợp lỗi:

* operator = null
* operator không hợp lệ
* chia cho 0 thông qua calculate()

## Cấu trúc kết quả mong muốn

### 1. Phân tích mã nguồn

* Các chức năng cần kiểm thử
* Các trường hợp biên
* Các trường hợp lỗi

### 2. Danh sách Test Case

| ID   | Test Case | Loại      |
| ---- | --------- | --------- |
| TC01 | ...       | Normal    |
| TC02 | ...       | Boundary  |
| TC03 | ...       | Exception |

### 3. Mã nguồn Unit Test JUnit 5

```java
// Full source code
```

### 4. Giải thích các nhóm test

#### Normal Cases

...

#### Boundary Cases

...

#### Exception Cases

...

### 5. Đánh giá độ bao phủ

* Các nhánh điều kiện đã được kiểm thử
* Các phương thức đã được kiểm thử
* Ước lượng mức độ bao phủ đạt được

---

## Mã nguồn cần kiểm thử

```java
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
     */
    public double add(double num1, double num2) {
        return num1 + num2;
    }

    /**
     * Subtracts the second number from the first.
     */
    public double subtract(double num1, double num2) {
        return num1 - num2;
    }

    /**
     * Multiplies two numbers.
     */
    public double multiply(double num1, double num2) {
        return num1 * num2;
    }

    /**
     * Divides the first number by the second.
     */
    public double divide(double num1, double num2) {
        if (num2 == 0) {
            throw new ArithmeticException("cannot divide by 0");
        }
        return num1 / num2;
    }
}
```






















# Báo Cáo Kiểm Thử Unit Test (JUnit 5) - Bài: SimpleCalculator

**Người thực hiện:** [Nguyễn Phương Nguyên]  
**Công nghệ sử dụng:** Java, JUnit 5  

---

## 1. Phân tích mã nguồn

**Các chức năng cần kiểm thử:**
* Phương thức phân luồng `calculate(num1, num2, operator)`: Xử lý định tuyến đến các phép toán dựa trên chuỗi toán tử. Hỗ trợ đa dạng định dạng phép nhân (`*`, `x`, `X`).
* Các phép toán cốt lõi: `add()` (Cộng), `subtract()` (Trừ), `multiply()` (Nhân), `divide()` (Chia).

**Các trường hợp biên (Boundary Cases):**
* Thao tác tính toán với số `0` (Cộng/trừ/nhân với 0).
* Thao tác tính toán với số âm.
* Thao tác tính toán với số thực (chứa phần thập phân) đòi hỏi sự chính xác về sai số (delta).

**Các trường hợp lỗi (Exception Cases):**
* `operator = null`: Phương thức `calculate` ném `IllegalArgumentException`.
* `operator` không hợp lệ (ví dụ: `^`, `%`, `abc`): Phương thức `calculate` ném `IllegalArgumentException`.
* Chia cho `0` (số bị chia `num2 = 0`): Phương thức `divide` ném `ArithmeticException`.

---

## 2. Danh sách Test Case

| ID | Test Case (Method Name) | Loại |
| :--- | :--- | :--- |
| TC01 | `add_TwoPositiveNumbers_ShouldReturnCorrectSum` | Normal |
| TC02 | `add_OneNegativeNumber_ShouldReturnCorrectSum` | Normal |
| TC03 | `add_TwoZeros_ShouldReturnZero` | Boundary |
| TC04 | `add_FloatingPointNumbers_ShouldReturnCorrectSum` | Normal |
| TC05 | `subtract_TwoPositiveNumbers_ShouldReturnCorrectDifference` | Normal |
| TC06 | `subtract_ResultIsNegative_ShouldReturnNegativeDifference` | Normal |
| TC07 | `subtract_FloatingPointNumbers_ShouldReturnCorrectDifference` | Normal |
| TC08 | `multiply_TwoPositiveNumbers_ShouldReturnCorrectProduct` | Normal |
| TC09 | `multiply_OneNegativeNumber_ShouldReturnNegativeProduct` | Normal |
| TC10 | `multiply_WithZero_ShouldReturnZero` | Boundary |
| TC11 | `multiply_FloatingPointNumbers_ShouldReturnCorrectProduct` | Normal |
| TC12 | `divide_NormalNumbers_ShouldReturnCorrectQuotient` | Normal |
| TC13 | `divide_ResultIsFloatingPoint_ShouldReturnCorrectQuotient` | Normal |
| TC14 | `divide_ByZero_ShouldThrowArithmeticException` | Exception |
| TC15 | `calculate_WithPlusOperator_ShouldInvokeAdd` | Normal |
| TC16 | `calculate_WithMinusOperator_ShouldInvokeSubtract` | Normal |
| TC17 | `calculate_WithAsteriskOperator_ShouldInvokeMultiply` | Normal |
| TC18 | `calculate_WithLowercaseXOperator_ShouldInvokeMultiply` | Normal |
| TC19 | `calculate_WithUppercaseXOperator_ShouldInvokeMultiply` | Normal |
| TC20 | `calculate_WithSlashOperator_ShouldInvokeDivide` | Normal |
| TC21 | `calculate_WithNullOperator_ShouldThrowIllegalArgumentException` | Exception |
| TC22 | `calculate_WithInvalidOperator_ShouldThrowIllegalArgumentException` | Exception |
| TC23 | `calculate_DivideByZero_ShouldThrowArithmeticException` | Exception |

---

## 3. Mã nguồn Unit Test JUnit 5

```java
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
```

---

## 4. Giải thích các nhóm test

* **Normal Cases (Trường hợp bình thường):** Nhóm này kiểm tra các kịch bản sử dụng phổ biến nhất (Happy Paths). Bao gồm việc truyền các số dương, số âm và số thực vào các phép toán. Đối với phương thức `calculate()`, nhóm này đảm bảo tất cả các toán tử hợp lệ (`+`, `-`, `*`, `x`, `X`, `/`) đều gọi đúng phương thức tương ứng và trả về kết quả chính xác.

* **Boundary Cases (Trường hợp biên):** Nhóm này kiểm tra các giá trị tại ngưỡng hoặc các điểm đặc biệt có nguy cơ gây lỗi logic cao. Các bài test tập trung vào giá trị `0` (như cộng với hai số 0, nhân với 0) và kiểm tra tính chính xác của phép toán khi sử dụng số thực (sử dụng hằng số `DELTA` = 0.0001 để đối phó với sai số dấu phẩy động trong Java).

* **Exception Cases (Trường hợp lỗi/ngoại lệ):** Nhóm này xác minh tính an toàn và khả năng xử lý lỗi của hệ thống. Sử dụng `assertThrows` để đảm bảo hệ thống bắt được các luồng không hợp lệ như truyền `operator = null`, sử dụng toán tử không được hỗ trợ, hoặc thực hiện phép chia cho `0` một cách trực tiếp trong `divide()` hay thông qua `calculate()`. Thông báo lỗi (message) cũng được kiểm chứng để đảm bảo đúng như thiết kế.

---

## 5. Đánh giá độ bao phủ

* **Các nhánh điều kiện đã được kiểm thử:**
  * Nhánh kiểm tra `operator == null`.
  * Nhánh `operator.equals("+")`.
  * Nhánh `operator.equals("-")`.
  * Nhánh đa điều kiện: `operator.equals("*") || operator.equals("x") || operator.equals("X")` (đã test riêng biệt từng chuỗi).
  * Nhánh `operator.equals("/")`.
  * Nhánh `else` bắt lỗi toán tử không hợp lệ.
  * Nhánh `if (num2 == 0)` trong hàm `divide()`.
* **Các phương thức đã được kiểm thử:**
  * Toàn bộ 5 phương thức: `calculate()`, `add()`, `subtract()`, `multiply()`, và `divide()` đều đã có các bài test tương ứng che phủ các kịch bản được yêu cầu.
* **Ước lượng mức độ bao phủ đạt được:**
  * **Statement Coverage (Bao phủ câu lệnh):** Đạt 100%. Không có câu lệnh nào bị bỏ sót.
  * **Branch Coverage (Bao phủ nhánh):** Đạt 100%. Mọi hướng đi của các mệnh đề `if-else` đều đã được kích hoạt và xác nhận.