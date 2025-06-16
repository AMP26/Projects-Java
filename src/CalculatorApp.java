import calculator.calculations.Calculation;
import calculator.operations.*;

import java.util.Scanner;

public class CalculatorApp {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Scanner sc = new Scanner(System.in);
        System.out.println("Calculator App");
        System.out.println("Select operation:");
        System.out.println("1. Add");
        System.out.println("2. Subtract");
        System.out.println("3. Multiply");
        System.out.println("4. Divide");

        System.out.println("Enter choice: 1 / 2 / 3 / 4");
        int choice = sc.nextInt();

        System.out.print("Enter first number: ");
        double num1 = sc.nextDouble();

        System.out.print("Enter second number: ");
        double num2 = sc.nextDouble();

        try {
            Operation calculate = Calculation.performOperations(choice, num1, num2);
            double result = calculate.calculate();
            System.out.println("Result: " + result);
        }
        catch (IllegalArgumentException | ArithmeticException e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}