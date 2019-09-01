package runner;

import service.CommandFactory;
import util.HelpPrinter;

public class CommandRunner {

    public static void main(String[] arguments) {

        try {
            CommandFactory.parseCommandFromInput(arguments);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            HelpPrinter.printDefaultUtilMessage();
        }
    }

}

