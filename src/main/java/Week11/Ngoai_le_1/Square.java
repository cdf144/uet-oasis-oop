package Week11.Ngoai_le_1;

public class Square extends Expression {
    private final Expression expression;

    public Square(Expression expression) {
        this.expression = expression;
    }

    /**
     * Square expression toString method.
     *
     * @return Square expression String
     */
    @Override
    public String toString() {
        return "("
                + expression.toString()
                + ")"
                + " ^ 2"
                ;
    }

    @Override
    public double evaluate() {
        return expression.evaluate() * expression.evaluate();
    }
}
