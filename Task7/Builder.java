package com.company;

import java.util.ArrayList;

/**
 * Class which create rules
 */
public class Builder {

    public static ArrayList<Rule> rulesBuilder() {
        ArrayList<Rule> arrayOfRules = new ArrayList<Rule>();
        arrayOfRules.add(new Rule1());
        arrayOfRules.add(new Rule2());
        arrayOfRules.add(new Rule3());
        arrayOfRules.add(new Rule4());
        return arrayOfRules;
    }
}
