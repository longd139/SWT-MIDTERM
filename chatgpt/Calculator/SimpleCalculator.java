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
