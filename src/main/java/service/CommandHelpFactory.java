package service;

import model.commands.*;
import picocli.CommandLine;

import java.io.IOException;

import static java.lang.System.out;

public class CommandHelpFactory {

    public static void printCommandHelp(String commandNameToShowHelp) throws IOException {
        switch (commandNameToShowHelp) {
            case "man":
                CommandLine.usage(new MAN(), out, CommandLine.Help.Ansi.AUTO);
                break;
            case "ls":
                CommandLine.usage(new LS(), out, CommandLine.Help.Ansi.AUTO);
                break;
            case "pwd":
                CommandLine.usage(new PWD(), out, CommandLine.Help.Ansi.AUTO);
                break;
            case "cat":
                CommandLine.usage(new CAT(), out, CommandLine.Help.Ansi.AUTO);
                break;
            case "cd":
                CommandLine.usage(new CD(), out, CommandLine.Help.Ansi.AUTO);
                break;
            default:
                throw new IOException(
                        "\nPlease mind the input.\n");
        }
    }
}
