package com.company;

/**
 * Abstract class for creating rule1, rule2, rule3 and rule4
 * Prints what rule does string correspond to
 */
abstract class Rule {

    /**
     * Checks satisfying to the rule
     *
     * @param stringOfWords - string of the words entered by the user
     * @return true - if the string satisfies to the rule;
     *         false - if doesn't.
     */
    abstract boolean checkingRule(String[] stringOfWords);

    /**
     * Prints which rule does the string satisfy
     */
    public abstract void print();
}
