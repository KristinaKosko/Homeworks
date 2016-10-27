package com.company;

import java.util.ArrayList;

/**
 * Parent class Command (for commands
 */
abstract class Command {

    /**
     * Name of command in program
     * @return - string, name of command
     */
    public abstract String getCommandName();

    /**
     * Checks what command was entered
     */
    public abstract void checkingCommand(String nameOfCommand, ArrayList<Unit> units);

    /**
     * Starts execution of entered command
     */
    public abstract double executeCommand(ArrayList<Unit> units);
}
