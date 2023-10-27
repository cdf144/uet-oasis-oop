package Week11.Ngoai_le_1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExpressionTest {
    @Test
    public void testExpression() {
        Square square = new Square(new Numeral(10));
        Subtraction subtraction = new Subtraction(square, new Numeral(3));
        Multiplication multiplication = new Multiplication(new Numeral(4), new Numeral(3));

        Addition additionAll = new Addition(subtraction, multiplication);
        Square squareAll = new Square(additionAll);

        String expected = "((((10) ^ 2 + -3) + (4 * 3))) ^ 2";
        assertEquals(expected, squareAll.toString());

        final double DELTA = 0.0000001;
        assertEquals(11881.0, squareAll.evaluate(), DELTA);
    }
}
