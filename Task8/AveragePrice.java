package com.company;

import java.util.ArrayList;

/**
 * The command which count average price of all units entered by the user
 */
public class AveragePrice extends Command {

    /**
     * Name of command AveragePrice in program
     *
     * @return - string
     */
    public String getCommandName() {
        return "averageprice";
    }

    /**
     * Checks if the entered command was CountAll, executes executeCommand if true
     *
     * @param nameOfCommand - string, name of command entered by the user
     */
    @Override
    public void checkingCommand(String nameOfCommand, ArrayList<Unit> units) {
        if (getCommandName().equals(nameOfCommand)) {
            executeCommand(units);
        }
    }
    /**
     * Counts average price of all goods
     *
     * @return - int, amount of units
     */
    @Override
    public double executeCommand(ArrayList<Unit> units) {

        int UnitCount =0;
        double UnitPrice =0;
        for (Unit unit : units) {
            UnitCount+=unit.getNumber();
            UnitPrice+=unit.getNumber()*unit.getPrice();
        }

        UnitPrice=UnitPrice/UnitCount;

        System.out.println("The average price of your goods: " + UnitPrice);
        return UnitPrice;
    }
}
