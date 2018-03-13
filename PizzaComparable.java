 
/**
 * CSS 143, Pizza Manager Project
 * 
 * This interface can do everything the Comparable interface can and more
 * 
 * Author: Rob Nash
 * 
 * used by Ethan Silvas
 */
public interface PizzaComparable extends Comparable {  //Example of interface inheritance
	@Override
	public int compareTo(Object o); 	 		//a.k.a compareToByPrice
	//non-overrides
	public int compareToBySize(Object o); 		//a.k.a. compareToByAreaLeft
	public int compareToByCalories(Object o);	
}
