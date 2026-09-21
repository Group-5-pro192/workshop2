package workshop2;

import java.util.Scanner;
import jdk.nashorn.internal.objects.NativeString;

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
                System.out.println("Please enter numerator: ");
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
                System.out.println("Please enter denominator (non-zero): ");
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
        System.out.println("Successfully added!");
        return f;
    }

    public void run() {
        int func;
        do {

            System.out.println("FRACTION MANAGEMENT");
            System.out.println("1. Input Fraction 1");
            System.out.println("2. Input Fraction 2");
            System.out.println("3. Add Fractions (f1 + f2)");
            System.out.println("5. Multiply Fractions (f1 * f2)");
            System.out.println("6. Divide Fractions (f1 / f2)");
            System.out.println("7. Exit");

            func = readFunction();

        } while (func != 7);
        switch (func) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;

        }
    }

    public static void main(String[] args) {

    }
}
