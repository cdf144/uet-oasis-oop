package Week5;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class PrimeNumberTest {

    @Test
    public void testIsPrimePositive() {
        assertTrue(PrimeNumber.isPrime(2));
        assertTrue(PrimeNumber.isPrime(3));
        assertTrue(PrimeNumber.isPrime(5));
        assertTrue(PrimeNumber.isPrime(7));
        assertTrue(PrimeNumber.isPrime(11));
    }

    @Test
    public void testIsPrimeNegative() {
        assertFalse(PrimeNumber.isPrime(-1));
        assertFalse(PrimeNumber.isPrime(-2));
        assertFalse(PrimeNumber.isPrime(-3));
        assertFalse(PrimeNumber.isPrime(-5));
        assertFalse(PrimeNumber.isPrime(-7));
    }

    @Test
    public void testIsPrimeZero() {
        assertFalse(PrimeNumber.isPrime(0));
    }

    @Test
    public void testIsPrimeOne() {
        assertFalse(PrimeNumber.isPrime(1));
    }

    @Test
    public void primeNumberTest() {
        int n = 55;
        String expectedOutput =
                "0 : false\n" + "1 : false\n" + "2 : true\n" + "3 : true\n" +
                "4 : false\n" + "5 : true\n" + "6 : false\n" + "7 : true\n" +
                "8 : false\n" + "9 : false\n" + "10 : false\n" + "11 : true\n" +
                "12 : false\n" + "13 : true\n" + "14 : false\n" + "15 : false\n" +
                "16 : false\n" + "17 : true\n" + "18 : false\n" + "19 : true\n" +
                "20 : false\n" + "21 : false\n" + "22 : false\n" + "23 : true\n" +
                "24 : false\n" + "25 : false\n" + "26 : false\n" + "27 : false\n" +
                "28 : false\n" + "29 : true\n" + "30 : false\n" + "31 : true\n" +
                "32 : false\n" + "33 : false\n" + "34 : false\n" + "35 : false\n" +
                "36 : false\n" + "37 : true\n" + "38 : false\n" + "39 : false\n" +
                "40 : false\n" + "41 : true\n" + "42 : false\n" + "43 : true\n" +
                "44 : false\n" + "45 : false\n" + "46 : false\n" + "47 : true\n" +
                "48 : false\n" + "49 : false\n" + "50 : false\n" + "51 : false\n" +
                "52 : false\n" + "53 : true\n" + "54 : false\n" + "55 : false\n";

        StringBuilder actualOutput = new StringBuilder();
        for (int i = 0; i <= n; i++) {
            actualOutput.append(i)
                    .append(" : ")
                    .append(PrimeNumber.isPrime(i))
                    .append("\n");
        }

        assertEquals(expectedOutput, actualOutput.toString());
    }
}

