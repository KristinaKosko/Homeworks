package com.company;

import java.util.ArrayList;

/**
 * Class which create commands
 */
public class CommandBuilder {

    /**
     * Creates commands and add them into ArrayList
     *
     * @return arrayOfCommands - array of created commands CommandCheckLinkPresentByHref, CommandCheckLinkPresentByName,
     * CommandCheckPageContains, CommandCheckTitle, CommandOpen
     */
    public static ArrayList<ICommand> commandsBuilder() {
        ArrayList<ICommand> arrayOfCommands = new ArrayList<ICommand>();
        arrayOfCommands.add(new CommandCheckLinkPresentByHref());
        arrayOfCommands.add(new CommandCheckLinkPresentByName());
        arrayOfCommands.add(new CommandCheckPageContains());
        arrayOfCommands.add(new CommandCheckTitle());
        arrayOfCommands.add(new CommandOpen());
        return arrayOfCommands;
    }
}