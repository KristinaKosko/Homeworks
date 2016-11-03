package com.company;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TriangleTest {

    Triangle triangle;

    @BeforeMethod
    public void setUp() throws Exception {
        triangle = new Triangle(2, 2, 4);
        triangle.definesType();
    }

    @Test
    public void testPositiveIsoscelesTriangleGetType() throws Exception {
        Assert.assertEquals(triangle.getType(), 1);
    }

    @DataProvider(name = "setSides")
    public Object[][] setNotValidSidesOfTheTriangle() {
        return new Object[][] {
                {Double.NaN, 1, 1},
                {Double.NEGATIVE_INFINITY, 1, 1},
                {Double.POSITIVE_INFINITY, 1, 1},
                {-1, -1, -1},
                {0, 0, 0}
        };
    }

    @Test(dataProvider = "setSides", expectedExceptions = Exception.class)
    public void testNegativeSetNotValidSidesTriangle(double a, double b, double c) throws Exception {
        triangle = new Triangle(a, b, c);
    }
}