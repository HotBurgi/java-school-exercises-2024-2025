package _12_fraction;

public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero.");
        }
        this.numerator = numerator;
        this.denominator = denominator;
        reduce();
    }

    public Fraction() {
        this(1, 1);
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
        reduce();
    }

    public void setDenominator(int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero.");
        }
        this.denominator = denominator;
        reduce();
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    public void opposite() {
        this.numerator *= -1;
    }

    public void reciprocal() {
        if (numerator == 0) {
            throw new ArithmeticException("Cannot take reciprocal of zero.");
        }
        int temp = numerator;
        this.numerator = denominator;
        this.denominator = temp;
    }

    public void sum(Fraction fraction) {
        int commonDenominator = this.denominator * fraction.getDenominator();
        int adjustedNumerator1 = this.numerator * fraction.getDenominator();
        int adjustedNumerator2 = fraction.getNumerator() * this.denominator;

        this.numerator = adjustedNumerator1 + adjustedNumerator2;
        this.denominator = commonDenominator;
        reduce();
    }

    public void sub(Fraction fraction) {
        int commonDenominator = this.denominator * fraction.getDenominator();
        int adjustedNumerator1 = this.numerator * fraction.getDenominator();
        int adjustedNumerator2 = fraction.getNumerator() * this.denominator;

        this.numerator = adjustedNumerator1 - adjustedNumerator2;
        this.denominator = commonDenominator;
        reduce();
    }

    public void mul(Fraction fraction) {
        this.numerator *= fraction.getNumerator();
        this.denominator *= fraction.getDenominator();
        reduce();
    }

    public void div(Fraction fraction) {
        if (fraction.getNumerator() == 0) {
            throw new ArithmeticException("Cannot divide by zero.");
        }
        this.numerator *= fraction.getDenominator();
        this.denominator *= fraction.getNumerator();
        reduce();
    }

    public void pow(int num) {
        this.numerator = (int) Math.pow(this.numerator, num);
        this.denominator = (int) Math.pow(this.denominator, num);
        reduce();
    }

    private void reduce() {
        int gcd = gcd(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}