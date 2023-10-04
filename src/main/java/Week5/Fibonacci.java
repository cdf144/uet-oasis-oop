package Week5;

public class Fibonacci {
    /**
     * Return nth Fibonacci number.
     *
     * @param n nth Fibonacci number
     */
    public static long fibonacci(long n) {
        if (n < 0) {
            return -1;
        }
        long f0 = 0;
        long f1 = 1;
        long fn = f0 + f1;
        if (n == 0) {
            return f0;
        }
        if (n == 1) {
            return f1;
        }

        for (int i = 2; i <= n; ++i) {
            fn = f0 + f1;
            if (fn < 0) {
                return Long.MAX_VALUE;
            }
            f0 = f1;
            f1 = fn;
        }

        return fn;
    }
}
