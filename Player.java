import java.util.ArrayList;

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player
{
    private ArrayList<Item> playerItems;

    /**
     * Constructor for objects of class Player
     */
    public Player()
    {
        playerItems = new ArrayList<>();
    }

    /**
     * This method add an item inside ArrayList
     */
    public void addItem(Item item)
    {
        playerItems.add(item);
    }
}
