package com.company;

import java.util.ArrayList;

/**
 * Class which create rules
 */
public class Builder {

    /**
     * Creates rules and add them into ArrayList
     *
     * @return arrayOfRules - array of created rules Rule1, Rule2, Rule3, Rule4
     */
    public static ArrayList<Rule> rulesBuilder() {
        ArrayList<Rule> arrayOfRules = new ArrayList<Rule>();
        arrayOfRules.add(new Rule1());
        arrayOfRules.add(new Rule2());
        arrayOfRules.add(new Rule3());
        arrayOfRules.add(new Rule4());
        return arrayOfRules;
    }
}
