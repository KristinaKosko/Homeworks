package com.company;

/**
 * Abstract parent class of command
 * Gets the command name and executes the required command
 */
public interface ICommand {

    /**
     * Executes required command
     *
     * @return true - if execution is successful
     *         false - if not
     */
    public abstract boolean executeCommand(String[] targetCheck) throws Exception;

    /**
     * Getter of the command name in the program
     *
     * @return - String, name of the command
     */
    public abstract String getCommandName();
}
