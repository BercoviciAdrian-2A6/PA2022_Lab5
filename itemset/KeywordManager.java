package itemset;

import java.security.PublicKey;
import java.util.ArrayList;

public class KeywordManager
{
    public static final String keywords[] = {"SCIENCE", "COOKING", "LITERATURE", "ENGINEERING", "COMPUTER_SCIENCE", "GARDENING", "OUTDOORS"};

    public static String getKeywordAtIndex(int index)
    {
        if (index < 0 || index >= keywords.length)
            return "*invalid keyword*";

        return keywords[index];
    }
}
