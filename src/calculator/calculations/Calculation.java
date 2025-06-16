package calculator.calculations;

import calculator.operations.*;

public class Calculation {
    public static Operation performOperations(int choice, double num1, double num2) {
        switch(choice) {
            case 1:
                return new Addition(num1, num2);
            case 2:
                return new Divide(num1, num2);
            case 3:
                return new Multiply(num1, num2);
            case 4:
                return new Subtraction(num1, num2);
            default:
                throw new IllegalArgumentException("Invalid choice of operation");
        }
    }
}
