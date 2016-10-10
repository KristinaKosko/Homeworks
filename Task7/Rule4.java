package com.company;

/**
 * Checks corresponding to the third rule: contains a word from a dictionary
 */
public class Rule4 extends Rule {
    static String[] vocabulary = new String[]{"Thanks", "God", "it", "is", "friday"};

    /**
     * Checks if the entered string contains a word from the dictionary
     *
     * @param stringOfWords - string of the words entered by the user
     * @return true - if the string contains a word from the dictionary
     *         false - if doesn't
     */
    public boolean checkingRule(String[] stringOfWords) {
        String[] arrayOfWords = stringOfWords;
        for (int i = 0; i < arrayOfWords.length; i++) {
            for (int j = 0; j < vocabulary.length; j++) {
                if (arrayOfWords[i].toLowerCase().equals(vocabulary[j].toLowerCase())) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Prints that string corresponds to the 4 rule
     */
    public void print() {
        System.out.println("The string matches with the fourth rule ");
    }
}

