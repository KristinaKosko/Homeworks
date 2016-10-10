package com.company;

/**
 * Checks corresponding to the first rule: does not contain numbers
 */
public class Rule1 extends Rule {

    /**
     * Checks if the entered string contains any numbers
     *
     * @param stringOfWords - string of the words entered by the user
     * @return true - if the string doesn't contain numbers at all;
     *         false - if contains numbers
     */
    public boolean checkingRule(String[] stringOfWords) {
           for (int i = 0; i < stringOfWords.length; i++) {
               for (int j = 0; j < stringOfWords[i].length(); j++) {
                   if (Character.isDigit(stringOfWords[i].charAt(j))) {
                       return false;
                   }
               }
           }
        return true;
    }

    /**
     * Prints that string corresponds to the 1 rule
     */
    public void print() {
        System.out.println("The string matches with the first rule ");
    }
}
