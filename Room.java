import java.util.HashMap;
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
        exits.put("northExit", null);
        exits.put("southExit", null);
        exits.put("eastExit", null);
        exits.put("westExit", null);
        exits.put("southEastExit", null);
        exits.put("northWestExit", null);
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
        Room exitRoom = null;
        if(direction.equals("north")){
            exitRoom = exits.get("northExit");
        }
        if(direction.equals("south")){
            exitRoom = exits.get("southExit");
        }
        if(direction.equals("east")){
            exitRoom = exits.get("eastExit");
        }
        if(direction.equals("west")){
            exitRoom = exits.get("westExit");
        }
        if(direction.equals("southEast")){
            exitRoom = exits.get("southEastExit");
        }
        if(direction.equals("northWest")){
            exitRoom = exits.get("northWestExit");
        }
        return exitRoom;
    }

    /**
     * Return a description of the room's exits.
     * For example: "Exits: north east west"
     *
     * @ return A description of the available exits.
     */
    public String getExitString(){
        String getExitString = "";
        if(exits.get("northExit") != null){
            getExitString += "north ";
        }
        if(exits.get("eastExit") != null) {
            getExitString += "east ";
        }
        if(exits.get("southExit") != null) {
            getExitString += "south ";
        }
        if(exits.get("westExit") != null) {
            getExitString += "west ";
        }
        if(exits.get("southEastExit") != null) {
            getExitString += "southEast ";
        }
        if(exits.get("northWestExit") != null) {
            getExitString += "northWest ";
        }
        return getExitString;
    }
}
