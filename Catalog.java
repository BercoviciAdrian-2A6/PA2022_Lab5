import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Catalog
{
    HashMap<String,Item> items = new HashMap<>();

    public boolean addItem(List<String> args)
    {
        if (args.size() < 3)
            return false;//item could not be added, insufficient arguments

        String id = args.get(0);
        String title = args.get(1);
        String location = args.get(2);
        //more parameters can easily be added


        if (items.containsKey(id))
            return false;//ids must be unique

        Item item = new Item(id, title, location);

        if (args.size() >= 4) {
            String author = args.get(3);
            item.setAuthor(author);
        }

        items.put(id,item);

        return true;//item added successfully
    }

    public boolean load()
    {
        return true;
    }

    public boolean save()
    {
        return true;
    }

    @Override
    public String toString() {
        String output = "Catalog: \n";

        for (String key : items.keySet() )
        {
            output += items.get(key) + "\n";
        }

        return output;
    }
}
