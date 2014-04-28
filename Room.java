import java.util.HashMap;
import java.util.Set;
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
 * @author  Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */
public class Room 
{
    private String description;
    private HashMap<String,Room> exits;

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<>();
        //         exits.put("north", null);
        //         exits.put("south", null);
        //         exits.put("east", null);
        //         exits.put("west", null);
        //         exits.put("southEast", null);
        //         exits.put("northWest", null);
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
     * @return The description of the room.
     */
    public String getDescription()
    {
        return description;
    }

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
        //         if(exits.get("north") != null){
        //             getExitString += "north ";
        //         }
        //         if(exits.get("east") != null) {
        //             getExitString += "east ";
        //         }
        //         if(exits.get("south") != null) {
        //             getExitString += "south ";
        //         }
        //         if(exits.get("west") != null) {
        //             getExitString += "west ";
        //         }
        //         if(exits.get("southEast") != null) {
        //             getExitString += "southEast ";
        //         }
        //         if(exits.get("northWest") != null) {
        //             getExitString += "northWest ";
        //         }
        return getExitString;
    }

    /**
     * Return a long description of this room, of the form:
     *     You are in the 'name of room'
     *     Exits: north west southwest
     * @return A description of the room, including exits.
     */
    public String getLongDescription(){
        return getDescription() + "\n" + getExitString();
    }
}
