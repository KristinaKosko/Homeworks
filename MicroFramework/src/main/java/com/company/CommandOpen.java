package com.company;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;


/**
 * A command which opens the required url
 */
public class CommandOpen implements ICommand{

    static Document doc;

    /**
     * Opens the required link
     *
     * @param targetCheck - String[]; the required link, required time-out
     * @return true  - if execution is successful
     *         false - if not
     */
    public boolean executeCommand(String[] targetCheck) throws Exception {

        double executionTime = System.nanoTime();
        StringBuilder text = new StringBuilder();
        Double timeOut = 0.0;
        try {
            timeOut = Double.parseDouble(targetCheck[1]);
        } catch (Exception ex) {
            ex.getMessage();
        }
        try {
            URLConnection connection = new URL(targetCheck[0]).openConnection();
            connection.setConnectTimeout((int) (timeOut * 1000));
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String line = null;
            while ((line = reader.readLine()) != null) {
                text.append(line);
            }
            reader.close();
        } catch (Exception e) {
            Logger.Instance.Log(false, Command.command.toString() + " " + Command.arguments, System.nanoTime()-executionTime);
            return false;
        }

        try {
            doc = Jsoup.parse(text.toString());
            Logger.Instance.Log(true, Command.command.toString() + " " + Arrays.toString(Command.arguments), System.nanoTime()-executionTime);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            doc = null;
            Logger.Instance.Log(false, Command.command.toString() + " " + Arrays.toString(Command.arguments), System.nanoTime()-executionTime);
            return false;
        }
    }

    /**
     * The trivial getter
     *
     * @return - Document, the opened page
     */
    public static Document getDocument() {
        return doc;
    }

    /**
     * Name of the command OpenPage in the program
     *
     * @return - String - the name of the command
     */
    @Override
    public String getCommandName() {
        return "open";
    }
}
