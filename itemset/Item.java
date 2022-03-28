package itemset;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;


public class Item implements Serializable
{
    private String id;
    private String title;
    private String location;
    private String author;
    private String publishYear;
    private String description;
    private ArrayList<Integer> keywordIndexes = new ArrayList<>();

    //every single field that you want stored in a json must be serializable aka either public or with a getter

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getLocation() {
        return location;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublishYear() {
        return publishYear;
    }

    public String getDescription() {
        return description;
    }

    //i think the same is true for setters when reading..

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublishYear(String publishYear) {
        this.publishYear = publishYear;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Integer> getKeywordIndexes() {
        return keywordIndexes;
    }

    public void setKeywordIndexes(ArrayList<Integer> keywordIndexes) {
        this.keywordIndexes = keywordIndexes;
    }

    public Item()
    {

    }

    public Item (ArrayList<String> arguments)
    {
        id = arguments.get(0);
        title = arguments.get(1);
        location = arguments.get(2);

        if (arguments.size() >= 4)
            author = arguments.get(3);

        if (arguments.size() >= 5)
            publishYear = arguments.get(4);

        if (arguments.size() >= 6)
            description = arguments.get(5);

        for (int argument = 6; argument < arguments.size(); argument++)
        {
            int keywordIndex =  Integer.parseInt( arguments.get(argument));

            keywordIndexes.add(keywordIndex);
        }

    }

    @Override
    public String toString() {
        String output =  id  + " - " + title + " - " + location;
        if (author != null)
            output += " - author: " + author;
        if (publishYear != null)
            output += " - publish year: " + publishYear;

        if (description != null)
            output += " - description: " + description;

        output += " - Keywords: ";

        for (int index : keywordIndexes)
        {
            output += KeywordManager.getKeywordAtIndex(index) + ", ";
        }

        return output;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return id.equals(item.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
