
/**
 * Write a description of class Item here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Item
{
    // instance variables - replace the example below with your own
    private String description;
    private double weight;

    /**
     * Constructor for objects of class Item
     * @param description The description of the item
     * @param weight The weight of the item, must be superior to zero if you introduces
     * a negative valour or zero its value will be zero
     */
    public Item(String description, double weight){
        // initialise instance variables
        this.description = description;
        if(weight > 0){
            this.weight = weight;
        }else{
            System.out.println("ERROR! This value is not correct, it must be "
            + "positive and more than zero. Change it using the method setWeight of the item");
        }
    }

    /**
     * This method return the item´s description
     */
    public String getDescription()
    {
        return description;
    }
    
    /**
     * This method return the item´s weight
     */
    public double getWeight()
    {
        return weight;
    }
    
    /**
     * This method set a new value for the item´s weight
     */
    public void setWeight(double weight)
    {
        if(weight > 0){
            this.weight = weight;
        }else{
            System.out.println("ERROR! This value is not correct, it must be "
            + "positive and more than zero.");
        }
    }

}
