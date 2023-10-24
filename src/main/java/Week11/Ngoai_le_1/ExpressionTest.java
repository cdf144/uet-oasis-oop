package Week11.Ngoai_le_1;

public class ExpressionTest {
    /**
     * Driver test.
     * @param args arguments
     */
    public static void main(String[] args) {
        Square square10 = new Square(new Numeral(10));
        Subtraction subtraction3 = new Subtraction(square10, new Numeral(3));
        Multiplication multiplication43 = new Multiplication(new Numeral(4), new Numeral(3));
        Addition additionAll = new Addition(subtraction3, multiplication43);
        Square squareAll = new Square(additionAll);

        System.out.println(squareAll);
        System.out.println(squareAll.evaluate());
    }
}
