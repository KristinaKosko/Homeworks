package com.company;

/**
 * Reads string Name entered by the user in command line
 * and displays it after "Hello, ";
 * Example: Name = Kristina, displays "Hello, Kristina"
 */
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
