
/**
 * Pizza simulator
 * 
 * exception to be thrown when the pizza is unavailable or eaten 
 * 
 * @author Ethan Silvas 
 */
public class PizzaException extends Exception{ 
    /**
     * no-arg constructor with premade message
     */
    public PizzaException() {
        super("That pizza has been eaten.");
    }
    
    /**
     * constructor that takes string as argument
     */
    public PizzaException(String message) {
        super(message);
    }
}
