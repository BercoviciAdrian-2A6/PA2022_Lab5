package commandset;

import java.util.ArrayList;

public class ReportCommand extends Command
{
    ReportCommand(String commandTrigger, CommandManager commandManager) {
        super(commandTrigger, commandManager);
    }

    @Override
    public void runCommand(ArrayList<String> commandArguments) {

    }
}
