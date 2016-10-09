package com.company;

/**
 * Checks corresponding to the third rule: includes more than 5 words
 */
public class Rule3 extends Rule {

    /**
     * Checks if the entered string contains more than 5 words
     *
     * @param stringOfWords - string of the words entered by the user
     * @return true - if the string contains more than 5 words
     *         false - if doesn't
     */
    public boolean checkingRule(String[] stringOfWords) {
        String[] arrayOfWords = stringOfWords;
        int counter = 0;
        for (int i = 0; i < arrayOfWords.length; i++) {
            counter++;
        }
        if (counter > 5){
            return true;
        } else {
            return false;
        }
    }
}
