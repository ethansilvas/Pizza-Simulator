
/**
 * Pizza simulator
 * 
 * Parent class for a heiarchy of ingredients for the pizza
 * 
 * @author Ethan Silvas 
 */
public class Ingredient implements Comparable
{
    //data members
    String description;           //name or description of the ingredient
    Money cost;                   //cost of the ingredient
    int calories;                //number of calories
    
    /**
     * constructor that takes in the 3 data members
     */
    public Ingredient(String d, Money co, int cal) {
        this.description = d;
        this.cost = co.clone();      //use the clone method to avoid privacy leaks
        this.calories = cal;
    }
    
    /**
     * return the description 
     */
    public String getDescription() {
        return this.description;
    }
    
    /**
     * return the cost 
     */
    public Money getCost() {
        return this.cost.clone();
    }
    
    /**
     * return the calories
     */
    public int getCalories() {
        return this.calories;
    }
    
    /**
     * set the description 
     */
    public void setDescription(String d) {
        this.description = d;
    }
    
    /**
     * set the cost
     */
    public void setCost(Money co) {
        this.cost = co.clone();
    }
    
    /**
     * set the calories
     */
    public void setCalories(int cal) {
        this.calories = cal;
    }
    
    /**
     * returns the ingredient into a string
     */
    public String toString() {
        //add all of the data members to a string
        return this.description + " costs " + this.cost.toString() + " and is " + this.calories + " calories.";
    }
    
    /**
     * checks if two ingredients are equal
     */
    public boolean equals(Ingredient that) {
        //compare all of the data members
        if (this.description.equals(that.getDescription()) && this.cost.equals(that.getCost()) && this.calories == that.getCalories()) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * compare two ingredients by price
     */
    @Override
    public int compareTo(Object other) {
        //first make sure the object is an ingreident 
        if (other == null || !(other instanceof Ingredient)) {
            //throw an illegal argument exception if the argument isnt a Money object
            throw new IllegalArgumentException();
        }
        
        //now type cast to manipulate
        Ingredient that = (Ingredient) other;
        
        try {
            //compare the costs using the compareTo method in Money class
            if (this.cost.compareTo(that.cost) == 1) {
                return 1;
            } else if (this.cost.compareTo(that.cost) == 0) {
                return 0;
            } else {
                return 1;
            }
        } catch (IllegalArgumentException e) {
            //catch the thrown exception and print that it was an invalid argument
            System.out.println("Argument is not an Ingredient.");
        }
        
        //it shouldnt get here, but return -2 so that we will know if something has gone wrong
        return -2;
    }
}
