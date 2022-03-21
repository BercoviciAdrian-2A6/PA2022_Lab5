import netscape.javascript.JSObject;

import java.util.HashSet;
import java.util.Random;

public class Item
{
    String id;
    String title;
    String location;
    String author;

    Item (String id,String title, String location)
    {
        this.id = id;
        this.title = title;
        this.location = location;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    @Override
    public String toString() {
        return id + ", " + title + ", " + location + ", " + author;
    }
}
