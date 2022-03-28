package commandset;

import exceptions.DuplicateCommandTriggerException;
import exceptions.InvalidCommandException;

import java.util.ArrayList;
import java.util.HashSet;

public abstract class Command
{
    CommandManager commandManager;

    static HashSet<String> triggerList = new HashSet<>();

    private String commandTrigger;

    Command (String commandTrigger, CommandManager commandManager)
    {
        this.commandTrigger = commandTrigger;
        this.commandManager = commandManager;

        try
        {
            if (triggerList.contains(commandTrigger))
                throw new DuplicateCommandTriggerException(commandTrigger);
            else
                triggerList.add(commandTrigger);
        }
        catch (DuplicateCommandTriggerException e)
        {
            System.out.println("Duplicate trigger located");
            System.exit(1);
        }
    }

    public abstract void runCommand(ArrayList<String> commandArguments);

    public int triggerCommand(String commandTrigger, ArrayList<String> commandArguments)
    {
        if (this.commandTrigger.equals(commandTrigger)) {
            runCommand(commandArguments);
            return 1;
        }

        return 0;
    }
}
