package _12_fraction;

public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }
    //If created empty, assign 1 / 1
    public Fraction() {
        this(1, 1);
    }
    //GET
    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }
    //SET
    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    @Override
    public String toString() {
        return "Fraction{" +
                "numerator=" + numerator +
                ", denominator=" + denominator +
                '}';
    }

    //OPPOSITE
    public void opposite() {
        this.numerator *= -1;
    }
    //RECIPROCAL
    public void reciprocal() {
        int temp = numerator;
        this.numerator = denominator;
        this.denominator = temp;
    }
    //SUM
    public void sum(Fraction fraction) {
        int commonDenominator = this.denominator * fraction.getDenominator();
        int adjustedNumerator1 = this.numerator * fraction.getDenominator();
        int adjustedNumerator2 = fraction.getNumerator() * this.denominator;

        this.numerator = adjustedNumerator1 + adjustedNumerator2;
        this.denominator = commonDenominator;
    }
    //SUB
    public void sub(Fraction fraction) {
        int commonDenominator = this.denominator * fraction.getDenominator();
        int adjustedNumerator1 = this.numerator * fraction.getDenominator();
        int adjustedNumerator2 = fraction.getNumerator() * this.denominator;

        this.numerator = adjustedNumerator1 - adjustedNumerator2;
        this.denominator = commonDenominator;
    }
    //MUL
    public void mul(Fraction fraction) {
        this.numerator *= fraction.getNumerator();
        this.denominator *= fraction.getDenominator();
    }
    //DIV
    public void div(Fraction fraction) {
        this.numerator *= fraction.getDenominator();
        this.denominator *= fraction.getNumerator();
    }
    //POW
    public void pow(int num) {
        this.numerator = (int) Math.pow(this.numerator, num);
        this.denominator = (int) Math.pow(this.denominator, num);
    }
}
