package com.company;

/**
 * An item of goods, includes Type, Name, Number and Price of each item
 */
public class Unit {
    private String type;
    private String name;
    private int amount;
    private double price;

    /**
     * Constructor, includes Type, Name, Number and Price of each item
     */
    Unit (String type, String name, int amount, double price){
        this.type = type;
        this.name = name;
        this.amount = amount;
        this.price = price;
    }

    /**
     * Gets type of item
     *
     * @return - string, type of product
     */
    public String getType() {
        return type;
    }


    /**
     * Gets amount of items of definite type of goods
     *
     * @return - int, amount of items
     */
    public int getNumber() {
        return amount;
    }

    /**
     * Gets price of item of definite type of goods
     *
     * @return - double, price per item
     */
    public double getPrice() {
        return price;
    }
}
