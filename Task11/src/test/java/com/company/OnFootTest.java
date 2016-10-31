package com.company;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class OnFootTest {
    private OnFoot onFoot;
    ArrayList<Point> list;

    @Before
    public void setUp() throws Exception {
        onFoot = new OnFoot();
        list = new ArrayList<Point>();
        list.add(new Point(0,0));
    }

    @After
    public void tearDown() throws Exception {
        list.clear();
    }

    @Test
    public void testMoveToNextPoint() throws Exception {
        assertFalse(onFoot.moveToNextPoint(list));
    }

    @Test
    public void testCountCost() throws Exception {
        assertArrayEquals(new double[] {0, 0}, onFoot.countCost(list), 0.001);
    }

    @Test
    public void testCalculateDistance() throws Exception {
        list.add(new Point(1, 1));
        assertEquals(1.414, onFoot.calculateDistance(list), 0.001);
    }
}