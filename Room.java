import java.util.HashMap;
import java.util.Set;
import java.util.ArrayList;
/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  The exits are labelled north, 
 * east, south, west.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 * 
 * @author  Michael KÃ¶lling and David J. Barnes
 * @version 2011.07.31
 */
public class Room 
{
    private String description;
    private HashMap<String,Room> exits;
    private ArrayList<Item> items;
    private boolean canTeletransport;

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description, boolean canTeletransport) 
    {
        this.description = description;
        exits = new HashMap<>();
        items = new ArrayList<>();
        this.canTeletransport = canTeletransport;
    }

    /**
     * @return The description of the room.
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * @return The size of the ArrayList of the room.
     */
    public int getItemsSize()
    {
        return items.size();
    }

    /**
     * @return The item that you indicate.
     */
    public Item getItem(int index)
    {
        return items.get(index);
    }

    /**
     * remove the item that you indicate.
     */
    public void removeItem(int index)
    {
        items.remove(index);
    }

    /**
     * @return The first item´s description of the room.
     */
    public String getItemDescription(int index)
    {
        return items.get(index).getDescription();
    }

    /**
     * @return The first item´s weigth of the room.
     */
    public double getItemWeight(int index)
    {
        return items.get(index).getWeight();
    }

    /**
     * The method adds a item inside the collection of items.
     */
    public void addItem(Item item)
    {
        items.add(item);
    }

    /**
     * Define an exit from this room.
     * @param neighbor The room in the given direction.
     * @param direction The direction of the exit,its values can be:
     * northExit, southExit, eastExit, westExit, southEastExit, northWestExit;
     */
    public void setExit(String direction, Room neighbor){
        exits.put(direction, neighbor);
    }

    /**
     * This method returns the exit that the room has in the direction given
     * @param direction The direction of the exit that you are looking for
     * @return The exit of the room in the direction given
     */
    public Room getExit(String direction){
        return exits.get(direction);
    }

    /**
     * Return a description of the room's exits.
     * For example: "Exits: north east west"
     *
     * @ return A description of the available exits.
     */
    private String getExitString(){
        String getExitString = "Exits: ";
        Set<String> keys = exits.keySet();
        for(String key : keys){
            if(exits.get(key) != null){
                getExitString += key + " ";
            }
        }
        return getExitString;
    }

    /**
     * Return a long description of this room, of the form:
     *     You are in the 'name of room'
     *     Exits: north west southwest
     * @return A description of the room, including exits.
     */
    public String getLongDescription()
    {
        String longDescription = getDescription() + "\n" + getExitString()+ "\n";
        for(int i=0; i < items.size(); i++){
            longDescription += "This room has the item called " + getItemDescription(i)
            + " and its weight is "+ getItemWeight(i) + " Kgs\n";
        }
        return longDescription;
    }
    
    /**
     * @return the boolean canTeletransport, true is the room can and false if cant
     */
    public boolean getCanTeletransport()
    {
        return canTeletransport;
    }
}