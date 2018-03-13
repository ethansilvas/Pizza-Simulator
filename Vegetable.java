
import java.awt.*;
/**
 * Pizza simulator
 * 
 * subclass of ingredient that sets a vegetable 
 * pepper or olive
 * also uses color
 * 
 * @Author Ethan Silvas
 */
public class Vegetable extends Ingredient {
    Color color;           //holds the color of the ingredient
        
    /**
     * sets up a default vegetable 
     */
    public Vegetable(String d, Money co, int cal) {
        super(d, co, cal);
    }
        
    /**
     * sets up a vegetable with a color 
     */
    public Vegetable(String d, Money co, int cal, Color col) {
        super(d, co, cal);
        this.color = col;
    }
        
    /**
     * return the color 
     */
    public Color getColor() {
        return this.color;
    }
        
    /**
     * set the color
     */
    public void setColor(Color col) {
        this.color = col;
    }
        
    /**
     * returns the string of the vegetable 
     * color will be added in the subclasses 
     */
    @Override
    public String toString() {
        return super.toString();
    }
        
    /**
     * compares vegetables by using super and comparing color
     * does not need to override because it takes in a vegetable not ingredient 
     */
    public boolean equals(Vegetable that) {
        //first compare all other data members 
        if (super.equals(that)) {
            //now compare colors 
            if (this.color.equals(that.getColor())) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
