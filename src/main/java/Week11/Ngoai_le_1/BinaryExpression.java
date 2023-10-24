package Week11.Ngoai_le_1;

public abstract class BinaryExpression extends Expression {
    protected Expression left;
    protected Expression right;

    /**
     * BinaryExpression constructor.
     * @param left left Expression
     * @param right right Expression
     */
    public BinaryExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    public abstract String toString();

    public abstract double evaluate();
}
