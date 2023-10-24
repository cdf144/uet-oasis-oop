package Week11.Ngoai_le_1;

public class ExpressionTest {
    /**
     * Driver test.
     *
     * @param args arguments
     */
    public static void main(String[] args) {
        Square square = new Square(new Numeral(10));
        Subtraction subtraction = new Subtraction(square, new Numeral(3));
        Multiplication multiplication = new Multiplication(new Numeral(4), new Numeral(3));
        Addition additionAll = new Addition(subtraction, multiplication);
        Square squareAll = new Square(additionAll);

        System.out.println(squareAll);
        System.out.println(squareAll.evaluate());
    }
}
