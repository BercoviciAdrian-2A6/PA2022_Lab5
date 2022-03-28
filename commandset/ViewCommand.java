package commandset;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ViewCommand extends Command
{
    ViewCommand(String commandTrigger, CommandManager commandManager) {
        super(commandTrigger, commandManager);
    }

    @Override
    public void runCommand(ArrayList<String> commandArguments)
    {
        if (Desktop.isDesktopSupported()) {
            try {
                Desktop desktop = Desktop.getDesktop();
                File myFile = new File("D:/Adrian/infoshitz/Learning_projects/Fakewltate/Sem2/PA/Sem_5.2/Catalogue_" + commandManager.getLinkedCatalogue().getCatalogueName() + ".json");
                desktop.open(myFile);
            } catch (IOException ex) {}
        }
    }
}
