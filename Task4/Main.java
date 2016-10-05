package com.company;

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
        try {
            System.out.println("ax^2 + bx + c = 0");
            QuadraticEquation qe = new QuadraticEquation();
            double[] parameters = qe.getParams();
            SolvingQuadraticEquation solveQE = new SolvingQuadraticEquation();

            if (!(qe.checkIfParamZero(parameters[0])) && !(qe.checkIfParamZero(parameters[1]))) {
                double[] roots = solveQE.getRoots(parameters[0], parameters[1], parameters[2]);
                System.out.println("The roots of your equation are: " + roots[0] + " and " + roots[1]);
            } else {
                System.out.println("Parameters a and b should not be equal zero!");
            }
        } catch (Exception error) {
            System.out.println("Something is wrong: " + error.getMessage());
        }
    }
}






