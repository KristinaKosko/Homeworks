package com.company;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Asks user to enter the name of the command, then guided by the entered string selects which command to execute
 */
public class SelectCommand {

    /**
     * Checks what command to execute (by comparing the entered name with the name of the existing command)
     */
    public static void chooseTheCommand(ArrayList<Command> arrayOfCommands, String nameOfCommand, ArrayList<Unit> units) {
        String name = nameOfCommand.toLowerCase();
        for (Command command : arrayOfCommands) {
            if (command.getCommandName().toLowerCase().equals(name)) {
                command.executeCommand(units);
                return;
            }
        }
        System.out.println("Sorry, i don't have such command.");
    }

    /**
     * Asks the user to enter a command from the list
     *
     * @return nameOfCommand - string, a name of the entered command
     */
    public static String getNameOfCommand() {
        System.out.println("Please, enter command");
        System.out.println("(choose one of: CountTypes, CountAll, AveragePrice, AveragePriceType, exit): ");
        Scanner in = new Scanner(System.in);
        String nameOfCommand = in.next();
        if (nameOfCommand.equals("exit")) {
            System.out.println("Hope to see you soon, bye!");
            System.exit(0);
        }
        return nameOfCommand;
    }
}
