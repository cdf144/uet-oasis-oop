package Week5;

import Week5.Phan_so.Solution;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class FractionTest {
    @Test
    public void testConstructor() {
        Solution fraction = new Solution(1, 2);
        assertEquals(1, fraction.getNumerator());
        assertEquals(2, fraction.getDenominator());

        fraction = new Solution(3, 4);
        assertEquals(3, fraction.getNumerator());
        assertEquals(4, fraction.getDenominator());
    }

    @Test
    public void testReduce() {
        Solution fraction = new Solution(2, 4);
        fraction = fraction.reduce();
        assertEquals(1, fraction.getNumerator());
        assertEquals(2, fraction.getDenominator());

        fraction = new Solution(6, 9);
        fraction = fraction.reduce();
        assertEquals(2, fraction.getNumerator());
        assertEquals(3, fraction.getDenominator());
    }

    @Test
    public void testAdd() {
        Solution fraction1 = new Solution(1, 2);
        Solution fraction2 = new Solution(1, 3);
        Solution sum = fraction1.add(fraction2);

        assertEquals(5, sum.getNumerator());
        assertEquals(6, sum.getDenominator());
    }

    @Test
    public void testSubtract() {
        Solution fraction1 = new Solution(1, 2);
        Solution fraction2 = new Solution(1, 3);
        Solution difference = fraction1.subtract(fraction2);

        assertEquals(1, difference.getNumerator());
        assertEquals(6, difference.getDenominator());
    }

    @Test
    public void testMultiply() {
        Solution fraction1 = new Solution(1, 2);
        Solution fraction2 = new Solution(1, 3);
        Solution product = fraction1.multiply(fraction2);

        assertEquals(1, product.getNumerator());
        assertEquals(6, product.getDenominator());
    }

    @Test
    public void testDivide() {
        Solution fraction1 = new Solution(1, 2);
        Solution fraction2 = new Solution(1, 3);
        Solution quotient = fraction1.divide(fraction2);

        assertEquals(3, quotient.getNumerator());
        assertEquals(2, quotient.getDenominator());
    }

    @Test
    public void testEquals() {
        Solution fraction1 = new Solution(1, 2);
        Solution fraction2 = new Solution(1, 2);

        assertEquals(fraction1, fraction2);

        Solution fraction3 = new Solution(2, 5);
        assertNotEquals(fraction1, fraction3);
    }
}
