package Week5;

import java.lang.Math;

public class Fraction {
  private int numerator;
  private int denominator;

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
   * Fraction class constructor.
   *
   * @param numerator   set numerator
   * @param denominator set denominator
   */
  public Fraction(int numerator, int denominator) {
    if (denominator != 0) {
      setNumerator(numerator);
      setDenominator(denominator);
    } else {
      setNumerator(numerator);
      setDenominator(1);
    }
  }

  /**
   * Reduce instance's fraction.
   *
   * @return another Fraction instance
   */
  public Fraction reduce() {
    int gcd = gcd(this.numerator, this.denominator);
    if (gcd != 0) {
      return new Fraction(this.numerator / gcd, this.denominator / gcd);
    } else {
      return new Fraction(this.numerator, this.denominator);
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
   * Add fraction.
   *
   * @param fraction another fraction
   * @return another Fraction instance
   */
  public Fraction add(Fraction fraction) {
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
  public Fraction subtract(Fraction fraction) {
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
  public Fraction multiply(Fraction fraction) {
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
  public Fraction divide(Fraction fraction) {
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
    if (obj instanceof Fraction) {
      Fraction other = (Fraction) obj;

      other = other.reduce();
      return other.getNumerator() == this.reduce().getNumerator()
              && other.getDenominator() == this.reduce().getDenominator();
    }
    return false;
  }
}
