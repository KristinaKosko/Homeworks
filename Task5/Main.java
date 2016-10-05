package com.company;

import java.util.Scanner;

/**
 * The application reads the lengths of the sides of triangle
 * Gives the information about the type of triangle: isosceles, equilateral or versatile
 */
public class Main {

    /**
     * User enter three sides of the triangle, the app checking if this triangle exists
     * @param args - array of string, for the information which is entered from the console
     */
    public static void main(String[] args) {

        double[] sides = new double[3];
        for (int i = 0; i < sides.length; i++) {
            sides[i] = getUserSide();
        }
        if (isFigureValid(sides)) {
            if (sides[0] == sides[1] || sides[1] == sides[2] || sides[2] == sides[0]) {
                System.out.println("The triangle is isosceles");
            } else if (sides[0] == sides[1] && sides[1] == sides[2]) {
                System.out.println("The triangle is equilateral");
            } else if (sides[0] != sides[1] && sides[1] != sides[2]) {
                System.out.println("The triangle is versatile");
            }
        }
    }

    /**
    * Verifying the existence of a triangle (each side mustn't be equal 0 or be < 0
    * and the length of the biggest side mustn't be bigger then the total length of the others)
    */
    public static boolean isFigureValid(double sides[]){
        for (int i = 0; i < sides.length; i++){
            if (sides[i] == 0 ||sides[i] < 0
                    || sides[0]+sides[1]<sides[2]
                    || sides[1]+sides[2]<sides[0]
                    || sides[2]+sides[0]<sides[1]){
                System.out.println("Sorry, this triangle is not exist!");
                System.exit(1);
            }
        }
        return (true);
    }

    /**
     * Asks user to enter the length of the side of the triangle;
     * reads it into side
     */
    public static double getUserSide() {
        Scanner in = new Scanner(System.in);
        System.out.println("Please, enter the side of the triangle: ");
        double side = 0;
        if (in.hasNextDouble()) {
            side = in.nextDouble();
        } else {
            System.out.println("You entered wrong side!!!");
            System.exit(1);
        }
        return (side);
    }
}
