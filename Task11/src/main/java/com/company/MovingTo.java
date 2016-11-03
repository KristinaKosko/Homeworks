package com.company;

import java.util.ArrayList;

/**
 * Describes the movement of the vehicle or person
 */
public interface MovingTo {

    /**
     * Checks if we can move object to the next point
     *
     * @return
     */
    public boolean ifPointsEqual(ArrayList<Point> points);

    /**
     * Calculates the distance of the route
     *
     * @return distance - double, distance of the route
     */
    public abstract double calculateDistance(ArrayList<Point> points);

    /**
     * Counts the total expenses on passing the route
     *
     * @return arrayOfCosts - double[], includes the time and the cost of passing the route
     */
    public abstract double[] countCost(ArrayList<Point> points);
}
