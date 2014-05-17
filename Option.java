
/**
 * Enumeration class Option - write a description of the enum class here
 * 
 * @author Sergio Diez
 */
public enum Option
{
    GO("ir"), QUIT("cerrar"), HELP("ayuda"), LOOK("mirar"), EAT("comer"), BACK("atras"), ITEMS("objetos"),
    TAKE("coger"), DROP("dejar"), UNKNOWN("desconocido");
    
    //atribute
    private String command;
    
    /*
     * Constructor of the Option objects
     * @param command - The command that is associated
     */
    Option(String command){
        this.command = command;
    }
    
    /*
     * @return the Command associated to the Option object
     */
    public String getCommand(){
        return command;
    }
}
