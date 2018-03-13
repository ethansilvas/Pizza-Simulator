
import java.awt.*;
/**
 * Pizza simulator
 * 
 * subclass of vegetable that makes peppers of different color
 * cost: $.30
 * cal: 24
 * yellow or red
 * 
 * @author Ethan Silvas 
 */
public class Pepper extends Vegetable
{
    /**
     * makes a pepper according to what color is passed in 
     */
    public Pepper(Color c) {
        //make a call to super that sets up a basic pepper
        super("Pepper", new Money(0, 30), 24);
        
        //change the pepper according to what color was passed in 
        //if the color isnt yellow or red, just leave it as a regular pepper
        if (c.equals(Color.YELLOW)) {
            super.setColor(Color.YELLOW);
            super.setDescription("Yellow pepper");
        } else if (c.equals(Color.RED)) {
            super.setColor(Color.RED);
            super.setDescription("Red pepper");
        } 
    }
}
