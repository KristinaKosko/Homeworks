package com.company;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Reads instructions from command line
 */
public class CommandLine {

    ArrayList<Command> commands;

    public CommandLine() {
        commands = new ArrayList<Command>();
    }

    /**
     * Reads instructions from the command line
     * gets names of the commands and parameters of these commands
     */
    public void readFromCMD() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter command:");
        if (in.hasNextLine()) {
            ArrayList<String> tokens = new ArrayList<String>();
            for (String token : (in.nextLine()).split("\"")) {
                token = token.trim();
                if (!(token.length() == 0)) {
                    tokens.add(token);
                }
            }
            commands.add(new Command(tokens));
        }
    }

    /**
     * Trivial getter
     *
     * @return commands - ArrayList<Command>
     */
    public ArrayList<Command> getCommands() {
        return commands;
    }
}