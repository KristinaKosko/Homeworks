package com.company;

public class Main {

    /**
     * Displays in the console "Hello, Name"
     * where the name is taken from the command line
     *
     * @param args - array of parameters, entered in cmd
     */
    public static void main(String[] args) {
        for (String s : args) {
            System.out.println("Hello, " + s);
        }
    }
}
