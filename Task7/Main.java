package com.company;

import java.util.ArrayList;

/** The app checks if an entered in the console string corresponds to one of the following rules:
 * 1)Does not contain any numbers
 * 2)Includes only numbers
 * 3)Includes more than 5 words (words are separated by spaces and punctuation marks)
 * 4)Contains a word from a dictionary
 */
public class Main {

    /**
     * Program checks which rule does the entered string correspond to;
     *
     * @param args - array of parameters, entered in command line
     */
    public static void main(String[] args) {

        try {
            String[] inputString = ChooseTheRule.getUserString();
            ArrayList<Rule> result = Builder.rulesBuilder();
            ChooseTheRule.chooseTheRule(result, inputString);
        } catch (Exception e){
            System.out.println ("The string does not match with any rules!");
        }
    }
}
