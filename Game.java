import java.util.ArrayList;

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
    private Player player;
    private Map map;

    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        player = new Player(1.2);
        map = player.getMap();
        parser = new Parser();
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
        String help = Option.HELP.getCommand();
        System.out.println("Type \'" + help + "\' if you need " + help);
        System.out.println();
        player.printLocationInfo();
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

        Option commandWord = command.getCommandWord();
        switch(commandWord){
            case HELP:      printHelp();
                            break;
            case GO:        player.goRoom(command);
                            break;
            case LOOK:      player.look(command);
                            break;
            case QUIT:      wantToQuit = quit(command);
                            break;
            case EAT:       player.eat(command);
                            break;
            case BACK:      player.back();
                            break;
            case ITEMS:     player.items();
                            break;
            case TAKE:      player.take(command);
                            break;
            case DROP:      player.drop(command);
                            break;
        }
        return wantToQuit;
    }

    // implementations of game commands:

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
}
