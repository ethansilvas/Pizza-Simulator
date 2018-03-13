
/**
 * Pizza simulator
 * 
 * subclass of meat that makes sausage 
 * cost: $.35
 * cal: 80
 * 
 * @author Ethan Silvas 
 */
public class Sausage extends Meat
{
    public Sausage() {
        super("Sausage", new Money(0, 35), 80);
    }
}
