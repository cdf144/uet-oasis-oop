package Week5;

import Week5.Fibonacci.Solution;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FibonacciTest {

    @Test
    public void testBaseCases() {
        assertEquals(0, Solution.fibonacci(0));
        assertEquals(1, Solution.fibonacci(1));
    }

    @Test
    public void testPositiveValues() {
        assertEquals(1, Solution.fibonacci(2));
        assertEquals(2, Solution.fibonacci(3));
        assertEquals(5, Solution.fibonacci(5));
        assertEquals(55, Solution.fibonacci(10));
    }

    @Test
    public void testNegativeValues() {
        assertEquals(-1, Solution.fibonacci(-1));
        assertEquals(-1, Solution.fibonacci(-2));
    }

    @Test
    public void testLargeValues() {
        assertEquals(Long.MAX_VALUE, Solution.fibonacci(93));
        assertEquals(Long.MAX_VALUE, Solution.fibonacci(94));
    }

    @Test
    public void testFibonacci() {
        int n = 45;
        String expectedOutput = "0 1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 1597 " +
                "2584 4181 6765 10946 17711 28657 46368 75025 121393 " +
                "196418 317811 514229 832040 1346269 2178309 3524578 " +
                "5702887 9227465 14930352 24157817 39088169 63245986 " +
                "102334155 165580141 267914296 433494437 701408733 1134903170 ";
        StringBuilder actualOutput = new StringBuilder();
        for (int i = 0; i <= n; i++) {
            actualOutput.append(Solution.fibonacci(i)).append(" ");
        }
        assertEquals(expectedOutput, actualOutput.toString());
    }
}
