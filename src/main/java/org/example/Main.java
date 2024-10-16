package org.example;

import java.util.Scanner; // Import Scanner class from java.util package
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {

            System.out.println("\n--- Scientific Calculator ---");
            System.out.println("1. Square Root (√x)");
            System.out.println("2. Factorial (x!)");
            System.out.println("3. Natural Logarithm (ln(x))");
            System.out.println("4. Power Function (x^b)");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Enter a number between 0 and 4: ");
                scanner.next();
            }
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter a non-negative number for square root: ");
                    double sqrtInput = scanner.nextDouble();
                    System.out.println("√" + sqrtInput + " = " + squareRoot(sqrtInput));
                    break;
                case 2:
                    System.out.print("Enter a non-negative integer for factorial: ");
                    int factInput = scanner.nextInt();
                    System.out.println(factInput + "! = " + factorial(factInput));
                    break;
                case 3:
                    System.out.print("Enter a positive number for natural logarithm: ");
                    double lnInput = scanner.nextDouble();
                    System.out.println("ln(" + lnInput + ") = " + naturalLogarithm(lnInput));
                    break;
                case 4:
                    System.out.print("Enter the base (x): ");
                    double base = scanner.nextDouble();
                    System.out.print("Enter the exponent (b): ");
                    double exponent = scanner.nextDouble();
                    System.out.println(base + "^" + exponent + " = " + powerFunction(base, exponent));
                    break;
                case 0:
                    System.out.println("Exiting the calculator. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        } while (choice != 0);

        scanner.close();
    }

    public static double squareRoot(double x) {
        if (x < 0) {
            logger.error("Attempted to compute square root of negative number: " + x);
            throw new IllegalArgumentException("Cannot compute square root of a negative number.");
        }
        return Math.sqrt(x);
    }

    public static long factorial(int n) {
        if (n < 0) {
            logger.error("Attempted to compute factorial of negative number: " + n);
            throw new IllegalArgumentException("Cannot compute factorial of a negative number.");
        }
        long factorial = 1;
        for (int i = 2; i <= n; i++) {
            factorial *= i;
            if (factorial < 0) {
                throw new ArithmeticException("Factorial result overflow for n = " + n);
            }
        }
        return factorial;
    }

    public static double naturalLogarithm(double x) {
        if (x <= 0) {
            logger.error("Attempted to compute ln of non-positive number: " + x);
            throw new IllegalArgumentException("Cannot compute the natural logarithm of zero or a negative number.");
        }
        return Math.log(x);
    }

    public static double powerFunction(double x, double b) {
        return Math.pow(x, b);
    }
}
