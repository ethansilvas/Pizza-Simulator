
/**
 * Pizza simulator
 * 
 * subclass of cheese that makes goat cheese 
 * cost: $.40
 * cal: 78
 * 
 * @author Ethan Silvas
 */
public class Goat extends Cheese
{
    /**
     * creates an object of goat using a call to super and data members
     */
    public Goat() {
        super("Goat cheese", new Money(0, 40), 83); 
    }
}
