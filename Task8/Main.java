package com.company;

import java.util.ArrayList;

/**
 * The app asks and reads from the command line number of goods
 * and information about each good entered by the user: type, name, number, price per item
 * Contains commands: "count types" - to count and display the amount of entered types;
 *                   "count all" - to count and display the total number of goods;
 *                   "average price" - to count and display the average price of the goods;
 *                   "average price type" - to count and display average price of the goods for definite type;
 *                   "exit" - to stop execution of the app.
 */
public class Main {

    /**
     * Gets users list of products, asks for command
     *
     * @param args - array of parameters, entered in command line
     */
    public static void main(String[] args) {

        int numberOfProducts = GetProductInfo.getProductAmount();
        ArrayList<Unit> units = InputUnits.inputUnits(numberOfProducts);

        ArrayList<Command> commands = new CommandBuilder().commandsBuilder();

        while(true) {
            String nameOfCommand = SelectCommand.getNameOfCommand();
            SelectCommand.chooseTheCommand(CommandBuilder.commandsBuilder(), nameOfCommand, units);
        }
    }
}
