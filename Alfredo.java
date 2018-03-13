
/**
 * Pizza simulator
 * 
 * subclass of Base that makes an alfredo object 
 * cost: $.20
 * cal: 39
 * 
 * @Author Ethan Silvas
 */
public class Alfredo extends Base {
    /**
     * creates an alfredo object out of its own data members
     */
    public Alfredo() {
        super("Alfredo sauce", new Money(0, 65), 85);
    }
}
