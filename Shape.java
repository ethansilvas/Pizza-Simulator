
import java.awt.*;
/** 
 *
 * By Rob Nash
 * 
 * This is the superclass in a hierarchy of shapes that you have to construct
 * 
 * used by Ethan Silvas for pizza project
 */
class Shape extends Object implements Cloneable {
	private int x = 0;
	private int y = 0;
	
	/**
	 * defines an x and y of a shape
	 */
	public Shape(int a, int b) {
		x=a;
		y=b;
	}
	
	/**
	 * used to be overriden and find the area of a certain shape
	 */
	public double getArea(){ return -1; }
	
	/**
	 * another overrideable method for actually drawing the shape using Graphics class
	 */
	public void draw( Graphics g ){}
	
	/**
	 * return the x value of the shape
	 */
	public int getX() { return x; }
	
	/**
	 * return the y value of the shape
	 */
	public int getY() { return y; }
	
	/**
	 * override clone to make a new shape
	 */
	public Shape clone() {
	    return new Shape(this.x, this.y);
	}
}