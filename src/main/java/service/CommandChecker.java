package service;

import model.Command;
import picocli.CommandLine;
import util.HelpPrinter;


public class CommandChecker {

    public static void checkCommandFromInput(Command command, String[] arguments) {
        try {
            CommandLine.populateCommand(command, arguments).run();
        } catch (Exception exception) {
            HelpPrinter.printDefaultUtilMessage();
        }
    }

}
