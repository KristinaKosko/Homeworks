package com.company;

import java.util.Scanner;

/**
 * Chooses the rule which the entered string corresponds to
 */
public class ChooseTheRule {

    public static int[] chooseTheRule() {
        int[] chooser = new int[4];
        String[] stringOfWords = getUserString();
        Rule1 rule1 = new Rule1();
        if (rule1.checkingRule1(stringOfWords)){
            chooser[0] = 1;
        } else {
            chooser[0] = 0;
        }
        Rule2 rule2 = new Rule2();
        if (rule2.checkingRule2(stringOfWords)){
            chooser[1] = 1;
        } else {
            chooser[1] = 0;
        }
        Rule3 rule3 = new Rule3();
        if (rule3.checkingRule3(stringOfWords)){
            chooser[2] = 1;
        } else {
            chooser[3] = 0;
        }
        Rule4 rule4 = new Rule4();
        if (rule4.checkingRule4(stringOfWords)){
            chooser[3] = 1;
        } else {
            chooser[3] = 0;
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
