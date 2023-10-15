package Week5;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GreatestCommonDivisorTest {

    @Test
    public void testGcdPositive() {
        assertEquals(2, GreatestCommonDivisor.gcd(2, 4));
        assertEquals(3, GreatestCommonDivisor.gcd(3, 9));
        assertEquals(5, GreatestCommonDivisor.gcd(5, 25));
        assertEquals(7, GreatestCommonDivisor.gcd(7, 49));
        assertEquals(11, GreatestCommonDivisor.gcd(11, 110));
    }

    @Test
    public void testGcdNegative() {
        assertEquals(2, GreatestCommonDivisor.gcd(-2, -4));
        assertEquals(3, GreatestCommonDivisor.gcd(-3, -9));
        assertEquals(5, GreatestCommonDivisor.gcd(-5, -25));
        assertEquals(7, GreatestCommonDivisor.gcd(-7, -49));
        assertEquals(11, GreatestCommonDivisor.gcd(-11, -110));
    }

    @Test
    public void testGcdZero() {
        assertEquals(0, GreatestCommonDivisor.gcd(0, 0));
        assertEquals(10, GreatestCommonDivisor.gcd(10, 0));
        assertEquals(10, GreatestCommonDivisor.gcd(0, 10));
    }

    @Test
    public void testGcdOne() {
        assertEquals(1, GreatestCommonDivisor.gcd(1, 1));
        assertEquals(1, GreatestCommonDivisor.gcd(1, 10));
        assertEquals(1, GreatestCommonDivisor.gcd(10, 1));
    }
}
