package com.company;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Route {
    ArrayList<Point> points;

    public Route() {
        points = new ArrayList<Point>();
    }

    public Route(String path) {
        points = new ArrayList<Point>();
        ReadFile(path);
    }

    /**
     * Reads information from file, creates list of checkpoints
     * which contains their coordinates
     */
    public void ReadFile(String path) {
        try {
            BufferedReader readFile = new BufferedReader(new FileReader(path));
            ArrayList<String> lines = new ArrayList<String>();
            String line;

            try {
                while ((line = readFile.readLine()) != null) {
                    if (validateFileRow(line)) {
                        lines.add(line);
                    } else {
                        System.out.println(line + " not valid checkpoint!");
                        throw new IllegalArgumentException("There is not valid checkpoint in route file!");
                    }
                }

                for (String string : lines) {
                    String[] coordinates = string.split(" ");
                    double x = Double.parseDouble(coordinates[0]);
                    double y = Double.parseDouble(coordinates[1]);
                    points.add(new Point(x, y));
                }
            } catch (IOException e) {
                System.out.println("Error while reading file!");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            System.exit(1);
        }
    }

    /**
     * Validation of checkpoints' coordinates
     *
     * @return true  - if valid
     * false - if not
     */
    private Boolean validateFileRow(String fileRow) {
        String[] coordinates = fileRow.split(" ");
        Pattern pattern = Pattern.compile(" ");
        int count = 0;
        Matcher matcher = pattern.matcher(fileRow);

        while (matcher.find()) {
            count++;
        }

        if (count != 1) {
            return false;
        }

        for (String part : coordinates) {
            try {
                Double.parseDouble(part);
            } catch (NumberFormatException ex) {
                return false;
            }
        }
        return true;
    }
}