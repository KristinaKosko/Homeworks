package com.company;

/**
 * Abstract class for creating rule1, rule2, rule3 and rule4
 * Prints what rule does string correspond to
 */
abstract class Rule {
    abstract boolean checkingRule(String[] stringOfWords);
    public abstract void print();
}
