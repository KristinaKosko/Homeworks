package com.company;

import java.util.ArrayList;

/**
 * The command, which counts all the types of the entered good
 */
public class CountTypes extends Command {

    /**
     * Name of command CountTypes in program
     *
     * @return - string
     */
    public String getCommandName()
    {
        return "counttypes";
    }

    /**
     * Checks if the entered command was CountTypes, executes executeCommand if true
     *
     * @param nameOfCommand - string, name of command entered by the user
     * @return
     */
    @Override
    public void checkingCommand(String nameOfCommand, ArrayList<Unit> units) {
        if (getCommandName().equals(nameOfCommand)) {
            executeCommand(units);
        }
    }

    /**
     * Counts unique types (that are not repeated)
     *
     * @return - int, amount of units
     */
    @Override
    public double executeCommand(ArrayList<Unit> units){
        String[] unitType = new String[units.size()];
        int numberOfTypes = 0;
        for (Unit unit : units) {
            for (int i = 0; i < units.size(); i++) {
                unitType[i] = unit.getType();
            }
        }
        for (int i = 0; i < units.size(); i++) {
            for (int j = i + 1; j < units.size(); j++) {
                if (!(unitType[i] == unitType[j])){

                }
            }
            numberOfTypes++;
        }
        System.out.println("The number of your types: " + numberOfTypes);
        return numberOfTypes;
    }
}
