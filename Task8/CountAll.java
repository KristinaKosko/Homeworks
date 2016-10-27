package com.company;

import java.util.ArrayList;

/**
 * The command, which counts the total number of units
 */
public class CountAll extends Command {

    /**
     * Name of command CountAll in program
     *
     * @return - string
     */
    public String getCommandName() {
        return "countall";
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
     * Counts all items of entered goods
     *
     * @return - int, number of all items
     */
    public double executeCommand(ArrayList<Unit> units) {
        int[] unitNumber = new int[units.size()];
        int numberOfAll = 0;
        for (Unit unit : units) {
            for (int i = 0; i < units.size(); i++) {
                unitNumber[i] = unit.getNumber();
            }
        }
        for (int i = 0; i < unitNumber.length; i++) {
            numberOfAll += unitNumber[i];
        }
        System.out.println("The number of your goods: " + numberOfAll);
        return numberOfAll;
    }
}
