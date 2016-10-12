package com.company;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Asks to enter number of goods; then asks to enter Type, Name, Number and Price of each item
 */
public class GetProductInfo {

    /**
     * Asks to enter number of goods
     */
    public static int getProductAmount() {
        System.out.println("Please, enter the amount of products:");
        int amountOfProducts = 0;
        Scanner amount = new Scanner(System.in);
        if (amount.hasNextInt()) {
            amountOfProducts = amount.nextInt();

        } else {
            System.out.println("Incorrect input!!!:");
            System.exit(2);
        }

        return amountOfProducts;
    }

    /**
     * List of units, which contains Type, Name, Number and Price of each unit
     *
     * @param amountOfProducts - int, number of goods
     * @param type             - string, type of unit
     * @param name             - string, name of unit
     * @param amount           - int, number of units
     * @param price            - double, price per unit
     * @return - ArrayList of units
     */
    public static ArrayList<Unit> createUnits(ArrayList<Unit> units, int amountOfProducts, String type, String name, int amount, double price) {
            units.add(new Unit(type, name, amount, price));
        return units;
    }
}
