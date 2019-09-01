package model.commands;

import model.Command;
import picocli.CommandLine;

import java.nio.file.Path;
import java.nio.file.Paths;


@CommandLine.Command(name = "pwd", mixinStandardHelpOptions = true, version = "pwd 1.0",
        description = "Prints the current position in the directory tree")

public class PWD extends Command{

    @Override
    public void run() {
        Path currentRelativePath = Paths.get("");
        System.out.println("Current relative path is: " + currentRelativePath.toAbsolutePath());
    }
}
