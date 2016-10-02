package com.company;

import java.util.Scanner;

public class Main {

    /**
     * User enter the coefficients of quadratic equation, the app finds roots of the equation
     * if the discriminant = 0, > 0 or < 0
     *
     * @param args - array of string, for the information which is entered from the console
     */
    public static void main(String[] args) {

        System.out.println("ax^2+bx+c=0");
        System.out.println("Please, enter a");
        double a = getUserNumber();
        System.out.println(a);
        System.out.println("Please, enter b");
        double b = getUserNumber();
        System.out.println(b);
        System.out.println("Please, enter c");
        double c = getUserNumber();
        System.out.println(c);

        double discriminant = Math.pow(b, 2) - 4 * a * c;
        double x1 = 0, x2 = 0;
        if (discriminant > 0) {
            x1 = (-b - Math.sqrt(discriminant)) / (2 * a);
            x2 = (-b + Math.sqrt(discriminant)) / (2 * a);
        } else if (discriminant == 0) {
            x1 = x2 = -b / (2 * a);
        } else if (discriminant < 0) {
            System.out.println("There are no roots!");
            System.exit(1);
        }
        System.out.println("The roots of your equation are: " + x1 + " and " + x2);
    }

    /**
     * Reads the number, entered by user from the console
     */
    public static double getUserNumber() {
        double numb = 0;
        Scanner in = new Scanner(System.in);
        if (in.hasNextDouble()) {
            numb = in.nextDouble();
        } else {
            System.out.println("You entered wrong number!");
            System.exit(1);
        }
        return (numb);
    }
}

