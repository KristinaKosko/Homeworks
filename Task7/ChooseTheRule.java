package com.company;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Chooses the rule which the entered string corresponds to
 */
public class ChooseTheRule {

    /**
     * Checks what rule does the string correspond to
     */
    public static void chooseTheRule(ArrayList<Rule> arrayOfRules, String[] stringOfWords) {
        for (Rule rule : arrayOfRules) {
            if (rule.checkingRule(stringOfWords)) {
                rule.print();
            }
        }
    }

    /**
     * Asks user to enter a string from the console, reads it into stringOfWords
     *
     * @return array stringOfWords - contains string, entered by the user
     */
    public static String[] getUserString() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the text: ");
        String[] stringOfWords = in.nextLine().split("\\.|,|;|:|\\?|!| ");
        return stringOfWords;
    }
}
