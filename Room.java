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
    //     private Room northExit;
    //     private Room southExit;
    //     private Room eastExit;
    //     private Room westExit;
    //     private Room southEastExit;
    //     private Room northWestExit;

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
     * Define the exits of this room.  Every direction either leads
     * to another room or is null (no exit there).
     * @param north The north exit.
     * @param east The east east.
     * @param south The south exit.
     * @param west The west exit.
     */
    public void setExits(Room north, Room east, Room south, Room west, Room southEast, Room northWest) 
    {
        if(north != null)
            exits.put("northExit",north);
        if(east != null)
            exits.put("eastExit",east);
        if(south != null)
            exits.put("southExit",south);
        if(west != null)
            exits.put("westExit",west);
        if(southEast != null)
            exits.put("southEastExit",southEast);
        if(northWest != null)
            exits.put("northWestExit",northWest);
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
