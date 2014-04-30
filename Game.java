/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael KÃ¶lling and David J. Barnes
 * @version 2011.07.31
 */

public class Game 
{
    private Parser parser;
    private Room currentRoom;

    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        Room humedo, flechazo, rebote, hurley, mishara, colonial, galocha;

        // create the rooms
        humedo = new Room("in the middle of the barrio Húmedo");
        galocha = new Room("in the pub called galocha");
        flechazo = new Room("in the pub called flechazo");
        rebote = new Room("in the pub called rebote");        
        hurley = new Room("in the pub called hurley");
        mishara = new Room("in the pub called mishara");
        colonial = new Room("in the pub called colonial");

        // initialise room exits
        //room humedo
        humedo.setExit("east", flechazo);
        humedo.setExit("south", hurley);
        humedo.setExit("west", rebote);
        humedo.setExit("northWest", galocha);
        //room galocha
        galocha.setExit("southEast", humedo);
        //room flechazo
        flechazo.setExit("west", humedo);
        //room rebote
        rebote.setExit("east", humedo);
        //room hurley
        hurley.setExit("north", humedo);
        hurley.setExit("east", mishara);
        //room mishara
        mishara.setExit("west", hurley);
        mishara.setExit("southEast", colonial);
        //room colonial
        colonial.setExit("northWest", mishara);

        currentRoom = humedo;  // start game outside
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.

        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing. Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Barrio Humedo!");
        System.out.println("World of Barrio Humedo is a new, incredibly drunk adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        printLocationInfo();
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        if(command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("help")) {
            printHelp();
        }
        else if (commandWord.equals("go")) {
            goRoom(command);
        }
        else if (commandWord.equals("look")) {
            look(command);
        }
        else if (commandWord.equals("quit")) {
            wantToQuit = quit(command);
        }
        else if (commandWord.equals("eat")) {
            eat(command);
        }

        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the humedo and public relations"+
            "\nare trying you drink more \"garrafón\""+
            "\nYou must find ur friends! ¡¡FAST!!");
        System.out.println();
        parser.printCommands();
        System.out.println();
    }

    /** 
     * Try to go in one direction. If there is an exit, enter
     * the new room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        //         String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(command.getSecondWord());
        //         Room nextRoom = null;
        //         if(direction.equals("north")) {
        //             nextRoom = currentRoom.northExit;
        //         }
        //         if(direction.equals("east")) {
        //             nextRoom = currentRoom.eastExit;
        //         }
        //         if(direction.equals("south")) {
        //             nextRoom = currentRoom.southExit;
        //         }
        //         if(direction.equals("west")) {
        //             nextRoom = currentRoom.westExit;
        //         }
        //         if(direction.equals("southEast")) {
        //             nextRoom = currentRoom.southEastExit;
        //         }

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            currentRoom = nextRoom;
            printLocationInfo();
        }
    }

    /**
     * look command
     */
    private void look(Command command){
        if(command.hasSecondWord()) {
            System.out.println("Look what? this command don´t need a second word");
        }
        else {
            System.out.println("You are " + currentRoom.getLongDescription());
            //printLocationInfo();    preguntar si es peor solucion llamar a este metodo o da igual 
        }
    }

    private void eat(Command command)
    {
        if(command.hasSecondWord()) {
            System.out.println("Eat what? this command don´t need a second word");
        }
        else {
            System.out.println("You have eaten now and you are not hungry any more");
        }
    }
    
    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }

    private void printLocationInfo()
    {
        System.out.print("You are " + currentRoom.getLongDescription());
        System.out.println();
    }
}
