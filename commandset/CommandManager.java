package commandset;

import exceptions.InvalidCommandException;
import itemset.Catalogue;

import javax.annotation.processing.SupportedSourceVersion;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class CommandManager
{
    Catalogue linkedCatalogue;
    ArrayList<Command> catalogueGetters = new ArrayList<>();
    ArrayList<Command> commands = new ArrayList<>();

    public CommandManager ()
    {
        CreateCommand createCommand = new CreateCommand("CreateCatalogue", this);
        LoadCommand loadCommand = new LoadCommand("LoadCatalogue", this);
        catalogueGetters.add(createCommand);
        catalogueGetters.add(loadCommand);

        commands.add(createCommand);
        commands.add( loadCommand );
        commands.add( new SaveCommand("SaveCatalogue", this) );
        commands.add( new ListCommand("ListCatalogue", this) );
        commands.add( new ViewCommand("ViewCatalogue", this) );
        commands.add( new ReportCommand("ReportCatalogue", this) );
        commands.add( new AddCommand("AddItem", this) );
    }

    public Catalogue getLinkedCatalogue() {
        return linkedCatalogue;
    }

    public void setLinkedCatalogue(Catalogue catalogue)
    {
        linkedCatalogue = catalogue;
    }

    public boolean runCommand( String commandLine , boolean initializersOnly)
    {
        Scanner commandScanner = new Scanner(commandLine);

        String commandTrigger = commandScanner.next();

        ArrayList<String> commandArguments = new ArrayList<String>();

        while (commandScanner.hasNext())
            commandArguments.add(commandScanner.next());

        try
        {
            int validCommand = 0;

            if (initializersOnly) {
                for (int i = 0; i < catalogueGetters.size(); i++)
                    validCommand += catalogueGetters.get(i).triggerCommand(commandTrigger, commandArguments);
            }
            else {
                for (int i = 0; i < commands.size(); i++)
                    validCommand += commands.get(i).triggerCommand(commandTrigger, commandArguments);
            }

            if (validCommand == 0)
                throw new InvalidCommandException(commandLine);
        }
        catch ( InvalidCommandException e )
        {
            System.out.println("Please input a valid command!");
        }


        return true;
    }

    public void selectCatalogue()
    {
        while (true)
        {
            System.out.println("Please select an item catalogue: ");

            Scanner keyboardInputScanner = new Scanner(System.in);
            String commandLine = keyboardInputScanner.nextLine();
            runCommand(commandLine, true);

            if (linkedCatalogue != null)
            {
                System.out.println("Catalogue chosen successfully!");
                break;
            }
        }
    }
}
