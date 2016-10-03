package com.company;

import java.util.Scanner;

/**
 * Application counts the sum, the difference, the multiplication and the division
 * of two numbers entered by user; displays the results of the operations
 */
public class Main {

    /**
     * Entering of two numbers, putting them into array, validation
     *
     * @param args array of string parameters, entered in cmd
     */
    public static void main(String[] args) {

        double first = getUserNumber();
        double second = getUserNumber();
        double sumResult = sumOfNumbs(first, second);
        System.out.println("The sum of your numbers " + first + " + " + second + " = " + sumResult);
        double diffResult = diffOfNumbers(first, second);
        System.out.println("The difference between your numbers " + first + " - " + second + " = " + diffResult);
        double multiplResult = multiplOfNumbers(first, second);
        System.out.println("The multiplication of your numbers " + first + " * " + second + " = " + multiplResult);
        double divResult = divOfNumbers(first, second);
        System.out.println("The division of your numbers " + first + " / " + second + " = " + divResult);
    }

    /**
     * Asking user to enter two numbers, reading numbers
     */
    public static double getUserNumber() {
        double number = 0;
        Scanner in = new Scanner(System.in);
        System.out.println("Please, enter your number:");
        if (in.hasNextDouble()) {
            number = in.nextDouble();
        } else {
            System.out.println("You entered wrong number!");
            System.exit(1);
        }
        return (number);
    }

    /**
     * Counting the sum of numbers
     */

    public static double sumOfNumbs(double first, double second) {
        double sum = first + second;
        return (sum);
    }

    /**
    * Counting the difference between the numbers
    */
    public static double diffOfNumbers(double first, double second) {
        double difference = first - second;
        return (difference);
    }

    /**
    * Counting the multiplication of the numbers
    */
    public static double multiplOfNumbers(double first, double second) {
        double multiplication = first * second;
        return (multiplication);
    }

    /**
    * Counting the division of the numbers
    */
    public static double divOfNumbers(double first, double second) {
        double division = 0;
        if (second != 0) {
            division = first / second;
        } else {
            System.out.println("Division by zero!");
            System.exit(1);
        }
        return (division);
    }

}
