package itemset;

import exceptions.DuplicateIdException;
import org.codehaus.jackson.map.ObjectMapper;

import javax.xml.catalog.Catalog;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Catalogue
{
    private HashMap<String, Integer> idIndexMap = new HashMap<>();
    private String catalogueName;
    private ArrayList<Item> items = new ArrayList<>();

    public Catalogue ()
    {

    }

    public Catalogue ( String catalogueName )
    {
        this.catalogueName = catalogueName;
    }

    public void addItem(Item newItem)
    {
        try//enforces id uniqueness
        {
            if (idIndexMap.containsKey(newItem.getId()))
            {
                throw new DuplicateIdException();
            }
        }
        catch (DuplicateIdException e)
        {
            System.out.println("IDs must be unique");
            return;
        }

        items.add(newItem);
        idIndexMap.put(newItem.getId(), items.size() - 1);
    }

    /**
     * write to json example
     * https://attacomsian.com/blog/jackson-write-json-file
     */
    public void saveCatalogue()
    {
        ObjectMapper mapper = new ObjectMapper();
        try
        {
            mapper.writeValue(Paths.get("Catalogue_" + catalogueName + ".json").toFile(), this);
            //mapper.writeValue(Paths.get("Catalogue_" + catalogueName + ".json").toFile(), items);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * read from json example
     * https://attacomsian.com/blog/jackson-write-json-file
     */

    public void loadCatalogue() throws IOException {

    }

    public void listCatalogue()
    {
        for (Object item : items) System.out.println(item);
    }

    public String getCatalogueName() {
        return catalogueName;
    }

    public HashMap<String, Integer> getIdIndexMap() {
        return idIndexMap;
    }

    public void setIdIndexMap(HashMap<String, Integer> idIndexMap) {
        this.idIndexMap = idIndexMap;
    }

    public void setCatalogueName(String catalogueName) {
        this.catalogueName = catalogueName;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
}
