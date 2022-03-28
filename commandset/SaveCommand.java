package commandset;

import java.util.ArrayList;

public class SaveCommand extends Command
{
    SaveCommand(String commandTrigger, CommandManager commandManager) {
        super(commandTrigger, commandManager);
    }

    @Override
    public void runCommand(ArrayList<String> commandArguments)
    {
        commandManager.getLinkedCatalogue().saveCatalogue();
    }
}
