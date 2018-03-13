
import java.awt.*;
import java.text.*;
/**
 * Lab 5 Circle
 * 
 * used for pizza simulator
 * 
 * @author Ethan Silvas
 */
public class Circle extends Shape
{
    //data members
    private double radius;
    private int widthAndLength;
    
    //constructors
    /**
     * base constructor using super
     */
    public Circle(int x, int y) {
        super(x, y);
    }
    
    /**
     * take in a radius
     */ 
    public Circle(int x, int y, double rad) {
        super(x, y);
        this.radius = rad;
    }
    
    /**
     * take in all
     */
    public Circle(int x, int y, double rad, int wal) {
        super(x, y);
        this.radius = rad;
        this.widthAndLength = wal;
    }
    
    //accessors
    /**
     * return radius
     */
    public double getRadius() {
        return this.radius;
    }
    
    //mutators
    /**
     * return radius
     */
    public void setRadius(double r) {
        this.radius = r;
    }
    
    /**
     * override getArea
     */
    public double getArea() {
        //area of a circle using Math class
        return Math.round((double) Math.pow(this.radius, 2) * Math.PI);
    }
    
    /**
     * override draw
     */
    public void draw(Graphics g) {
        //draw an oval with the same width and length
        g.drawOval(this.getX(), this.getY(), this.widthAndLength, this.widthAndLength);
    }
}
