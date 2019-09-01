package model.commands;

import model.Command;
import picocli.CommandLine;
import service.CommandHelpFactory;
import util.HelpPrinter;

@CommandLine.Command(name = "man", mixinStandardHelpOptions = true, version = "man 1.0",
        description = "Prints the help on the command.")

public class MAN extends Command {

    @CommandLine.Parameters(index = "1", description = "Command Name to show help.")
    private String commandNameToShowHelp = null;

    @Override
    public void run() {
        try {
            CommandHelpFactory.printCommandHelp(commandNameToShowHelp);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            HelpPrinter.printDefaultUtilMessage();
        }

    }

}
