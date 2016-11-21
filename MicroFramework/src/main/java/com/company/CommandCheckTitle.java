package com.company;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.Arrays;

/**
 * Checks if the title of the opened page corresponds to the required title
 */
public class CommandCheckTitle implements ICommand {

    /**
     * Checks the corresponding of the title of the opened page to the required title of the page
     *
     * @param targetName - String, the required title
     * @return true  - if corresponds;
     *         false - if doesn't
     */
    @Override
    public boolean executeCommand(String[] targetName) {
        double executionTime = System.nanoTime();
        Document doc = CommandOpen.getDocument();
        Elements hrefs = doc.getElementsByTag("title");

        for (Element link : hrefs) {
            if (link.text().equals(targetName[0])) {
                Logger.Instance.Log(true, "["+Command.command + " " + Arrays.toString(Command.arguments)+"]", System.nanoTime()-executionTime);
                return true;
            }
        }
        Logger.Instance.Log(false, "["+Command.command + " " + Arrays.toString(Command.arguments)+"]", System.nanoTime()-executionTime);
        return false;
    }

    /**
     * Name of the command CheckPageTitle in the program
     *
     * @return - String - the name of the command
     */
    @Override
    public String getCommandName() {
        return "checkPageTitle";
    }
}
