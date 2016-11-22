package com.company;


import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main class of application (contains an entry point)
 */
public class Main {

    private static final String REPORT_PATH = "report.txt";

    /**
     * The entry point of the app
     *
     * @param args - array of parameters, entered in command line
     */
    public static void main(String args[]) {

            ArrayList<ICommand> arrayOfCommands = CommandBuilder.commandsBuilder();
            Scanner in = new Scanner(System.in);
            String commandName = null;
        try {
            CommandLine commandLine = new CommandLine();
            TXTFile txtFile = new TXTFile();
            XMLFile xmlFile = new XMLFile();
            JSONFile jsonFile = new JSONFile();
            String[] test;
            String filename = "";
            String checkFileExpansion = null;
            ArrayList<Command> cmds;

            System.out.print("Enter filename: ");
            if (in.hasNext()) {
                filename = in.next();
                try {
                    test = filename.split("\\.");
                    checkFileExpansion = test[1];
                }
                catch (Exception e) {
                    checkFileExpansion = "";
                }
            }
            if (checkFileExpansion.equals("txt")) {
                txtFile.ReadFile(filename);
                cmds = txtFile.getCommands();
            } else if (checkFileExpansion.equals("xml")) {
                xmlFile.readFromXML(filename);
                cmds = xmlFile.getCommands();
            } else if (checkFileExpansion.equals("json")) {
                jsonFile.ReadFile(filename);
                cmds = jsonFile.getCommands();
            } else {
                commandLine.readFromCMD();
                cmds = commandLine.getCommands();
            }

            for(Command cmd : cmds) {
                cmd.checkWhatToExecuteAndExecute(arrayOfCommands);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        Logger.Instance.WriteToFile("report.txt");
    }
}
