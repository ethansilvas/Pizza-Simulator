
import java.awt.*;
/**
 * Pizza simulator 
 * 
 * Square shape class, transfer from Lab 5
 * 
 * @author Ethan Silvas 
 */
public class Square extends Shape
{
    //data members
    private int sideLength;     //all of the sides have the same length
    
    //constructors
    /**
     * make a basic shape 
     */
    public Square(int x, int y) {
        super(x, y);
        this.sideLength = 0;
    }
    
    /**
     * take a side length to calculate area
     * and to use in the draw method
     */
    public Square(int x, int y, int sl) {
        super(x, y);
        this.sideLength = sl;
    }
    
    /**
     * get the sideLength
     */
    public int getSideLength() {
        return this.sideLength;
    }
    
    /**
     * set the sideLength
     */
    public void setSideLength(int sl) {
        this.sideLength = sl;
    }
    
    /**
     * multiply the side length by itself
     */
    public double getArea() {
        return this.sideLength * this.sideLength;
    }
    
    /**
     * make a square by drawing a rectangle, but set both the length and the width 
     * equal by using the side length
     */
    public void draw(Graphics g) {
        //draw a rectangle with the same length and width
        g.setColor(Color.RED);
        g.drawRect(this.getX(), this.getY(), this.sideLength, this.sideLength);
    }
}
