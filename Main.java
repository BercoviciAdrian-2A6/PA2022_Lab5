import commandset.CommandManager;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        CommandManager commandManager = new CommandManager();

        commandManager.selectCatalogue();

        System.out.println("You can now manipulate the catalogue");

        while (true) {
            Scanner keyboardInputScanner = new Scanner(System.in);
            String commandLine = keyboardInputScanner.nextLine();
            commandManager.runCommand(commandLine, false);
        }
    }
}
