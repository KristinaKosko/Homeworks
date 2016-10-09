package com.company;

/**
 * Checks corresponding to the third rule: contains a word from a dictionary
 */
public class Rule4 {
    static String[] vocabulary = new String[]{"Opozdal", "potomu", "chto", "utrom", "perelazil", "cherez", "babu", "i", "zatsepilsya", "herom"};
    /**
     * Checks if the entered string contains a word from the dictionary
     *
     * @param stringOfWords - string of the words entered by the user
     * @return true - if the string contains a word from the dictionary
     *         false - if doesn't
     */
    public boolean checkingRule4(String[] stringOfWords) {
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
}

