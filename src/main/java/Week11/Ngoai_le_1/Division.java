package Week11.Ngoai_le_1;

public class Division extends BinaryExpression {
    public Division(Expression left, Expression right) {
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
                + " / "
                + right.toString()
        ;
    }

    @Override
    public double evaluate() throws ArithmeticException {
        if (right.evaluate() == 0) {
            throw new ArithmeticException("Lỗi chia cho 0");
        } else {
            return left.evaluate() / right.evaluate();
        }
    }
}
