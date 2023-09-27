package Week5;

public class PrimeNumber {
    // Type your main code here

    /**
     * Return true if n is prime, false if not.
     * @param n number to evaluate
     */
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i < n / 2; ++i) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Main method.
     * @param args arguments
     */
    public static void main(String[] args) {

    }
}
