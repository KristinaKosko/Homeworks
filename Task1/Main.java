package com.company;

/**
 * Reads information entered by the user in command line to array args
 * Then displays it in reverse odder in command line
 */
public class Main {

    /**
     * Displays command line parameters in reverse odder
     *
     * @param args - array of parameters, entered in cmd
     */
    public static void main(String[] args) {
        for (int i = args.length - 1; i >= 0; i--) {
            System.out.println("Argument " + i + " = " + args[i]);
        }
    }
}