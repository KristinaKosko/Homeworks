package com.company;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Creates HTML-table with the contents of the current directory
 */
public class Main {

    /**
     * Line FILE has path to the working directory
     */
    public static final String DIRECTORY = "C:/Users/Kristina/IdeaProjects/Task9/src/com/company/";

    /**
     * Contains name of html file
     */
    public static final String FILE_NAME = "table.html";

    /**
     * Writes the file and creates html-table
     *
     * @param args - array of parameters, entered from command line
     */
    public static void main(String[] args) {
        try {
            String address = System.getProperty("user.dir");
            FileWriter writer = new FileWriter(address + "\\" + FILE_NAME, false);
            HtmlReporter creator = new HtmlReporter(address);
            writer.write(creator.getHtml());
            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.out.println("Output exception");
        } catch (Exception e) {
            System.out.println("Error in program");
        }
    }
}
