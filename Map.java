import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Write a description of class Mapa here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Map
{
    private ArrayList<Room> rooms;
    
    /**
     * Create the map and initialise it.
     */
    public Map() 
    {
        rooms = new ArrayList<>();
    }
    
    
    /**
     * Create all the rooms and link their exits together.
     */
    public void createRooms()
    {
        ArrayList<Boolean> canTransport = new ArrayList<>();
        canTransport.add(true);
        for(int i=1; i<7;i++){
            canTransport.add(false);
        }
        Collections.shuffle(canTransport);
        // create the rooms and add an object inside it
        //humedo index 0
        rooms.add(new Room("in the middle of the barrio Húmedo",canTransport.get(0)));
        rooms.get(0).addItem(new Item("ronBrugal", 1.0, true));
        rooms.get(0).addItem(new Item("50euros", 0.3, true));
        //galocha index 1
        rooms.add(new Room("in the pub called galocha",canTransport.get(1)));
        rooms.get(1).addItem(new Item("navaja", 0.2, true));
        //flechazo index 2
        rooms.add(new Room("in the pub called flechazo",canTransport.get(2)));
        rooms.get(2).addItem(new Item("paraguas", 0.8, true));
        //rebote index 3
        rooms.add(new Room("in the pub called rebote",canTransport.get(3)));        
        rooms.get(3).addItem(new Item("bufanda", 0.3, true));
        //hurley index 4
        rooms.add(new Room("in the pub called hurley",canTransport.get(4)));
        rooms.get(4).addItem(new Item("motocicleta", 250, false));
        //mishara index 5
        rooms.add(new Room("in the pub called mishara",canTransport.get(5)));
        rooms.get(5).addItem(new Item("galaxyS5", 0.2, true));
        //colonial index 6
        rooms.add(new Room("in the pub called colonial",canTransport.get(6)));
        rooms.get(6).addItem(new Item("cazadoraCuero", 0.9, true));

        // initialise room exits
        //room humedo
        rooms.get(0).setExit("east", rooms.get(2));
        rooms.get(0).setExit("south", rooms.get(4));
        rooms.get(0).setExit("west", rooms.get(3));
        rooms.get(0).setExit("northWest", rooms.get(1));
        //room galocha
        rooms.get(1).setExit("southEast", rooms.get(0));
        //room flechazo
        rooms.get(2).setExit("west", rooms.get(0));
        //room rebote
        rooms.get(3).setExit("east", rooms.get(0));
        //room hurley
        rooms.get(4).setExit("north", rooms.get(0));
        rooms.get(4).setExit("east", rooms.get(5));
        //room mishara
        rooms.get(5).setExit("west", rooms.get(4));
        rooms.get(5).setExit("southEast", rooms.get(6));
        //room colonial
        rooms.get(6).setExit("northWest", rooms.get(5));
    }
    
    /**
     * @return the Room called humedo
     */
    public Room getRoomHumedo()
    {
        return rooms.get(0);
    }
    
    /**
     * @return a random room
     */
    public Room getRandomRoom()
    {
        Random rand = new Random();
        return rooms.get(rand.nextInt(rooms.size()));
    }
}
