package util;

public class HelpPrinter {

    private static String defaultHelpMessage;

    static {
        defaultHelpMessage = "Usage: java -jar cmd-file-app-1.0-SNAPSHOT.jar [command] [options] [parameters] \n\n"
                + "Commands list: \n- ls;\n- man;\n- pwd;\n\n"
                + "Type \"java -jar cmd-file-app-1.0-SNAPSHOT.jar man [command]\" to find out the command usage.";
    }

    public static String getDefaultHelpMessage() {
        return defaultHelpMessage;
    }

    public static void printDefaultUtilMessage() {
        System.out.println(getDefaultHelpMessage());
    }

}
