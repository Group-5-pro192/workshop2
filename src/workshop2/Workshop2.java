package workshop2;

public class Fraction {

    private int numerator;
    private int denominator;

    public Fraction() {
        numerator = 0;
        denominator = 1;
    }

    public Fraction(int numerator) {
        this.numerator = numerator;
        this.denominator = 1;
    }

    public Fraction(int numerator, int denominator) {

        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero.");
        }

        this.numerator = numerator;
        this.denominator = denominator;
    }

    public int getNumerator() {
        return this.numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return this.denominator;
    }

    public void setDenominator(int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero.");
        }

        this.denominator = denominator;
    }
}
