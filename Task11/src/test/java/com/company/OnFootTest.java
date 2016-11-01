package com.company;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.ArrayList;

import static org.testng.Assert.*;

public class OnFootTest {
    private OnFoot onFoot;
    ArrayList<Point> list;

    @BeforeTest
    public void setUp() throws Exception {
        onFoot = new OnFoot();
        list = new ArrayList<Point>();
        list.add(new Point(0,0));
    }

    @DataProvider(name = "movePoints")
    public Object[][] moveByCoordinates() {
        return new Object[][] {
                {1.4142135623730951, 1, 1},
                {3.414213562373095, 1, -1},
                {5.414213562373095, -1, -1},
                {6.82842712474619, 0, 0}
        };
    }

    @Test(dataProvider = "movePoints")
    public  void testCountDistance(double result, double x, double y) throws Exception {
        list.add(new Point(x, y));
        Assert.assertEquals(onFoot.calculateDistance(list), result, 0.1);
    }

    @AfterTest
    public void tearDown() throws Exception {
        list.clear();
    }

    @Test
    public void testIfPointsEqual() throws Exception {
        assertFalse(onFoot.ifPointsEqual(list));
    }

    @Test
    public void testCountCost() throws Exception {
        assertEquals(new double[]{0, 0}, onFoot.countCost(list));
    }

    @Test
    public void testCalculateDistance() throws Exception {
        list.add(new Point(1, 1));
        assertEquals(1.4142135623730951, onFoot.calculateDistance(list));
    }
}