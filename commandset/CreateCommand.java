package commandset;

import exceptions.InvalidCommandException;
import itemset.Catalogue;

import java.util.ArrayList;

public class CreateCommand extends Command
{
    CreateCommand(String commandTrigger, CommandManager commandManager) {
        super(commandTrigger, commandManager);
    }

    @Override
    public void runCommand(ArrayList<String> commandArguments){
        if (commandArguments.size() < 1)
        {
            try
            {
                throw new InvalidCommandException(0);
            }
            catch (InvalidCommandException e)
            {
                System.out.println("Input a valid name");
                return;
            }
        }

        String catalogueName = commandArguments.get(0);

        Catalogue catalogue = new Catalogue(catalogueName);

        commandManager.setLinkedCatalogue(catalogue);
    }
}
