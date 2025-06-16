package calculator.operations;

public class Subtraction implements Operation{
    private double num1;
    private double num2;

    public Subtraction(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    @Override
    public double calculate() {
        return this.num1 - this.num2;
    }
}
