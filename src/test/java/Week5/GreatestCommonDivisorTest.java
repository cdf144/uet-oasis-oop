package Week5;

import Week5.Uoc_so_chung_lon_nhat.Solution;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GreatestCommonDivisorTest {

    @Test
    public void testGcdPositive() {
        assertEquals(2, Solution.gcd(2, 4));
        assertEquals(3, Solution.gcd(3, 9));
        assertEquals(5, Solution.gcd(5, 25));
        assertEquals(7, Solution.gcd(7, 49));
        assertEquals(11, Solution.gcd(11, 110));
    }

    @Test
    public void testGcdNegative() {
        assertEquals(2, Solution.gcd(-2, -4));
        assertEquals(3, Solution.gcd(-3, -9));
        assertEquals(5, Solution.gcd(-5, -25));
        assertEquals(7, Solution.gcd(-7, -49));
        assertEquals(11, Solution.gcd(-11, -110));
    }

    @Test
    public void testGcdZero() {
        assertEquals(0, Solution.gcd(0, 0));
        assertEquals(10, Solution.gcd(10, 0));
        assertEquals(10, Solution.gcd(0, 10));
    }

    @Test
    public void testGcdOne() {
        assertEquals(1, Solution.gcd(1, 1));
        assertEquals(1, Solution.gcd(1, 10));
        assertEquals(1, Solution.gcd(10, 1));
    }
}
