package Week5.Phan_so;

public class Solution {
    private int numerator;
    private int denominator;

    /**
     * Fraction class constructor.
     *
     * @param numerator   set numerator
     * @param denominator set denominator
     */
    public Solution(int numerator, int denominator) {
        if (denominator != 0) {
            setNumerator(numerator);
            setDenominator(denominator);
        } else {
            setNumerator(numerator);
            setDenominator(1);
        }
    }

    /**
     * Calculate gcd.
     *
     * @param a first number
     * @param b second number
     */
    private static int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        if (b == 0 || a == b) {
            return a;
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

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    /**
     * Denominator setter, denominator = 0 not allowed.
     *
     * @param denominator denominator to set to
     */
    public void setDenominator(int denominator) {
        if (denominator != 0) {
            this.denominator = denominator;
        }
    }

    /**
     * Reduce instance's fraction.
     *
     * @return another Fraction instance
     */
    public Solution reduce() {
        int gcd = gcd(numerator, denominator);
        if (gcd != 0) {
            return new Solution(numerator / gcd, denominator / gcd);
        } else {
            return new Solution(numerator, denominator);
        }
    }

    /**
     * Add fraction.
     *
     * @param fraction another fraction
     * @return another Fraction instance
     */
    public Solution add(Solution fraction) {
        if (fraction.getDenominator() != 0) {
            this.numerator = (this.numerator * fraction.getDenominator())
                    + (fraction.getNumerator() * this.denominator);
            this.denominator = this.denominator * fraction.getDenominator();
        }
        return this.reduce();
    }

    /**
     * Subtract fraction.
     *
     * @param fraction another fraction
     * @return another Fraction instance
     */
    public Solution subtract(Solution fraction) {
        if (fraction.getDenominator() != 0) {
            this.numerator = (this.numerator * fraction.getDenominator())
                    - (fraction.getNumerator() * this.denominator);
            this.denominator = this.denominator * fraction.getDenominator();
        }
        return this.reduce();
    }

    /**
     * Multiply fraction.
     *
     * @param fraction another fraction
     * @return another Fraction instance
     */
    public Solution multiply(Solution fraction) {
        if (fraction.getDenominator() != 0) {
            this.numerator = this.numerator * fraction.getNumerator();
            this.denominator = this.denominator * fraction.getDenominator();
        }
        return this.reduce();
    }

    /**
     * Divide fraction.
     *
     * @param fraction another fraction
     * @return another Fraction instance
     */
    public Solution divide(Solution fraction) {
        if (fraction.getDenominator() != 0) {
            this.numerator = this.numerator * fraction.getDenominator();
            this.denominator = this.denominator * fraction.getNumerator();
        }
        return this.reduce();
    }

    /**
     * Compare fraction, return true if same, false if not.
     *
     * @param obj another object that's possibly a fraction
     */
    public boolean equals(Object obj) {
        if (obj instanceof Solution) {
            Solution other = (Solution) obj;

            other = other.reduce();
            return other.getNumerator() == this.reduce().getNumerator()
                    && other.getDenominator() == this.reduce().getDenominator();
        }
        return false;
    }
}
