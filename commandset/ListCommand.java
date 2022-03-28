package commandset;

import java.util.ArrayList;

public class ListCommand extends Command
{
    ListCommand(String commandTrigger, CommandManager commandManager) {
        super(commandTrigger, commandManager);
    }

    @Override
    public void runCommand(ArrayList<String> commandArguments)
    {
        commandManager.getLinkedCatalogue().listCatalogue();
    }
}
