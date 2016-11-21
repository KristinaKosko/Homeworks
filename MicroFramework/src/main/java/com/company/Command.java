package com.company;

import org.w3c.dom.NamedNodeMap;

import java.util.ArrayList;

/**
 * A class for creating a command, using the constructors
 */
public class Command {
    public static String command;
    public static String arguments[];

    /**
     * Creates object command, gets name of command and map of arguments
     *
     * @param command - String, name of the command
     * @param attributes - NamedNodeMap, list of attributes of the command
     */
    public Command(String command, NamedNodeMap attributes) {
        this.command = command;
        ArrayList<String> arguments = new ArrayList<String>();
        for (int i = 0; i < attributes.getLength(); i++) {
            arguments.add(attributes.item(i).getNodeValue());
        }
        this.arguments = arguments.toArray(new String[0]);
    }

    /**
     * Creates object command, gets name of command and map of arguments
     *
     * @param command - String, name of the command
     * @param arguments - ArrayList<String>, list of arguments of the command
     */
    public Command(String command, ArrayList<String> arguments) {
        this.command = command;
        this.arguments = arguments.toArray(new String[0]);
    }

    /**
     * Creates object command, gets name of command and map of arguments
     * First element of the ArrayList is name of command,
     * other elements converts into the array of arguments of this command
     *
     * @param tokens - ArrayList<String>, contains name of the command and
     *                 array of arguments of this command
     */
    public Command(ArrayList<String> tokens) {
        this.command = tokens.get(0);
        tokens.remove(0);
        this.arguments = tokens.toArray(new String[0]);
    }

    /**
     * Checks what command the app must execute
     *
     * @param listOfCommands - ArrayList<ICommand>, list of objects of commands
     */
    public void checkWhatToExecuteAndExecute(ArrayList<ICommand> listOfCommands) {
        for(ICommand cmd: listOfCommands) {
            if(command.equals(cmd.getCommandName())) {
                try {
                    cmd.executeCommand(arguments);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}