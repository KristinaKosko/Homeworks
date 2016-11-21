package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Reads data(instructions) from the Text File
 */
public class TXTFile {

    ArrayList<Command> commands;

    /**
     * Reads information from the file
     */
    public TXTFile() {
        commands = new ArrayList<Command>();
    }

    /**
     * Reads information from the file
     *
     * @param filePath - String, path to file
     */
    public TXTFile(String filePath) {
        ReadFile(filePath);
    }

    /**
     * Reads information from the file
     * *
     * @param path - String, path to file
     */
    public void ReadFile(String path) {
        ArrayList<String> lines = new ArrayList<String>();
        String line;

        //Open file
        BufferedReader readFile = null;
        try {
            readFile = new BufferedReader(new FileReader(path));
        } catch (FileNotFoundException e1) {
            System.out.println("File not found!");
            System.exit(1);
        }

        //Read lines to ArrayList if valid
        try {
            while ((line = readFile.readLine()) != null) {
                if (validateFileRow(line)) {
                    lines.add(line);
                } else {
                    System.out.println(line + " not valid ");
                    throw new IllegalArgumentException("There is not valid commands in file!");
                }
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        for (String string : lines) {
            ArrayList<String> tokens = new ArrayList<String>();
            for (String token : string.split("\"")) {
                token = token.trim();
                if (!(token.length() == 0)) {
                    tokens.add(token);
                }
            }
            commands.add(new Command(tokens));
        }
    }

    /**
     * Validation of TXT File of commands
     *
     * @param fileRow - String, data from TXT file
     * @return true  - if valid
     *         false - if not
     */
    private Boolean validateFileRow(String fileRow) {
        String[] commands = fileRow.split(" ");
        Pattern pattern = Pattern.compile(" ");
        int count = 0;
        Matcher matcher = pattern.matcher(fileRow);

        while (matcher.find()) {
            count++;
        }

        if (count < 1) {
            return false;
        }
        return true;
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