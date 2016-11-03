package com.company;

/**
 * Checks if triangle exists, then creates this triangle, determines and gets the type
 *
 * type = 1 - isosceles; type = 2 - equilateral, type = 3 - versatile
 */
public class Triangle {

    private double a;
    private double b;
    private double c;
    private int type;

    /**
     * Verifying the existence of a triangle (each side mustn't be equal 0 or be < 0
     * and the length of the biggest side mustn't be bigger then the total length of the others).
     * Creates triangle if it exists
     *
     * @param a - double, length of the 1-st side of the triangle
     * @param b - double, length of the 2-nd side of the triangle
     * @param c - double, length of the 3-rd side of the triangle
     */
    public Triangle(double a, double b, double c) throws Exception {
        if (a <= 0 || b <= 0 || c <= 0
                || a + b < c
                || b + c < a
                || c + a < b
                ) {
            throw new Exception("Not triangle");
        }
        if (Double.compare(a, Double.NaN) == 0 || Double.compare(b, Double.NaN) == 0
                || Double.compare(c, Double.NaN) == 0) {
            throw new Exception("NaN detected");
        }
        if (Double.compare(a, Double.NEGATIVE_INFINITY) == 0 || Double.compare(b, Double.NEGATIVE_INFINITY) == 0
                || Double.compare(c, Double.NEGATIVE_INFINITY) == 0) {
            throw new Exception("NEGATIVE INFINITY detected");
        }
        if (Double.compare(a, Double.POSITIVE_INFINITY) == 0 || Double.compare(b, Double.POSITIVE_INFINITY) == 0
                || Double.compare(c, Double.POSITIVE_INFINITY) == 0) {
            throw new Exception("POSITIVE INFINITY detected");
        }
            this.a = a;
            this.b = b;
            this.c = c;
    }

    /**
     * According to the lengths of the sides entered by the user, defines the type of triangle
     * (if a = b - isosceles, if a = b = c - equilateral, else - versatile)
     */
    public void definesType() {
        if (a == b || b == c || c == a) {
            type = 1;
        } else if (a == b && b == c) {
            type = 2;
        } else if (a != b && b != c) {
            type = 3;
        }
    }

    /**
     * Trivial getter of the triangle's type
     *
     * @return type - int, type of the triangle
     */
    public int getType() {
        return type;
    }
}
