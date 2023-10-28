package Week5.Uoc_so_chung_lon_nhat;

public class Solution {
    /**
     * Return gcd int.
     *
     * @param a first number
     * @param b second number
     */
    public static int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        if (b == 0) {
            return a;
        }
        if (a == b) {
            return a;
        }
        if (a < 0) {
            a = -a;
        }
        if (b < 0) {
            b = -b;
        }
        if (a < b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        int r = a % b;
        while (r != 0) {
            a = b;
            b = r;
            r = a % b;
        }
        return Math.abs(b);
    }

    /**
     * Main method.
     *
     * @param args argument
     */
    public static void main(String[] args) {
        int a = 88119936;
        int b = 280256;
        System.out.println(gcd(a, b));
    }
}
