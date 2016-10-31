package com.company;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CarTest {
    private Car car;
    ArrayList<Point> list;

    @Before
    public void setUp() throws Exception {
        car = new Car();
        list = new ArrayList<Point>();
        list.add(new Point(0, 0));

    }

    @After
    public void tearDown() throws Exception {
        list.clear();
    }

    @Test
    public void testMoveToNextPoint() throws Exception {
        assertFalse(car.moveToNextPoint(list));
    }

    @Test
    public void testCountCost() throws Exception {
        assertArrayEquals(new double[]{0, 0}, car.countCost(list), 0.001);
    }

    @Test
    public void testCalculateDistance() throws Exception {
        list.add(new Point(1, 1));
        assertEquals(1.414, car.calculateDistance(list), 0.001);
    }
}