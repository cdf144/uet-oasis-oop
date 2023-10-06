package DSA;

import static java.lang.Math.sqrt;
import static java.lang.Math.abs;

public class Sqrt {
    public static double mySqrt_linear(double x) {
        double DELTA = 0.0000000001;
        double y = 0.9, yy = y*y;
        double step = 0.0000000001;
        while (!(x-DELTA <= yy && yy <= x+DELTA)) {
            y += step;
            yy = y*y;
        }
        return y;
    }

    public static double mySqrt_binary_search(double x) {
        double x0=1, x1=x, m, mm;
        while (true) {
            m = (x0 + x1) / 2;
            if (m==x0 || m==x1) return m;
            mm = m*m;
            if (mm > x) x1=m;
            else if (mm < x) x0=m;
            else return m;
        }
    }

    public static double mySqrt_recursive(double x) {
        return mySqrt_recursive(x, 1, x);
    }

    public static double mySqrt_recursive(double x, double low, double high) {
        double m = (low + high) / 2;
        if (m==low || m==high) return m;

        double mm = m*m;
        if (mm > x) return mySqrt_recursive(x, low, m);
        else if (mm < x) return mySqrt_recursive(x, m, high);
        else return m;
    }


    public static double mySqrt_heron(double x) {
        double EPSILON = 1e-15;
        double t = x;

        while (abs(t - x/t) > EPSILON*x) {
            t = (t + x/t) / 2.0;
        }
        return t;
    }

    public static double mySqrt_heron_risky(double x) {
        double t = x;
        while (true) {
            double prev_t = t;
            t = (t + x/t) / 2.0;
            if (t == prev_t) return t;
        }
    }

    public static void main(String[] args) {
        Stopwatch stopwatch = new Stopwatch();
        double x=1;
        System.out.println(x + ": " + mySqrt_linear(x));
        System.out.println(stopwatch.elapsedTime());
        System.out.println(x + ": " + mySqrt_binary_search(x));
        System.out.println(stopwatch.elapsedTime());
        System.out.println(x + ": " + mySqrt_recursive(x));
        System.out.println(stopwatch.elapsedTime());
        System.out.println(x + ": " + mySqrt_heron(x));
        System.out.println(stopwatch.elapsedTime());
        System.out.println(x + ": " + mySqrt_heron_risky(x));
        System.out.println(stopwatch.elapsedTime());
        System.out.println(x + ": " + sqrt(x));
        System.out.println(stopwatch.elapsedTime());
        x=2;
        // System.out.println(x + ": " + mySqrt_linear(x));
        System.out.println(x + ": " + mySqrt_binary_search(x));
        System.out.println(x + ": " + mySqrt_recursive(x));
        System.out.println(x + ": " + mySqrt_heron(x));
        System.out.println(x + ": " + mySqrt_heron_risky(x));
        System.out.println(x + ": " + sqrt(x));
        x=4;
        // System.out.println(x + ": " + mySqrt_linear(x));
        System.out.println(x + ": " + mySqrt_binary_search(x));
        System.out.println(x + ": " + mySqrt_recursive(x));
        System.out.println(x + ": " + mySqrt_heron(x));
        System.out.println(x + ": " + mySqrt_heron_risky(x));
        System.out.println(x + ": " + sqrt(x));

        x=1937954872;
        System.out.println(x + ": " + mySqrt_binary_search(x));
        System.out.println(x + ": " + mySqrt_recursive(x));
        System.out.println(x + ": " + mySqrt_heron(x));
        System.out.println(x + ": " + mySqrt_heron_risky(x));
        System.out.println(x + ": " + sqrt(x));
    }
}
