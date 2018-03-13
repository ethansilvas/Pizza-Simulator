
/**
 * Pizza simulator
 * 
 * subclass of Base that makes a marinara object 
 * cost: $.50
 * cal: 65
 * 
 * @Author Ethan Silvas
 */
public class Marinara extends Base {
    /**
     * creates a marinara object using a call to super and its data members
     */
    public Marinara() {
        super("Marinara sauce", new Money(0, 50), 65);
    }
}
