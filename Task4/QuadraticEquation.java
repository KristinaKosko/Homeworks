package com.company;

import java.util.Scanner;

/**
 * Entering and reading parameters of the equation, checking if they equal zero
 */
public class QuadraticEquation {

    double[] arrayOfParams = new double[3];

    /**
     * Reads the number, entered by user from the console
     */
    public static double getUserNumber() throws Exception{
        Scanner in = new Scanner(System.in);
        if (in.hasNextDouble()) {
            return in.nextDouble();
        } else {
            throw new Exception("You entered wrong number!");
        }
    }

    /**
     * Checks if parameter (a or b) equals zero, then method returns true
     *
     * @param b parameter of the quadratic equation, entered second by the user
     */
    public static boolean checkIfParamZero(double b) {
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

    /**
     * Entering and reading parameters a, b, c of the quadratic equation
     */
    public QuadraticEquation() throws Exception {
        System.out.println("Please, enter a");
        arrayOfParams[0] = getUserNumber();
        System.out.println("Please, enter b");
        arrayOfParams[1] = getUserNumber();
        System.out.println("Please, enter c");
        arrayOfParams[2] = getUserNumber();
    }

    /**
     * Getting parameters from the arrayOfParams
     */
    public double[] getParams (){
        return arrayOfParams;
    }
}
