package Week11.Ngoai_le_1;

public class Numeral extends Expression {
    private final double value;

    public Numeral() {
        this.value = 0;
    }

    public Numeral(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("%.0f", value);
    }

    @Override
    public double evaluate() {
        return value;
    }
}
