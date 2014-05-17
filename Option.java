
/**
 * Enumeration class Option - write a description of the enum class here
 * 
 * @author Sergio Diez
 */
public enum Option
{
    GO("ir"), QUIT("cerrar"), HELP("ayuda"), LOOK("mirar"), EAT("comer"), BACK("atras"), ITEMS("objetos"),
    TAKE("coger"), DROP("dejar"), UNKNOWN("desconocido");
    
    private String command;
    
    Option(String command){
        this.command = command;
    }
    
    public String getCommand(){
        return command;
    }
}
