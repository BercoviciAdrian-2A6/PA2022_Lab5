package commandset;

import exceptions.InvalidCommandException;
import itemset.Catalogue;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

public class LoadCommand extends CreateCommand
{

    LoadCommand(String commandTrigger, CommandManager commandManager) {
        super(commandTrigger, commandManager);
    }

    @Override
    public void runCommand(ArrayList<String> commandArguments)
    {
        if (commandArguments.size() < 1)
        {
            try
            {
                throw new InvalidCommandException(0);
            }
            catch (InvalidCommandException e)
            {
                System.out.println("Catalogue does not exist");
                return;
            }
        }

        String catalogueName = commandArguments.get(0);

        ObjectMapper mapper = new ObjectMapper();

        boolean validPath = true;

        Catalogue catalogue = null;
        try {
            catalogue = mapper.readValue(Paths.get("Catalogue_" + catalogueName + ".json").toFile(), Catalogue.class);
        } catch (IOException e) {
            e.printStackTrace();
            validPath = false;
            System.out.println("Catalogue not found!");
        }
        if (validPath)
            commandManager.setLinkedCatalogue(catalogue);


    }
}
