package model.commands;

import model.Command;
import picocli.CommandLine;
import util.HelpPrinter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;


@CommandLine.Command(name = "ls", mixinStandardHelpOptions = true, version = "ls 1.0",
        description = "Prints names of files and folders in the current directory")

public class LS extends Command {

    @CommandLine.Parameters(index = "1", description = "The path to the directory")
    private String pathToDirectory = null;

    @CommandLine.Option(names = {"-f", "--files"}, description = "Displays only files in current directory.")
    private boolean files;

    @CommandLine.Option(names = {"-d", "--directories"}, description = "Displays only files in current directory.")
    private boolean directories;

    @Override
    public void run() {
        try {
            optionsValidator();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            HelpPrinter.printDefaultUtilMessage();
        }
    }

    private void optionsValidator() throws Exception {
            try {
                optionsParser();
            } catch (Exception exception) {
                throw new IOException("Check the path to the directory");
            }
        }

    private void optionsParser() throws IOException{
        if(files && directories){
            listFilesAndDirectories();
        }
        else if(directories){
            listDirectoriesOnly();
        }
        else if(files){
            listFilesOnly();
        }
        else{
            listFilesAndDirectories();
        }
    }

    private void listFilesOnly() throws IOException {
            Files.list(Paths.get(pathToDirectory))
               .filter(Files::isRegularFile)
               .forEach(System.out::println);
    }

    private void listDirectoriesOnly() throws IOException {
        Files.list(Paths.get(pathToDirectory))
                    .filter(Files::isDirectory)
                    .forEach(System.out::println);
    }

    private void listFilesAndDirectories() throws IOException {
            Files.list(Paths.get(pathToDirectory))
                    .forEach(System.out::println);
    }

}