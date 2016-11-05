package com.company;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.math.BigDecimal;

public class TriangleTest {

    Triangle triangle;

    @DataProvider(name = "ValidIsoscelesTriangle")
    public Object[][] setValidSidesOfTheIsoscelesTriangle() {
        return new Object[][] {
                {BigDecimal.valueOf(10), BigDecimal.valueOf(10), BigDecimal.valueOf(11)},
                {BigDecimal.valueOf(10), BigDecimal.valueOf(11), BigDecimal.valueOf(10)},
                {BigDecimal.valueOf(11), BigDecimal.valueOf(10), BigDecimal.valueOf(10)},

                {BigDecimal.valueOf(Double.MAX_VALUE), BigDecimal.valueOf(Double.MAX_VALUE), BigDecimal.valueOf(11)},
                {BigDecimal.valueOf(11), BigDecimal.valueOf(Double.MAX_VALUE), BigDecimal.valueOf(Double.MAX_VALUE)},
                {BigDecimal.valueOf(Double.MAX_VALUE), BigDecimal.valueOf(11), BigDecimal.valueOf(Double.MAX_VALUE)},

                {BigDecimal.valueOf(Double.MIN_VALUE), BigDecimal.valueOf(11), BigDecimal.valueOf(11)},
                {BigDecimal.valueOf(11), BigDecimal.valueOf(Double.MIN_VALUE), BigDecimal.valueOf(11)},
                {BigDecimal.valueOf(11), BigDecimal.valueOf(11), BigDecimal.valueOf(Double.MIN_VALUE)},
        };
    }

    @Test(dataProvider = "ValidIsoscelesTriangle")
    public void testPositiveSetValidSidesOfTheIsoscelesTriangle(BigDecimal a, BigDecimal b, BigDecimal c) throws Exception {
        triangle = new Triangle(a, b, c);
        Assert.assertEquals(triangle.definesType(), Triangle.ISOSCELES);
    }


    @DataProvider(name = "setInvalidSides")
    public Object[][] setNotValidSidesOfTheTriangle() {
        return new Object[][] {
                {BigDecimal.valueOf(0), BigDecimal.valueOf(1), BigDecimal.valueOf(1)},
                {BigDecimal.valueOf(1), BigDecimal.valueOf(0), BigDecimal.valueOf(1)},
                {BigDecimal.valueOf(1), BigDecimal.valueOf(1), BigDecimal.valueOf(0)},

                {BigDecimal.valueOf(-1), BigDecimal.valueOf(1), BigDecimal.valueOf(1)},
                {BigDecimal.valueOf(1), BigDecimal.valueOf(-1), BigDecimal.valueOf(1)},
                {BigDecimal.valueOf(1), BigDecimal.valueOf(1), BigDecimal.valueOf(-1)},

                {null, BigDecimal.valueOf(1), BigDecimal.valueOf(1)},
                {BigDecimal.valueOf(1), null, BigDecimal.valueOf(1)},
                {BigDecimal.valueOf(1), BigDecimal.valueOf(1), null},
        };
    }

    @Test(dataProvider = "setInvalidSides", expectedExceptions = Exception.class)
    public void testNegativeSetNotValidSidesOfTheTriangle(BigDecimal a, BigDecimal b, BigDecimal c) throws Exception {
        triangle = new Triangle(a, b, c);
    }

    @DataProvider(name = "ValidEquilateralTriangle")
    public Object[][] setValidSidesOfTheEquilateralTriangle() {
        return new Object[][]{
                {BigDecimal.valueOf(1), BigDecimal.valueOf(1), BigDecimal.valueOf(1)},
                {BigDecimal.valueOf(Double.MAX_VALUE), BigDecimal.valueOf(Double.MAX_VALUE),
                        BigDecimal.valueOf(Double.MAX_VALUE)},
                {BigDecimal.valueOf(Double.MIN_VALUE), BigDecimal.valueOf(Double.MIN_VALUE),
                        BigDecimal.valueOf(Double.MIN_VALUE)}
        };
    }

    @Test(dataProvider = "ValidEquilateralTriangle")
    public void testPositiveSetValidSidesOfTheEquilateralTriangle(BigDecimal a, BigDecimal b, BigDecimal c) throws Exception {
        triangle = new Triangle(a, b, c);
        Assert.assertEquals(triangle.definesType(), Triangle.EQUILATERAL);
    }


    @DataProvider(name = "ValidVersatileTriangle")
    public Object[][] setValidSidesOfTheVersatileTriangle() {
        return new Object[][]{
                {BigDecimal.valueOf(3), BigDecimal.valueOf(4), BigDecimal.valueOf(5)},
                {BigDecimal.valueOf(Double.MAX_VALUE), BigDecimal.valueOf(100),
                        BigDecimal.valueOf(Double.MAX_VALUE).subtract(BigDecimal.valueOf(10)),},
                {BigDecimal.valueOf(Double.MAX_VALUE).subtract(BigDecimal.valueOf(10)), BigDecimal.valueOf(Double.MAX_VALUE),
                        BigDecimal.valueOf(100)},
                {BigDecimal.valueOf(100), BigDecimal.valueOf(Double.MAX_VALUE).subtract(BigDecimal.valueOf(10)),
                        BigDecimal.valueOf(Double.MAX_VALUE)}
        };
    }

    @Test(dataProvider = "ValidVersatileTriangle")
    public void testPositiveSetValidSidesOfTheVersatileTriangle(BigDecimal a, BigDecimal b, BigDecimal c) throws Exception {
        triangle = new Triangle(a, b, c);
        Assert.assertEquals(triangle.definesType(), Triangle.VERSATILE);
    }
}