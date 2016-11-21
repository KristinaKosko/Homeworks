package com.company;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * A command which checks if the link presented on the page corresponds to the desired name
 */
public class CommandCheckLinkPresentByName implements ICommand {

   /**
    * Checks the corresponding to the desired name
    *
    * @param targetName - String, the target name of the link
    * @return true  - if correspond;
    *         false - if doesn't
    */
   @Override
    public boolean executeCommand(String[] targetName) {
       double executionTime = System.nanoTime();
        Document doc = CommandOpen.getDocument();
        Elements hrefs = doc.getElementsByTag("a");

        for (Element link : hrefs) {
            if (link.text().equals(targetName)) {
                Logger.Instance.Log(true, "["+Command.command + " " + Command.arguments+"]", System.nanoTime()-executionTime);
                return true;
            }
        }
        Logger.Instance.Log(false, "["+Command.command + " " + Command.arguments+"]", System.nanoTime()-executionTime);
        return false;
    }

    /**
     * Name of the command CheckLinkPresentByName in program
     *
     * @return - string - the name of the command
     */
    @Override
    public String getCommandName() {
        return "checkLinkPresentByName";
    }
}
