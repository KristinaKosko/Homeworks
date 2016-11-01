package com.company;

/**
 * The app checks the expenses of using one of the type movement:
 * by bus, by car, by bicycle and on foot
 * Displays total cost of movement and required time for the route
 */
public class Main {

    /**
     * Counts and displays the expenses of using one of the type movement
     *
     * @param args - array of string type for the entered information from the console
     */
    public static void main(String[] args) {
        Route route = new Route("./Route.txt");
        Vehicle car = new Car();
        Vehicle bus = new Bus();
        OnFoot foot = new OnFoot();
        Bicycle bicycle = new Bicycle();
        if (car.ifPointsEqual(route.points)) {
            double[] arrayOfCosts = car.countCost(route.points);
            double hours = Math.round(arrayOfCosts[0]*1000.0)/1000.0;
            double time = Math.round(arrayOfCosts[1]*1000.0)/1000.0;
            System.out.println("Car: required time " + hours + " hours; expenses " + time + " $");
        } else {
            System.out.println("Wrong route!");
        }
        if (bus.ifPointsEqual(route.points)) {
            double[] arrayOfCosts = bus.countCost(route.points);
            double hours = Math.round(arrayOfCosts[0]*1000.0)/1000.0;
            double money = Math.round(arrayOfCosts[1]*1000.0)/1000.0;
            System.out.println("Bus: required time " + hours + " hours; expenses " + money + " $");
        } else {
            System.out.println("Wrong route!");
        }
        if (foot.ifPointsEqual(route.points)) {
            double[] arrayOfCosts = foot.countCost(route.points);
            double hours = Math.round(arrayOfCosts[0]*1000.0)/1000.0;
            double money = Math.round(arrayOfCosts[1]*1000.0)/1000.0;
            System.out.println("On foot: required time " + hours + " hours; expenses " + money + " $");
        } else {
            System.out.println("Wrong route!");
        }
        if (bicycle.ifPointsEqual(route.points)) {
            double[] arrayOfCosts = bicycle.countCost(route.points);
            double hours = Math.round(arrayOfCosts[0]*1000.0)/1000.0;
            double money = Math.round(arrayOfCosts[1]*1000.0)/1000.0;
            System.out.println("Bicycle: required time " + hours + " hours; expenses " + money + " $");
        } else {
            System.out.println("Wrong route!");
        }
    }
}