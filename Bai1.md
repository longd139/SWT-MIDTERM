# 📑 Tài liệu Bài 1 - Máy tính đơn giản (Simple Calculator)

Tài liệu này chứa mã nguồn cấu trúc và mô tả chức năng của lớp `SimpleCalculator`, phục vụ cho Bài tập nghiên cứu giữa kỳ môn Kiểm thử phần mềm (SWT-MIDTERM).

## 🛠️ Chức năng hỗ trợ
* Các phép toán cơ bản: `+` (cộng), `-` (trừ), `*` hoặc `x` (nhân), `/` (chia).
* Xử lý các trường hợp đặc biệt: Số âm, số 0, số thập phân, lỗi chia cho 0 và phép toán không hợp lệ.

---

## 💻 Mã nguồn Java (Source Code)

```java
/**
 * Cài đặt Máy tính đơn giản (Simple Calculator).
 * Dùng cho Bài 1 - Bài tập nghiên cứu SWT Giữa kỳ.
 *
 * Hỗ trợ các phép toán: + (cộng), - (trừ), * hoặc x (nhân), / (chia).
 * Các trường hợp đặc biệt được xử lý: số âm, số 0, số thập phân, chia cho 0,
 * phép toán không hợp lệ.
 */
public class SimpleCalculator {

    /**
     * Thực hiện phép tính giữa hai số dựa trên toán tử truyền vào.
     *
     * @param num1 số thứ nhất
     * @param num2 số thứ hai
     * @param operator phép toán: "+", "-", "*", "x" (hoặc "X"), "/"
     * @return kết quả phép tính
     * @throws IllegalArgumentException nếu phép toán không hợp lệ hoặc operator null
     * @throws ArithmeticException nếu chia cho 0
     */
    public double calculate(double num1, double num2, String operator) {
        if (operator == null) {
            throw new IllegalArgumentException("Phép toán không được để trống");
        }
        
        switch (operator) {
            case "+":
                return add(num1, num2);
            case "-":
                return subtract(num1, num2);
            case "*":
            case "x":
            case "X":
                return multiply(num1, num2);
            case "/":
                return divide(num1, num2);
            default:
                throw new IllegalArgumentException("Phép toán không hợp lệ: " + operator);
        }
    }

    /** Phép cộng. */
    public double add(double num1, double num2) {
        return num1 + num2;
    }

    /** Phép trừ. */
    public double subtract(double num1, double num2) {
        return num1 - num2;
    }

    /** Phép nhân. */
    public double multiply(double num1, double num2) {
        return num1 * num2;
    }

    /**
     * Phép chia.
     * @throws ArithmeticException nếu num2 bằng 0
     */
    public double divide(double num1, double num2) {
        if (num2 == 0) {
            throw new ArithmeticException("Không thể chia cho 0");
        }
        return num1 / num2;
    }
}