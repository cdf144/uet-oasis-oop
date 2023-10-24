package Week11.Ngoai_le_1;

public class Subtraction extends BinaryExpression {
    public Subtraction(Expression left, Expression right) {
        super(left, right);
    }

    /**
     * String of expression.
     * @return expression String
     */
    @Override
    public String toString() {
        return "("
                + left.toString()
                + " + -"
                + right.toString()
                + ")"
                ;
    }

    @Override
    public double evaluate() {
        return left.evaluate() - right.evaluate();
    }
}
