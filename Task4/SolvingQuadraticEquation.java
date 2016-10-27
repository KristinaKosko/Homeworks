package com.company;

/**
 * Solve quadratic equation with different values of discriminant (> 0, < 0 or = 0)
 */
public class SolvingQuadraticEquation {

    /**
     * Finding roots of the equation
     *
     * @param a - first parameter of the quadratic equation entered by the user
     * @param b - second parameter of the quadratic equation entered by the user
     * @param c - third parameter of the quadratic equation entered by the user
     */
    public double[] getRoots(double a, double b, double c) {

        double discriminant = Math.pow(b, 2) - 4 * a * c;
        double[] arrayOfRoots = new double[2];
        if (discriminant > 0) {
            arrayOfRoots[0] = (-b - Math.sqrt(discriminant)) / (2 * a);
            arrayOfRoots[1] = (-b + Math.sqrt(discriminant)) / (2 * a);
        } else if (discriminant < 0 || discriminant == Double.POSITIVE_INFINITY
                || discriminant == Double.NEGATIVE_INFINITY || discriminant == Double.NaN) {
            System.out.println("There are no roots!");
            System.exit(1);
        } else {
            arrayOfRoots[0] = arrayOfRoots[1] = -b / (2 * a);
        }
        return arrayOfRoots;
    }
}