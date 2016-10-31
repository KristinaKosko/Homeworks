package com.company;

/**
 * Checkpoint of the route; contains its coordinates x and y
 */
public class Point {
    public double x;
    public double y;

    /**
     * Builds point of the route, includes coordinates x and y of the checkpoint
     *
     * @param x - double, coordinate x of the point
     * @param y - double, coordinate y of the same point
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}