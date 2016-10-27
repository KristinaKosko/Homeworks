package com.company;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Asks to enter Type, Name, Number and Price of each item and fills ArrayList with these elements
 */
public class InputUnits {

    /**
     * Asks to enter Type, Name, Number and Price of each item
     *
     * @return units - ArrayList <Unit>, list of information about each unit
     */
    public static ArrayList<Unit> inputUnits(int amount) {
        ArrayList<Unit> units = new ArrayList<Unit>();
        for (int i = 0; i < amount; i++) {
            System.out.println("Type: ");
            String typeOfProduct = new String();
            Scanner type = new Scanner(System.in);
            if (type.hasNextLine()) {
                typeOfProduct = type.nextLine();
            }
            System.out.println("Name: ");
            String nameOfProduct = new String();
            Scanner name = new Scanner(System.in);
            if (name.hasNextLine()) {
                nameOfProduct = name.nextLine();
            }
            System.out.println("Number of units: ");
            int numberOfUnits = 0;
            Scanner number = new Scanner(System.in);
            if (number.hasNextInt()) {
                numberOfUnits = number.nextInt();
            }
            System.out.println("Price per unit: ");
            double pricePerUnit = 0;
            Scanner price = new Scanner(System.in);
            if (price.hasNextDouble()) {
                pricePerUnit = price.nextDouble();
            }
            System.out.println("__________________" + "\n");
            units = GetProductInfo.createUnits(units, amount, typeOfProduct, nameOfProduct, numberOfUnits, pricePerUnit);
        }
        return units;
    }
}
