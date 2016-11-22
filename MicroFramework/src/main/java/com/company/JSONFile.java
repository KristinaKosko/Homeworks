package com.company;

import org.json.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.Set;

/**
 * Reads data(instructions) from the JSON-file
 */
public class JSONFile {
    ArrayList<Command> commands;

    /**
     * Creates list of commands
     */
    public JSONFile() {
        commands = new ArrayList<Command>();
    }

    /**
     * Reads data(instructions) from the JSON-file, adds the name of the command
     * and its params to the ArrayList of commands
     *
     * @param file - the read JSON-file
     */
    public void ReadFile(String file) {
        StringBuilder stringBuilder = new StringBuilder(512);

        //Open file
        BufferedReader readFile = null;
        try {
            Reader streamReader = new BufferedReader(new FileReader(file));
            int c = 0;
            while ((c = streamReader.read()) != -1) {
                stringBuilder.append((char) c);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String json = stringBuilder.toString();
        JSONObject obj = new JSONObject(json);
        Set<String> commnds = obj.keySet();
        for (String command : commnds) {
            ArrayList<String> arguments = new ArrayList<String>();
            for (Object object : obj.getJSONArray(command)) {
                arguments.add(object.toString());
            }
            commands.add(new Command(command, arguments));
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