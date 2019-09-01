package service;

import model.commands.*;

import java.io.IOException;

public class CommandFactory {

    public static void parseCommandFromInput(String[] commandLineArguments) throws Exception {

        String commandName = commandLineArguments[0];

        if (commandLineArguments.length < 1) {
            throw new ArrayIndexOutOfBoundsException("No parameters found");
        }

        switch (commandName) {
            case "man":
                CommandChecker.checkCommandFromInput(new MAN(), commandLineArguments);
                break;
            case "ls":
                CommandChecker.checkCommandFromInput(new LS(), commandLineArguments);
                break;
            case "pwd":
                CommandChecker.checkCommandFromInput(new PWD(), commandLineArguments);
                break;
            case "cat":
                CommandChecker.checkCommandFromInput(new CAT(), commandLineArguments);
                break;
            case "cd":
                CommandChecker.checkCommandFromInput(new CD(), commandLineArguments);
                break;
            default:
                throw new IOException("Invalid input. Try again.\n");
        }
    }

}
