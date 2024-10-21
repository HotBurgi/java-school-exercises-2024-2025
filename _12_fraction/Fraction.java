package _12_fraction;

/**
 * Represents a fraction with a numerator and a denominator.
 */
public class Fraction {
    private int numerator;
    private int denominator;

    /**
     * Constructs a Fraction with the specified numerator and denominator.
     *
     * @param numerator   the numerator of the fraction
     * @param denominator the denominator of the fraction, must not be zero
     * @throws IllegalArgumentException if the denominator is zero
     */
    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero.");
        }
        this.numerator = numerator;
        this.denominator = denominator;
        reduce();
    }

    /**
     * Constructs a Fraction with a default value of 1/1.
     */
    public Fraction() {
        this(1, 1);
    }

    /**
     * Returns the numerator of the fraction.
     *
     * @return the numerator
     */
    public int getNumerator() {
        return numerator;
    }

    /**
     * Returns the denominator of the fraction.
     *
     * @return the denominator
     */
    public int getDenominator() {
        return denominator;
    }

    /**
     * Sets the numerator of the fraction.
     *
     * @param numerator the new numerator
     */
    public void setNumerator(int numerator) {
        this.numerator = numerator;
        reduce();
    }

    /**
     * Sets the denominator of the fraction.
     *
     * @param denominator the new denominator, must not be zero
     * @throws IllegalArgumentException if the denominator is zero
     */
    public void setDenominator(int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero.");
        }
        this.denominator = denominator;
        reduce();
    }

    /**
     * Returns a string representation of the fraction.
     *
     * @return a string in the form "numerator/denominator"
     */
    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    /**
     * Negates the fraction.
     */
    public void opposite() {
        this.numerator *= -1;
    }

    /**
     * Converts the fraction to its reciprocal.
     *
     * @throws ArithmeticException if the numerator is zero
     */
    public void reciprocal() {
        if (numerator == 0) {
            throw new ArithmeticException("Cannot take reciprocal of zero.");
        }
        int temp = numerator;
        this.numerator = denominator;
        this.denominator = temp;
    }

    /**
     * Adds another fraction to this fraction.
     *
     * @param fraction the fraction to add
     */
    public void sum(Fraction fraction) {
        int commonDenominator = this.denominator * fraction.getDenominator();
        int adjustedNumerator1 = this.numerator * fraction.getDenominator();
        int adjustedNumerator2 = fraction.getNumerator() * this.denominator;

        this.numerator = adjustedNumerator1 + adjustedNumerator2;
        this.denominator = commonDenominator;
        reduce();
    }

    /**
     * Subtracts another fraction from this fraction.
     *
     * @param fraction the fraction to subtract
     */
    public void sub(Fraction fraction) {
        int commonDenominator = this.denominator * fraction.getDenominator();
        int adjustedNumerator1 = this.numerator * fraction.getDenominator();
        int adjustedNumerator2 = fraction.getNumerator() * this.denominator;

        this.numerator = adjustedNumerator1 - adjustedNumerator2;
        this.denominator = commonDenominator;
        reduce();
    }

    /**
     * Multiplies this fraction by another fraction.
     *
     * @param fraction the fraction to multiply by
     */
    public void mul(Fraction fraction) {
        this.numerator *= fraction.getNumerator();
        this.denominator *= fraction.getDenominator();
        reduce();
    }

    /**
     * Divides this fraction by another fraction.
     *
     * @param fraction the fraction to divide by
     * @throws ArithmeticException if the numerator of the fraction to divide by is zero
     */
    public void div(Fraction fraction) {
        if (fraction.getNumerator() == 0) {
            throw new ArithmeticException("Cannot divide by zero.");
        }
        this.numerator *= fraction.getDenominator();
        this.denominator *= fraction.getNumerator();
        reduce();
    }

    /**
     * Raises this fraction to the power of a given number.
     *
     * @param num the exponent
     */
    public void pow(int num) {
        this.numerator = (int) Math.pow(this.numerator, num);
        this.denominator = (int) Math.pow(this.denominator, num);
        reduce();
    }

    /**
     * Reduces the fraction to its simplest form.
     */
    private void reduce() {
        int gcd = gcd(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;
    }

    /**
     * Computes the greatest common divisor (GCD) of two integers.
     *
     * @param a the first integer
     * @param b the second integer
     * @return the GCD of a and b
     */
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}