package Week5;

import Week5.Fraction;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class FractionTest {
    @Test
    public void testConstructor() {
        Fraction fraction = new Fraction(1, 2);
        assertEquals(1, fraction.getNumerator());
        assertEquals(2, fraction.getDenominator());

        fraction = new Fraction(3, 4);
        assertEquals(3, fraction.getNumerator());
        assertEquals(4, fraction.getDenominator());
    }

    @Test
    public void testReduce() {
        Fraction fraction = new Fraction(2, 4);
        fraction = fraction.reduce();
        assertEquals(1, fraction.getNumerator());
        assertEquals(2, fraction.getDenominator());

        fraction = new Fraction(6, 9);
        fraction = fraction.reduce();
        assertEquals(2, fraction.getNumerator());
        assertEquals(3, fraction.getDenominator());
    }

    @Test
    public void testAdd() {
        Fraction fraction1 = new Fraction(1, 2);
        Fraction fraction2 = new Fraction(1, 3);
        Fraction sum = fraction1.add(fraction2);

        assertEquals(5, sum.getNumerator());
        assertEquals(6, sum.getDenominator());
    }

    @Test
    public void testSubtract() {
        Fraction fraction1 = new Fraction(1, 2);
        Fraction fraction2 = new Fraction(1, 3);
        Fraction difference = fraction1.subtract(fraction2);

        assertEquals(1, difference.getNumerator());
        assertEquals(6, difference.getDenominator());
    }

    @Test
    public void testMultiply() {
        Fraction fraction1 = new Fraction(1, 2);
        Fraction fraction2 = new Fraction(1, 3);
        Fraction product = fraction1.multiply(fraction2);

        assertEquals(1, product.getNumerator());
        assertEquals(6, product.getDenominator());
    }

    @Test
    public void testDivide() {
        Fraction fraction1 = new Fraction(1, 2);
        Fraction fraction2 = new Fraction(1, 3);
        Fraction quotient = fraction1.divide(fraction2);

        assertEquals(3, quotient.getNumerator());
        assertEquals(2, quotient.getDenominator());
    }

    @Test
    public void testEquals() {
        Fraction fraction1 = new Fraction(1, 2);
        Fraction fraction2 = new Fraction(1, 2);

        assertEquals(fraction1, fraction2);

        Fraction fraction3 = new Fraction(2, 5);
        assertNotEquals(fraction1, fraction3);
    }
}
