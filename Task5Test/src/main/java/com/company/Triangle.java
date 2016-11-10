package com.company;

import java.math.BigDecimal;

/**
 * Checks if triangle exists, then creates this triangle, determines and gets the type
 *
 * types: isosceles a = b; equilateral a = b = c, versatile a != b != c
 */
public class Triangle {

    private BigDecimal a;
    private BigDecimal b;
    private BigDecimal c;
    private int type;

    //Types of the triangle
    public static final String ISOSCELES = "Triangle is Isosceles";
    public static final String EQUILATERAL = "Triangle is Equilateral";
    public static final String VERSATILE = "Triangle is Versatile";

    public static final int TYPE_ISOSCELES = 1;
    public static final int TYPE_EQUILATERAL = 2;
    public static final int TYPE_VERSATILE = 3;

    /**
     * Verifying the existence of a triangle (each side mustn't be equal 0 or be < 0
     * and the length of the biggest side mustn't be bigger then the total length of the others).
     * Creates triangle if it exists
     *
     * @param a - bigDecimal, length of the 1-st side of the triangle
     * @param b - bigDecimal, length of the 2-nd side of the triangle
     * @param c - bigDecimal, length of the 3-rd side of the triangle
     */
    public Triangle(BigDecimal a, BigDecimal b, BigDecimal c) throws Exception {
        if (a.compareTo(BigDecimal.valueOf(0)) <= 0 || b.compareTo(BigDecimal.valueOf(0)) <= 0 ||
                c.compareTo(BigDecimal.valueOf(0)) <= 0
                || c.compareTo(a.add(b)) > 0
                || a.compareTo(b.add(c)) > 0
                || b.compareTo(c.add(a)) > 0
                ) {
            throw new Exception("Triangle isn't exist");
        }
        this.a = a;
        this.b = b;
        this.c = c;
        type = definesType(a, b, c);
    }

    /**
     * According to the lengths of the sides entered by the user, defines the type of triangle
     * (if a = b - isosceles, if a = b = c - equilateral, else - versatile)
     */
    private int definesType(BigDecimal a, BigDecimal b, BigDecimal c) {
        if (a.compareTo(b) == 0 && b.compareTo(c) == 0 && c.compareTo(a) == 0) {
            return TYPE_EQUILATERAL;
        } else if (a.compareTo(b) == 0 || b.compareTo(c) == 0 || c.compareTo(a) == 0) {
            return TYPE_ISOSCELES;
        } else {
            return TYPE_VERSATILE;
        }
    }

    /**
     * @return type - int, triangle's type
     */
    public int getType() {
        return type;
    }

    /**
     * Defines the name of the triangles Type
     *
     * @return String - type of the triangle
     */
    public String getTypeName() {
        switch (type) {
            case TYPE_ISOSCELES: {
                return ISOSCELES;
            }
            case TYPE_EQUILATERAL: {
                return EQUILATERAL;
            }
        }
        return VERSATILE;
    }
}
