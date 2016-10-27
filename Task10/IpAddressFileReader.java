package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Reads Ip-addresses from file in working directory
 */
public class IpAddressFileReader extends IpAddressReader {
    private String filePath;

    /**
     * Reads file with ip-addresses
     * @param filePath - String, path to the file where ip-addresses are
     */
    public IpAddressFileReader(String filePath) {
        this.filePath = filePath;
    }

    /**
     *
     * @return - ArrayList<String>, list of ip-addresses
     */
    public ArrayList<String> readIp() {
        try {
            BufferedReader readFile = new BufferedReader(new FileReader(filePath));
            ArrayList<String> linesList = new ArrayList<String>();
            String line;
            try {
                while ((line = readFile.readLine()) != null) {
                    if (validateIp(line)) {
                        linesList.add(line);
                    } else {
                        System.out.println(line + " not valid IP!");
                    }
                }
            } catch (IOException e) {
                System.out.println("Error while reading file!");
            }
            return linesList;
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            System.exit(1);
        }
        return null;
    }
}
