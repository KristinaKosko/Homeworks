package com.company;

import java.util.Scanner;

/**
 * Entering the lengths of sides from the console by the user
 */
public class GetUserSides {

    /**
     * Asks user to enter the length of the side of the triangle;
     * reads it into side
     */
    public double getUserSide() throws NumberFormatException {
        Scanner in = new Scanner(System.in);
        System.out.println("Please, enter the side of the triangle: ");
        return (in.nextDouble());
    }
}
