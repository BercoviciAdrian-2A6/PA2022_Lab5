package commandset;

import exceptions.InvalidCommandException;
import itemset.Item;

import java.util.ArrayList;

public class AddCommand extends Command
{
    AddCommand(String commandTrigger, CommandManager commandManager) {
        super(commandTrigger, commandManager);
    }

    @Override
    public void runCommand(ArrayList<String> commandArguments)
    {
        try
        {
            if (commandArguments.size() < 3)
                throw new InvalidCommandException(commandArguments.size());
        }
        catch (InvalidCommandException e)
        {
            System.out.println("Insufficient arguments");
            return;
        }

        Item newItem = new Item(commandArguments);
        commandManager.getLinkedCatalogue().addItem(newItem);
    }
}
