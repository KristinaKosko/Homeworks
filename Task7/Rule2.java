package com.company;

/**
 * Checks corresponding to the second rule: includes only numbers
 */
public class Rule2 extends Rule {

    /**
     * Checks if the entered string contains only numbers
     *
     * @param stringOfWords - string entered by the user
     * @return true - if the string includes only numbers
     * false - if includes words
     */
    public boolean checkingRule(String[] stringOfWords) {
        String[] arrayOfWords = stringOfWords;
        if (arrayOfWords.length == 1 && (arrayOfWords[0].matches("^[0-9]*$"))) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Prints that string corresponds to the 2 rule
     */
    public void print() {
        System.out.println("The string matches with the second rule ");
    }
}

