package com.company;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * A command which checks if this page contains a link which user needs
 */
public class CommandCheckLinkPresentByHref implements ICommand {

    /**
     * Checks the presence of the target link on the page
     *
     * @param targetLink - String, a checked link
     * @return true  - if the link presents;
     * false - if doesn't
     */
    @Override
    public boolean executeCommand(String[] targetLink) {
        double executionTime = System.nanoTime();
        Document doc = CommandOpen.getDocument();
        Elements hrefs = doc.getElementsByTag("a");

        for (Element link : hrefs) {
            if (link.attr("href").equals(targetLink[0])) {
                Logger.Instance.Log(true, "["+getCommandName()+"]", System.nanoTime()-executionTime);
                return true;
            }
        }
        Logger.Instance.Log(false, "["+getCommandName()+"]", System.nanoTime()-executionTime);
        return false;
    }

    /**
     * Name of the command CheckLinkPresentByHref in the program
     *
     * @return - string - name of the command
     */
    @Override
    public String getCommandName() {
        return "checkLinkPresentByHref";
    }
}
