package workshop2;

public class Fraction {

    private int numerator;
    private int denominator;

    public Fraction() {
        this(0, 1);
    }

    public Fraction(int numerator) {
        this(numerator, 1);
    }

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero!");
        }
        this.numerator = numerator;
        this.denominator = denominator;
        simplify();
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

    public void setDenominator(int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero!");
        }
        this.denominator = denominator;
    }

    public static int gcd(int number1, int number2) {
        number1 = Math.abs(number1);
        number2 = Math.abs(number2);
        while (number2 != 0) {
            int remainder = number1 % number2;
            number1 = number2;
            number2 = remainder;
        }
        return number1;
    }

    private void simplify() {
        if (numerator == 0) {
            denominator = 1;
            return;
        }
        int divisor = gcd(numerator, denominator);
        numerator /= divisor;
        denominator /= divisor;
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
    }

    // Setters may leave the fraction unsimplified, so format from a simplified copy.
    @Override
    public String toString() {
        Fraction simplified = new Fraction(numerator, denominator);
        if (simplified.denominator == 1) {
            return String.valueOf(simplified.numerator);
        }
        return simplified.numerator + "/" + simplified.denominator;
    }

    public Fraction add(Fraction other) {
        if (other == null) {
            throw new IllegalArgumentException("Fraction cannot be null.");
        }
        int newNumerator = this.numerator * other.denominator
                + other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction add(int other) {
        return add(new Fraction(other));
    }

    public Fraction subtract(Fraction other) {
        if (other == null) {
            throw new IllegalArgumentException("Fraction cannot be null.");
        }
        int newNumerator = this.numerator * other.denominator
                - other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction subtract(int other) {
        return subtract(new Fraction(other));
    }

    public Fraction multiply(Fraction other) {
        int newNumerator = this.numerator * other.numerator;
        int newDenominator = this.denominator * other.denominator;

        return new Fraction(newNumerator, newDenominator);
    }

// Fraction * Integer
    public Fraction multiply(int other) {
        int newNumerator = this.numerator * other;
        int newDenominator = this.denominator;

        return new Fraction(newNumerator, newDenominator);
    }

// Fraction / Fraction
    public Fraction divide(Fraction other) {

        if (other.numerator == 0) {
            throw new ArithmeticException(
                    "Cannot divide by a fraction with numerator 0."
            );
        }

        int newNumerator = this.numerator * other.denominator;
        int newDenominator = this.denominator * other.numerator;

        return new Fraction(newNumerator, newDenominator);
    }

// Fraction / Integer
    public Fraction divide(int other) {

        if (other == 0) {
            throw new ArithmeticException(
                    "Cannot divide by zero."
            );
        }

        int newNumerator = this.numerator;
        int newDenominator = this.denominator * other;

        return new Fraction(newNumerator, newDenominator);
    }
}
