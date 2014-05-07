import java.util.ArrayList;
import java.util.Stack;

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player
{
    private ArrayList<Item> playerItems;
    private Room currentRoom;
    private Stack<Room> previousRooms;

    /**
     * Constructor for objects of class Player
     */
    public Player()
    {
        playerItems = new ArrayList<>();
        previousRooms = new Stack<>();
    }
    
    public void setCurrentRoom(Room room)
    {
        currentRoom = room;
    }

    /**
     * This method add an item inside ArrayList
     */
    public void addItem(Item item)
    {
        playerItems.add(item);
    }
    
    // implementations of player commands:    
    
    /** 
     * Try to go in one direction. If there is an exit, enter
     * the new room, otherwise print an error message.
     */
    public void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(command.getSecondWord());

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            //save the previous command
            previousRooms.push(currentRoom);
            //change current room for next room
            currentRoom = nextRoom;
            printLocationInfo();
        }
    }

    /**
     * This method looks your location
     * @param command The comand that you introduce
     */
    public void look(Command command){
        if(command.hasSecondWord()) {
            System.out.println("Look what? this command don´t need a second word");
        }
        else {
            printLocationInfo();
        }
    }

    /**
     * Inform you after eating that you aren´t hungry
     */
    public void eat(Command command)
    {
        if(command.hasSecondWord()) {
            System.out.println("Eat what? this command don´t need a second word");
        }
        else {
            System.out.println("You have eaten now and you are not hungry any more");
        }
    }

    /**
     * Permit you to back to the previous room visited
     */
    public void back(){
        if(previousRooms.empty()){
            System.out.println("You don´t move, so not exists a previous room");
        }else{
            currentRoom = previousRooms.pop();
            printLocationInfo();
        }
    }
    
    /**
     * Show you the description of your current room and the item that is on it
     */
    public void printLocationInfo()
    {
        System.out.println("You are " + currentRoom.getLongDescription());
    }
}
