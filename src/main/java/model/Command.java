package model;

import picocli.CommandLine;


public abstract class Command implements Runnable {

    @CommandLine.Parameters(index = "0", description = "Command Name.")
    private String commandName;

}
