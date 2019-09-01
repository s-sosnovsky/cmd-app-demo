package model.commands;

import model.Command;
import picocli.CommandLine;
import util.HelpPrinter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

@CommandLine.Command(name = "cat", mixinStandardHelpOptions = true, version = "cat 1.0",
        description = "Prints contents of the file")
public class CAT extends Command {

    @CommandLine.Parameters(index = "1", description = "The path to the file")
    private String pathToFile = null;

    @Override
    public void run() {
        try {
            printFileContents();
        } catch (Exception exception) {
            HelpPrinter.printDefaultUtilMessage();
            System.out.println(exception.getMessage());
        }
    }

    private void printFileContents() throws IOException {
        try {
            System.out.println(readFileContents());
        } catch (Exception exception) {
            throw new IOException("Wrong path to file");
        }

    }

    private String readFileContents() {
        StringBuilder contentBuilder = new StringBuilder();
        try (Stream<String> stream = Files.lines( Paths.get(pathToFile), StandardCharsets.UTF_8))
        {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        }
        catch (IOException e) {

        }
        return contentBuilder.toString();
    }

}
