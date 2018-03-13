
import java.text.DecimalFormat;
import java.io.*;
/**
 * Pizza simulator
 * 
 * Creates objects that hold a dollar amount of money, including cents. 
 * Represents an amount of money in $0.00 format 
 * 
 * Now implements comparable, cloneable, and serializable interfaces
 * 
 * @author Ethan Silvas
 */
public class Money implements Comparable, Cloneable, Serializable {
    //dollars and cents data members
    private int dollars;
    private int cents;
    
    //constructors
    /**
     * no arg constructor
     */
    public Money() {
        //set dollars and cents to 0
        this.dollars = 0;
        this.cents = 0;
    }
    
    /**
     * take in a dollar amount only, and set cents to 0
     */
    public Money(int dol) {
        this.dollars = dol;
        this.cents = 0;
    }
    
    /**
     * take in both dollars and cents
     */
    public Money(int dol, int cent) {
        this.dollars = dol;
        this.cents = cent;
    }
    
    /**
     * copy one amount of money to this
     */
    public Money(Money other) {
        this.dollars = other.getDollars();
        this.cents = other.getCents();
    }
    
    //accessors
    /**
     * get the current amount of dollars
     */
    public int getDollars() {
        return this.dollars;
    }
    
    /**
     * get the current amount of cents
     */
    public int getCents() {
        return this.cents;
    }
    
    /**
     * mutator that changes the amount of money
     */ 
    public void setMoney(int dol, int cent) {
        this.dollars = dol;
        this.cents = cent;
    }
    
    /**
     * get the amount of money in 0.00 format
     */
    public double getMoney() {
        /*
         * when we are doing our calculations, we need to remember that our instance variables 
         * are ints, so we need to turn them into doubles to manipulate them 
         */
        double amount = (double) this.dollars + ((double)(this.cents) / 100);
        
        /*
         * now that we have our value of money in double format, we need to make sure
         * that there are only two decimal places. 
         * 
         * use Math.round to round out the value, but multiply (and divide) by 100 to go to the 
         * hundreths digit. 
         * 
         */
        double round = (double) Math.round(amount * 100) / 100; ;
        
        return round;
    }
    
    //adding methods
    /**
     * just add a dollar amount with no cents
     */ 
    public void add(int dol) {
        this.dollars += dol;
    }
    
    /**
     * add dollars and cents to the current amounts
     */
    public void add(int dol, int cent) {
        this.dollars += dol;
        this.cents += cent;
    }
    
    /**
     * add two object amounts of money together by adding their dollars and cents
     */
    public void add(Money other) {
        this.dollars += other.dollars;
        this.cents += other.cents;
    }
    
    /**
     * check if two objects of money are equal by comparing there dollars and cents amounts
     */
    public boolean equals(Object other) {
        //first make sure the object is not null or not of the Money class
        if (other == null || !(other instanceof Money)) {
            //return false if the object is invalid
            return false;
        }
        
        //now type cast the object so we can manipulate it 
        Money that = (Money) other;
        
        //check if this == that
        if (this.dollars == that.dollars && this.cents == that.cents) {
            //if the dollars and cents amounts are equal, then the amounts are equal
            return true;
        }
        
        return false;
    }
    
    /**
     * convert the object amount into a string of format $0.00
     */
    @Override
    public String toString() {
        /*
         * our getMoney method puts it into 0.00 format for us
         * so all we need to do here is add the $ to the string
         */
        String amount = "$" + String.format("%.2f", this.getMoney());
        return amount;
    }
    
    /**
     * implement comparable by check if the calling amount is less than the 
     * argument amount
     */
    @Override
    public int compareTo(Object other) {
        //first make sure the object is a money object
        if (other == null || !(other instanceof Money)) {
            //throw an illegal argument exception if the argument isnt a Money object
            throw new IllegalArgumentException();
        }
        
        //now type cast to manipulate
        Money that = (Money) other;
        
        try {
            if (this.getMoney() < that.getMoney()) {
                //if the calling money is less than the argument, return a negative int
                return -1;
            } else if (this.getMoney() > that.getMoney()) {
                //if the calling money is more than the argument, return a positive int
                return 1;
            } else {
                //if they are equal, return 0
                return 0;
            }
        } catch (IllegalArgumentException e) {
            //catch the thrown exception and print that it was an invalid argument
            System.out.println("Argument is not a Money object.");
        }
        
        //it shouldnt get here, but return 0 so that we will know if something has gone wrong
        return -2;
    }
    
    /**
     * override the clone method for an object of Money 
     * uses the copy constructor to provide a clone
     */
    @Override
    public Money clone() {
        return new Money(this);
    }
    
    /**
     * method that is the interface for serializable
     * writes to an output stream the calling Money amount
     */
    public void serializeMoney() {
        try {
            //set up an OOS to write the Money to a file
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("money.txt"));
            
            //hold the string value of Money to manipulate
            String moneyString = this.toString();
            
            //loop through the characters in the string and write them to the file
            for (int i = 0; i < moneyString.length(); i++) {
                //use writeChar because our string format is $0.00
                os.writeChar((int) moneyString.charAt(i));
            }
            
            os.close();
        } catch (IOException e) {
            //pring error message in case that something went wrong 
            System.out.println("Problem with file output.");
            System.exit(0);
        }
    }
}
