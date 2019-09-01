package model.commands;

import model.Command;
import picocli.CommandLine;
import util.HelpPrinter;

import java.io.File;

@CommandLine.Command(name = "cd", mixinStandardHelpOptions = true, version = "cd 1.0",
        description = "Changes the current directory")
public class CD extends Command {

    @CommandLine.Parameters(index = "1", description = "The path to the directory")
    private String pathToDirectory = null;

    @Override
    public void run() {
        try {
            validateChangingDirectory();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            HelpPrinter.printDefaultUtilMessage();
        }
    }

    private void validateChangingDirectory() throws Exception {
        try {
            changeCurrentWorkingDirectory();
        } catch (Exception exception){
            throw new Exception("Wrong path to the directory");
        }
    }

    private void changeCurrentWorkingDirectory() {
        System.out.println("Previous working directory:");
        System.out.println(System.getProperty("user.dir"));
        System.out.println(new File(".").getAbsolutePath());
        System.setProperty("user.dir", pathToDirectory);
        System.out.println("New working directory:");
        System.out.println(System.getProperty("user.dir"));
        System.out.println(new File(".").getAbsolutePath());
    }


}
