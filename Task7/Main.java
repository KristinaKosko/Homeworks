package com.company;

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
        int[] result = ChooseTheRule.chooseTheRule();
        for (int i = 0; i < result.length; i++) {
            if (result[i] == 1) {
                System.out.println("The string matches with the " + (i+1) + " rule");
            } else {
                System.out.println("The string does not match with the " + (i+1) + " rule");
            }
        }
    }
}
