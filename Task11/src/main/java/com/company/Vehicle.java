package com.company;

import java.util.ArrayList;

/**
 * Counts cost of the route passing by the vehicle (bus or car)
 */
public abstract class Vehicle implements MovingTo {

    /**
     * Checks if we can move object to the next point
     */
    @Override
    public abstract boolean ifPointsEqual(ArrayList<Point> points);

    /**
     * Calculates the distance of the route
     *
     * @return distance - double, distance of the route
     */
    @Override
    public abstract double calculateDistance(ArrayList<Point> points);

}
