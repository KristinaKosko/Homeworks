package com.company;

import java.util.ArrayList;

/**
 * Counts cost of the route passing by bus
 */
public class Bus extends Vehicle {

    private float speed = 80;
    private float fuelConsumption = 13;
    private int passengers = 25;
    private double priceOfFuel = 0.5;

    /**
     * Checks if we can move object to the next point
     *
     * @return - boolean, true  - if we can;
     *                    false - if not
     */
    @Override
    public boolean moveToNextPoint(ArrayList<Point> points) {

        if (!((points.get(0).x == points.get((points.size()) - 1).x) && (points.get(0).y == points.get((points.size()) - 1).y))) {
            return true;
        } else {
            System.out.println(points.get(0).x );
            System.out.println(points.get((points.size()) - 1).x);
            return false;
        }
    }

    /**
     * Calculates the distance of the route
     *
     * @return distance - double, distance of the route
     */
    @Override
    public double calculateDistance(ArrayList<Point> points) {
        double distance = 0;
        double coordX;
        double coordY;

        for (int i = 1; i < points.size(); i++) {
            coordX = (points.get(i).x - points.get(i - 1).x);
            coordY = (points.get(i).y - points.get(i - 1).y);
            distance += Math.sqrt(Math.pow(coordX,2) + Math.pow(coordY, 2));
        }
        return distance;
    }

    /**
     * Counts the total expenses on passing the route
     *
     * @return arrayOfCosts - double[], includes the time and the cost of passing the route
     */
    @Override
    public double[] countCost(ArrayList<Point> points) {
        double routePrice;
        double timeOfRoute;
        double distance;
        distance = calculateDistance(points);
        routePrice = (fuelConsumption / 100) * distance * priceOfFuel / passengers;
        timeOfRoute = distance / speed;
        double[] arrayOfCosts = {timeOfRoute, routePrice};
        return arrayOfCosts;
    }
}

