package workshop2;

import java.util.Scanner;

public class App {

    private static final Scanner sc = new Scanner(System.in);
    private static Fraction fraction1 = null;
    private static Fraction fraction2 = null;

    public int readFunction() {
        boolean isDataValid = true;
        int func = 0;

        do {
            try {
                System.out.printf("Please select a function (1-7): ");
                func = Integer.parseInt(sc.nextLine().trim());
                if (func < 1 || func > 7) {
                    throw new Exception("Function must be a positive integer from 1 to 7!");
                } else {
                    isDataValid = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Function must be a positive integer from 1 to 7!");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (!isDataValid);
        return func;
    }

    private static Fraction inputFraction(String name) {
        int numerator = 0;
        boolean isNumValid = false;
        do {
            try {
                System.out.printf("Please enter numerator: ");
                numerator = Integer.parseInt(sc.nextLine().trim());
                isNumValid = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Numerator must be an integer. Please try again.");
            }
        } while (!isNumValid);

        int demonitrator = 0;
        boolean isDenValid = false;
        do {
            try {
                System.out.printf("Please enter denominator (non-zero): ");
                demonitrator = Integer.parseInt(sc.nextLine().trim());
                if (demonitrator == 0) {
                    throw new IllegalArgumentException("Denominator cannot be zero! Please enter another value.");
                }
                isDenValid = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Denominator must be an integer.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (!isDenValid);
        Fraction f = new Fraction(numerator, demonitrator);
        System.out.println("Successfully added" + name + "!");
        return f;
    }

    private boolean checkFractionExist() {
        if (fraction1 == null || fraction2 == null) {
            System.out.printf("Please input both Fraction 1 and Fraction 2 first!");
            return false;
        }
        return true;
    }

    private void addFractions() {
        if (checkFractionExist()) {
            Fraction result = fraction1.add(fraction2);
            System.out.printf("Result: (%s) + (%s) = %s\\n", fraction1, fraction2, result);
        }
    }

    private void multiplyFractions() {
        if (checkFractionExist()) {
            Fraction result = fraction1.multiply(fraction2);
            System.out.printf("Result: (%s) * (%s) = %s\\n", fraction1, fraction2, result);
        }
    }

    private void subtractFractions() {
        if (checkFractionExist()) {
            Fraction result = fraction1.subtract(fraction2);
            System.out.printf("Result: (%s) - (%s) = %s\\n", fraction1, fraction2, result);
        }
    }

    private void divideFractions() {
        if (checkFractionExist()) {
            try {
                Fraction result = fraction1.divide(fraction2);
                System.out.printf("Result: (%s) / (%s) = %s\n", fraction1, fraction2, result);
            } catch (ArithmeticException e) {
                System.out.println("\"Math Error: \" + e.getMessage()");
            }
        }
    }

    public void run() {
        int func;
        do {

            System.out.println("\nFRACTION MANAGEMENT");
            System.out.println("1. Input Fraction 1");
            System.out.println("2. Input Fraction 2");
            System.out.println("3. Add Fractions (f1 + f2)");
            System.out.println("5. Multiply Fractions (f1 * f2)");
            System.out.println("6. Divide Fractions (f1 / f2)");
            System.out.println("7. Exit");

            func = readFunction();

            switch (func) {
                case 1:
                    fraction1 = inputFraction("Fraction 1");
                    break;
                case 2:
                    fraction2 = inputFraction("Fraction 2");
                    break;
                case 3:
                    addFractions();
                    break;
                case 4:
                    subtractFractions();
                    break;
                case 5:
                    multiplyFractions();
                    break;
                case 6:
                    divideFractions();
                    break;
                case 7:
                    System.out.println("\"FA26 # SE2102 # Workshop02 # Group 5");
                    break;
            }
        } while (func != 7);
    }

    public static void main(String[] args) {
        App app = new App();
        app.run();
    }
}
