package com.company;

import java.util.Scanner;

/**
 * Chooses the rule which the entered string corresponds to
 */
public class ChooseTheRule {

    /**
     * Checks what rule does the string correspond to
     *
     * @return - chooser of type int, the string matches with rule - return 1
     *           if the string doesn't match the rule - return 0
     */
    public static int[] chooseTheRule() {
        int[] chooser = new int[4];
        String[] stringOfWords = getUserString();
        Rule[] arrayOfRules = new Rule[4];
        arrayOfRules[0] = new Rule1();
        arrayOfRules[1] = new Rule2();
        arrayOfRules[2] = new Rule3();
        arrayOfRules[3] = new Rule4();
        for (int i = 0; i < arrayOfRules.length; i++) {
            if (arrayOfRules[i].checkingRule(stringOfWords)) {
                chooser[i] = 1;
            } else {
                chooser[i] = 0;
            }
        }
        return (chooser);

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
        //System.out.println(Arrays.deepToString(stringOfWords));
        return stringOfWords;
    }
}
