package com.company;

/**
 * The application reads the lengths of the sides of triangle
 * Gives the information about the type of triangle: 1 - isosceles, 2 - equilateral or 3 - versatile
 */
public class Main {

    /**
     * User enter three sides of the triangle, the app checking if this triangle exists,
     * defines type of it and displays information
     *
     * @param args - array of string, for the information which is entered from the console
     */
    public static void main(String[] args) {

        try {
            double[] sides = new double[3];
            GetUserSides getSides = new GetUserSides();
            int type;
            try {
                for (int i = 0; i < sides.length; i++) {
                    sides[i] = getSides.getUserSide();
                }
            } catch (Exception e) {
                System.out.println("You entered wrong side!!!");
                System.exit(1);
            }
            Triangle triangle = new Triangle(sides[0], sides[1], sides[2]);
            triangle.definesType();
            type = triangle.getType();
            if (type == 1) {
                System.out.println("This triangle is isosceles");
            } else if (type == 2) {
                System.out.println("This triangle is equilateral");
            } else if (type == 3) {
                System.out.println("This triangle is versatile");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
