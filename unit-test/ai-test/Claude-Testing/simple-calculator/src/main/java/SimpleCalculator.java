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
