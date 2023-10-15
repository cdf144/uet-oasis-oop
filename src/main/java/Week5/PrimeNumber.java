package Week5;

import java.util.stream.IntStream;

public class PrimeNumber {
    /**
     * Return true if n is prime, false if not.
     *
     * @param n number to evaluate
     */
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= (n / 2); ++i) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Main method.
     *
     * @param args arguments
     */
    public static void main(String[] args) {
        int n = 75;
        IntStream
                .rangeClosed(0, n)
                .mapToObj(i -> i + " : " + isPrime(i))
                .forEach(System.out::println);
    }
}
