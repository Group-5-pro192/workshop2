package workshop2;

import java.util.Scanner;

public class App {

    private static final Scanner sc = new Scanner(System.in);
    private Fraction fraction1 = null;
    private Fraction fraction2 = null;
    private Fraction result = null;

    // Read an integer, ask again until the input is valid
    private int readInt(String prompt, String errorMessage) {
        int value = 0;
        boolean isValid = false;
        do {
            System.out.print(prompt);
            try {
                value = Integer.parseInt(sc.nextLine().trim());
                isValid = true;
            } catch (NumberFormatException e) {
                System.out.println(errorMessage);
            }
        } while (!isValid);
        return value;
    }

    // Read a menu choice from 1 to 7
    private int readFunction() {
        int func = 0;
        boolean isValid = false;
        do {
            func = readInt("Please select a function (1-7): ",
                    "Function must be a positive integer from 1 to 7!");
            if (func >= 1 && func <= 7) {
                isValid = true;
            } else {
                System.out.println("Function must be a positive integer from 1 to 7!");
            }
        } while (!isValid);
        return func;
    }

    // Read a numerator and a non-zero denominator
    private Fraction inputFraction(String name) {
        int numerator = readInt("Please enter numerator: ",
                "Invalid input! Numerator must be an integer. Please try again.");

        int denominator = 0;
        boolean isValid = false;
        do {
            denominator = readInt("Please enter denominator (non-zero): ",
                    "Invalid input! Denominator must be an integer.");
            if (denominator != 0) {
                isValid = true;
            } else {
                System.out.println("Denominator cannot be zero! Please enter another value.");
            }
        } while (!isValid);

        Fraction fraction = new Fraction(numerator, denominator);
        System.out.println("Successfully added " + name + ": " + fraction);
        return fraction;
    }

    // Both fractions must be entered before doing a calculation
    private boolean checkFractionExist() {
        if (fraction1 == null || fraction2 == null) {
            System.out.println("Please input both Fraction 1 and Fraction 2 first!");
            return false;
        }
        return true;
    }

    private void addFractions() {
        if (checkFractionExist()) {
            try {
                result = fraction1.add(fraction2);
                System.out.println("Result: (" + fraction1 + ") + (" + fraction2 + ") = " + result);
            } catch (ArithmeticException e) {
                System.out.println("Math Error: " + e.getMessage());
            }
        }
    }

    private void subtractFractions() {
        if (checkFractionExist()) {
            try {
                result = fraction1.subtract(fraction2);
                System.out.println("Result: (" + fraction1 + ") - (" + fraction2 + ") = " + result);
            } catch (ArithmeticException e) {
                System.out.println("Math Error: " + e.getMessage());
            }
        }
    }

    private void multiplyFractions() {
        if (checkFractionExist()) {
            try {
                result = fraction1.multiply(fraction2);
                System.out.println("Result: (" + fraction1 + ") * (" + fraction2 + ") = " + result);
            } catch (ArithmeticException e) {
                System.out.println("Math Error: " + e.getMessage());
            }
        }
    }

    private void divideFractions() {
        if (checkFractionExist()) {
            try {
                result = fraction1.divide(fraction2);
                System.out.println("Result: (" + fraction1 + ") / (" + fraction2 + ") = " + result);
            } catch (ArithmeticException e) {
                System.out.println("Math Error: " + e.getMessage());
            }
        }
    }

    private void printMenu() {
        System.out.println();
        System.out.println("FRACTION MANAGEMENT");
        System.out.println("1- Enter the first fraction");
        System.out.println("2- Enter the second fraction");
        System.out.println("3- Add 2 fractions");
        System.out.println("4- Subtract 2 fractions");
        System.out.println("5- Multiply 2 fractions");
        System.out.println("6- Divide 2 fractions");
        System.out.println("7- Exit");
    }

    public void run() {
        int func = 0;
        do {
            printMenu();
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
                    System.out.println("FA26 # SE2102 # Workshop02 # Group 5");
                    break;
            }
        } while (func != 7);
    }

    public static void main(String[] args) {
        App app = new App();
        app.run();
    }
}
