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
    private final double MAX_WEIGHT;

    /**
     * Constructor for objects of class Player
     */
    public Player(double maxWeight)
    {
        playerItems = new ArrayList<>();
        previousRooms = new Stack<>();
        MAX_WEIGHT = maxWeight;
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

    /**
     * remove the item that you indicate.
     */
    public void removeItem(int index)
    {
        playerItems.remove(index);
    }

    /**
     * @return The size of playerItems.
     */
    public int getItemsSize()
    {
        return playerItems.size();
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

    /**
     * Show if the player hasnt items or the item/s that he has
     */
    public void items()
    {
        if(playerItems.size() == 0){
            System.out.println("You haven´t any item");
        }else if(playerItems.size() == 1){
            System.out.println("You have only one item called " + playerItems.get(0).getDescription());
        }
        else{
            System.out.println("You have the next list of items:");
            for(Item item : playerItems){
                System.out.print(item.getDescription()+ " ");
            }
        }
        System.out.println();
    }

    /**
     * Take a item in the current room
     */
    public void take(Command command)
    {
        if(currentRoom.getItemsSize() == 0){
            System.out.println("There arent any items in this room");
        }else{
            if(command.hasSecondWord()) {
                for(int i=0; i <= currentRoom.getItemsSize()-1; i++){
                    if(currentRoom.getItemDescription(i).equals(command.getSecondWord())){
                        if(currentRoom.getItem(i).getMovable()){
                            if(weight(currentRoom.getItem(i))){
                                playerItems.add(currentRoom.getItem(i));
                                currentRoom.removeItem(i);
                            }else{
                                System.out.println("Too weight, You can´t take it");
                            }
                        }else{
                            System.out.println("This item can´t be movable. Try with other!");
                        }
                    }
                }
            }
            else {
                System.out.println("You need say what you want to take, the item´s name!");
            }
        }
    }

    /**
     * comprobate if the weight with taking a new item is valid or not
     * @return true if it is valid or false if not
     */
    private boolean weight(Item item)
    {
        double totalWeight = 0;
        boolean canTake = false;
        for(Item theItem : playerItems){
            totalWeight += theItem.getWeight();
        }

        if((totalWeight+item.getWeight()) <= MAX_WEIGHT){
            canTake = true;
        }
        return canTake;
    }

    public void drop(Command command)
    {
        if(getItemsSize() == 0){
            System.out.println("You haven´t items to drop");
        }else{
            if(command.hasSecondWord()) {
                for(int i=0; i < getItemsSize(); i++){
                    if(playerItems.get(i).getDescription().equals(command.getSecondWord())){
                        currentRoom.addItem(playerItems.get(i));
                        playerItems.remove(i);
                    }else{
                        System.out.println("This item doesn´t exist");
                    }
                }
            }
            else {
                System.out.println("You need say what you want to drop, the item´s name!");
            }
        }
    }
}
