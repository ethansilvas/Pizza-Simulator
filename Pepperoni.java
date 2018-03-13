
/**
 * Pizza simulator
 * 
 * subclass of meat that creates pepperonis 
 * cost: $.50
 * cal: 50 
 * 
 * @author Ethan Silvas
 */
public class Pepperoni extends Meat
{
    public Pepperoni() {
        super("Pepperoni", new Money(0, 50), 50);
    }
}
