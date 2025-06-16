package calculator.operations;


public class Addition implements Operation {
    private double num1;
    private double num2;

    public Addition(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    @Override
    public double calculate() {
        return this.num1 + this.num2;
    }
}
