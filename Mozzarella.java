
/**
 * Pizza simulator
 * 
 * subclass of cheese that makes a mozzarella object using a call to super 
 * cost: $.30
 * cal: 78
 * 
 * @author Ethan Silvas
 */
public class Mozzarella extends Cheese
{
    /**
     * creates a mozarella object using preset data members
     */
    public Mozzarella() {
        super("Mozzarella cheese", new Money(0, 30), 78);
    }
}
