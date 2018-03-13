
import java.awt.*;
/**
 * Pizza simulator
 * 
 * subclass of vegetable that makes olives based on color 
 * cost: $.45
 * cal: 20
 * green or black
 * 
 * @author Ethan Silvas 
 */
public class Olive extends Vegetable
{
    /**
     * makes a olive according to what color is passed in 
     */
    public Olive(Color c) {
        //make a call to super that sets up a basic olive
        super("Olive", new Money(0, 45), 20);
        
        //change the olive according to what color was passed in 
        //if the color isnt green or black, just leave it as a regular olive
        if (c.equals(Color.GREEN)) {
            super.setColor(Color.GREEN);
            super.setDescription("Green olive");
        } else if (c.equals(Color.BLACK)) {
            super.setColor(Color.BLACK);
            super.setDescription("Black olive");
        } 
    }
}
