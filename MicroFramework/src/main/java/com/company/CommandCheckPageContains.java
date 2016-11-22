package com.company;

import org.jsoup.nodes.Document;

import java.util.Arrays;

/**
 * A command which checks if the page contains the required text
 */
public class CommandCheckPageContains implements ICommand {

    /**
     * Checks the presence of the required text on the opened page
     *
     * @param targetText - String, the required text
     * @return true  - if contains;
     *         false - if doesn't
     */
    @Override
    public boolean executeCommand (String[] targetText) {
        double executionTime = System.nanoTime();
        Document doc = CommandOpen.getDocument();
        if (doc.text().contains(targetText[0])) {
            Logger.Instance.Log(true, "["+Command.command + " " + Arrays.toString(Command.arguments)+"]", System.nanoTime()-executionTime);
            return true;
        }
        Logger.Instance.Log(false, "["+Command.command + " " + Arrays.toString(Command.arguments)+"]", System.nanoTime()-executionTime);
        return false;
    }

    /**
     * Name of command CheckPageContains in program
     *
     * @return - string - name of the command
     */
    @Override
    public String getCommandName() {
        return "checkPageContains";
    }

}
