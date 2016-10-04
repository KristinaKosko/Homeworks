package com.company;

import java.util.Scanner;

/**
 * Displays the quadratic equation, reads parameters a, b, c of the equation;
 * finds and displays the roots, if discriminant = 0, > 0
 * if discriminant < 0 - prints "There are no roots!"
 */
public class Main {

    /**
     * User enter the coefficients of quadratic equation, the app finds roots of the equation
     * if the discriminant = 0, > 0 or prints "There is no roots!" if discriminant < 0
     *
     * @param args - array of string, for the information which is entered from the console
     */
    public static void main(String[] args) {

        System.out.println("ax^2 + bx + c = 0");
        System.out.println("Please, enter a");
        double a = getUserNumber();
        boolean checkingAOnZero = checkIfParamAZero(a);
        System.out.println("Please, enter b");
        double b = getUserNumber();
        boolean checkingBOnZero = checkIfParamBZero(b);
        System.out.println("Please, enter c");
        double c = getUserNumber();

        if (checkingAOnZero == false && checkingBOnZero == false) {
            double discriminant = Math.pow(b, 2) - 4 * a * c;
            double x1 = 0, x2 = 0;
            if (discriminant > 0) {
                x1 = (-b - Math.sqrt(discriminant)) / (2 * a);
                x2 = (-b + Math.sqrt(discriminant)) / (2 * a);
            } else if (discriminant < 0 || discriminant == Double.POSITIVE_INFINITY
                    || discriminant == Double.NEGATIVE_INFINITY || discriminant == Double.NaN) {
                System.out.println("There are no roots!");
                System.exit(1);
            } else {
                x1 = x2 = -b / (2 * a);
            }
            System.out.println("The roots of your equation are: " + x1 + " and " + x2);
        } else {
            System.out.println("Parameters a and b should not be equal zero!");
        }
    }

    /**
     * Reads the number, entered by user from the console
     */
    public static double getUserNumber() {
        double numb = 0;
        Scanner in = new Scanner(System.in);
        if (in.hasNextDouble()) {
            numb = in.nextDouble();
            if (Double.isInfinite(numb)) {
                System.out.println("You entered wrong number!");
                System.exit(1);
            }
        } else {
            System.out.println("You entered wrong number!");
            System.exit(1);
        }
        return (numb);
    }

    /**
     * Checks if "a" equals zero, then method returns true
     *
     * @param a parameter of the quadratic equation, entered first by the user
     */
    public static boolean checkIfParamAZero(double a) {
        boolean checkingZeroA = false;
        if (!(a > 0)) {
            if (!(a < 0)) {
                checkingZeroA = true;
            }
        } else {
            checkingZeroA = false;
        }
        return (checkingZeroA);
    }

    /**
     * Checks if "b" equals zero, then method returns true
     *
     * @param b parameter of the quadratic equation, entered second by the user
     */
    public static boolean checkIfParamBZero(double b) {
        boolean checkingZeroB = false;
        if (!(b > 0)) {
            if (!(b < 0)) {
                checkingZeroB = true;
            }
        } else {
            checkingZeroB = false;
        }
        return (checkingZeroB);
    }
}

