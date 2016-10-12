package com.company;

import java.util.ArrayList;

/**
 * Class which create commands
 */
public class CommandBuilder {

    /**
     * Creates commands and add them into ArrayList
     *
     * @return arrayOfCommands - array of created commands CountTypes, CountAll, AveragePrice, AveragePriceAll
     */
    public static ArrayList<Command> commandsBuilder() {
        ArrayList<Command> arrayOfCommands = new ArrayList<Command>();
        arrayOfCommands.add(new CountTypes());
        arrayOfCommands.add(new CountAll());
        arrayOfCommands.add(new AveragePrice());
        arrayOfCommands.add(new AveragePriceType());
        return arrayOfCommands;
    }
}