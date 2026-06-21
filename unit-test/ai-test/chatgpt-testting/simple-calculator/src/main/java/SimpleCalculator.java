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

        // Trim whitespace to handle cases like " + ", " x "
        String op = operator.trim();

        switch (op) {
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
                throw new IllegalArgumentException("invalid operator: " + op);
        }
    }

    /**
     * Adds two numbers.
     *
     * @param a the first operand
     * @param b the second operand
     * @return the sum of a and b
     */
    public double add(double a, double b) {
        return a + b;
    }

    /**
     * Subtracts the second number from the first.
     *
     * @param a the first operand (minuend)
     * @param b the second operand (subtrahend)
     * @return the difference of a and b
     */
    public double subtract(double a, double b) {
        return a - b;
    }

    /**
     * Multiplies two numbers.
     *
     * @param a the first operand
     * @param b the second operand
     * @return the product of a and b
     */
    public double multiply(double a, double b) {
        return a * b;
    }

    /**
     * Divides the first number by the second.
     *
     * @param a the dividend
     * @param b the divisor
     * @return the quotient of a and b
     * @throws ArithmeticException if the divisor is zero
     */
    public double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("cannot divide by 0");
        }
        return a / b;
    }
}
