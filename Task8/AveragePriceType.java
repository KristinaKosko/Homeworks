package com.company;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Counts and displays average price of the goods for definite type entered by the user
 */
public class AveragePriceType extends Command {

    /**
     * Name of command AveragePriceType in program
     *
     * @return - string
     */
    public String getCommandName() {
        return "averagepricetype";
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
     * Selects units of products by their type
     *
     * @return - ArrayList<Unit>, list of selected units
     */
    public ArrayList selectUnit(ArrayList<Unit> units) {
        ArrayList<Unit> selectedUnits = new ArrayList<Unit>();
        Scanner typeIn = new Scanner(System.in);
        String type = new String();
        System.out.println("Enter the type: ");
        if (typeIn.hasNext()) {
            type = typeIn.next();
        }

        for (Unit unit : units) {
            if (unit.getType().equals(type)) {
                selectedUnits.add(unit);
            }
        }
        return selectedUnits;
    }

    /**
     * Counts average price of all items of definite type of goods
     *
     * @param units - ArrayList<Unit>, list of products selected by type
     */
    @Override
    public double executeCommand (ArrayList<Unit> units) {
        double[] unitPrice = new double[units.size()];
        ArrayList<Unit> selectedUnits = selectUnit(units);

        double averagePriceOfTypes = 0;
        for (Unit unit : selectedUnits) {
            for (int i = 0; i < selectedUnits.size(); i++) {
                unitPrice[i] = unit.getPrice();
            }
        }
        for (int i = 0; i < unitPrice.length; i++) {
            averagePriceOfTypes = (averagePriceOfTypes + unitPrice[i]) / (i + 1);
        }
        System.out.println("The average price of your goods for this type:" + averagePriceOfTypes);
        return averagePriceOfTypes;
    }
    /**
    public void getAveragePriceType (ArrayList<Unit> units, String type) {
        BigDecimal price = new BigDecimal(0);
        BigDecimal cost = new BigDecimal(0);
        int countAvailability = 0;
        for (Unit unit : units) {
            if (unit.getType().equals(type)) {
                cost = BigDecimal.valueOf(unit.getPrice());
                price = price.multiply(price.add(cost));
            } else {
                countAvailability++;
            }
        }
        if (countAvailability == units.size()) {
            System.out.println("There are no products of such type!");
            return;
        }
        System.out.println("Average price of items of " + type + " : " + price.divide(cost).toString());
    }
     */
}
