package workshop2;

public class Fraction {

    private int numerator;
    private int denominator;

    // Constructor 1: fraction 0/1
    public Fraction() {
        this.numerator = 0;
        this.denominator = 1;
    }

    // Constructor 2: fraction numerator/1
    public Fraction(int numerator) {
        this.numerator = numerator;
        this.denominator = 1;
    }

    // Constructor 3: fraction numerator/denominator
    public Fraction(int numerator, int denominator) {
        checkDenominator(denominator);
        this.numerator = numerator;
        this.denominator = denominator;
    }

    // Denominator must not be 0
    private static void checkDenominator(int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero!");
        }
    }

    // The other fraction must not be null
    private static void checkNotNull(Fraction other) {
        if (other == null) {
            throw new IllegalArgumentException("Fraction cannot be null!");
        }
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
        checkDenominator(denominator);
        this.denominator = denominator;
    }

    // Greatest common divisor (Euclid's algorithm)
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

    // Same as gcd above, but for long numbers
    private static long gcd(long number1, long number2) {
        number1 = Math.abs(number1);
        number2 = Math.abs(number2);
        while (number2 != 0) {
            long remainder = number1 % number2;
            number1 = number2;
            number2 = remainder;
        }
        return number1;
    }

    // Simplify a result and create the Fraction.
    // The operations use long so that big multiplications do not overflow int.
    private static Fraction createFraction(long newNumerator, long newDenominator) {
        long divisor = gcd(newNumerator, newDenominator);
        newNumerator /= divisor;
        newDenominator /= divisor;

        if (newDenominator < 0) {
            newNumerator = -newNumerator;
            newDenominator = -newDenominator;
        }

        if (newNumerator > Integer.MAX_VALUE || newNumerator < Integer.MIN_VALUE) {
            throw new ArithmeticException("Result is too large to store as a fraction!");
        }
        if (newDenominator > Integer.MAX_VALUE) {
            throw new ArithmeticException("Result is too small to store as a fraction!");
        }

        return new Fraction((int) newNumerator, (int) newDenominator);
    }

    // Return the simplified form, e.g. -2/8 => -1/4, 6/2 => 3, 0/-8 => 0
    @Override
    public String toString() {
        if (numerator == 0) {
            return "0";
        }

        // Use long so that -2147483648 / -1 does not overflow int
        long divisor = gcd((long) numerator, (long) denominator);
        long simpleNumerator = numerator / divisor;
        long simpleDenominator = denominator / divisor;

        if (simpleDenominator < 0) {
            simpleNumerator = -simpleNumerator;
            simpleDenominator = -simpleDenominator;
        }

        if (simpleDenominator == 1) {
            return "" + simpleNumerator;
        }
        return simpleNumerator + "/" + simpleDenominator;
    }

    // a/b + c/d = (a*d + c*b) / (b*d)
    public Fraction add(Fraction other) {
        checkNotNull(other);
        long newNumerator = (long) this.numerator * other.denominator
                + (long) other.numerator * this.denominator;
        long newDenominator = (long) this.denominator * other.denominator;
        return createFraction(newNumerator, newDenominator);
    }

    public Fraction add(int other) {
        return add(new Fraction(other));
    }

    // a/b - c/d = (a*d - c*b) / (b*d)
    public Fraction subtract(Fraction other) {
        checkNotNull(other);
        long newNumerator = (long) this.numerator * other.denominator
                - (long) other.numerator * this.denominator;
        long newDenominator = (long) this.denominator * other.denominator;
        return createFraction(newNumerator, newDenominator);
    }

    public Fraction subtract(int other) {
        return subtract(new Fraction(other));
    }

    // a/b * c/d = (a*c) / (b*d)
    public Fraction multiply(Fraction other) {
        checkNotNull(other);
        long newNumerator = (long) this.numerator * other.numerator;
        long newDenominator = (long) this.denominator * other.denominator;
        return createFraction(newNumerator, newDenominator);
    }

    public Fraction multiply(int other) {
        return multiply(new Fraction(other));
    }

    // a/b / c/d = (a*d) / (b*c)
    public Fraction divide(Fraction other) {
        checkNotNull(other);
        if (other.numerator == 0) {
            throw new ArithmeticException("Cannot divide by a fraction with numerator 0!");
        }
        long newNumerator = (long) this.numerator * other.denominator;
        long newDenominator = (long) this.denominator * other.numerator;
        return createFraction(newNumerator, newDenominator);
    }

    public Fraction divide(int other) {
        if (other == 0) {
            throw new ArithmeticException("Cannot divide by zero!");
        }
        return divide(new Fraction(other));
    }
}
