
import java.awt.*;
/**
 * Pizza simulator
 * 
 * Creates an object of type Pizza, holds all the information of a pizza including 
 * area, cost, calorie count, etc.  
 * 
 * @author Ethan Silvas 
 */
public class Pizza implements PizzaComparable {
    //data members
    private Fraction fractionRemaining;                //holds the area of the pizza
    private Money price;                               //price of the pizza
    private int calorieCount;                          //number of calories
    private ArrayList ingredients = new ArrayList();   //holds all of the ingredients
    private Shape shape;                               //shape of the pizza
    
    /**
     * no arg constructor that sets fraction to full
     * price and calories to 0
     */
    public Pizza() {
        fractionRemaining = new Fraction(1, 1); 
        price = new Money(0, 0); 
        calorieCount = 0;
        
        //use random ints to add ingredients and make shape
        int base = getRandInt();
        if (base == 1) {
            this.addIngredient(new Marinara());
        } else {
            this.addIngredient(new Alfredo());
        }
        
        int cheese = getRandInt();
        if (cheese == 1) {
            this.addIngredient(new Mozzarella());
        } else {
            this.addIngredient(new Goat());
        }
        
        int vegetable = getRandInt();
        int color = getRandInt();        //do two rolls to have one for color
        if (vegetable == 1) {
            //now check for color
            if (color == 1) {
                this.addIngredient(new Pepper(Color.YELLOW));
            } else {
                this.addIngredient(new Pepper(Color.RED));
            }
        } else {
            //check color 
            if (color == 1) {
                this.addIngredient(new Olive(Color.GREEN));
            } else {
                this.addIngredient(new Olive(Color.BLACK));
            }
        }
        
        int meat = getRandInt();
        if (meat == 1) {
            this.addIngredient(new Pepperoni());
        } else {
            this.addIngredient(new Sausage());
        }
        
        int s = getRandInt();
        if (s == 1) {
            //circle pizzas have radius 8
            this.shape = new Circle(5, 10, 8);
        } else {
            //square pizzas have side lengths of 5
            this.shape = new Square(4, 8, 5);
        }
    }
    
    /**
     * return the fractionRemaining
     */
    public Fraction getRemaining() {
        return this.fractionRemaining;
    }
    
    /**
     * change the fractionRemaining 
     */
    public void setRemaining(Fraction f) {
        this.fractionRemaining = new Fraction(f.getNumerator(), f.getDenominator());
    }
    
    /**
     * return the calories
     */
    public int getCalories() {
        return this.calorieCount;
    }
    
    /**
     * return the cost 
     */
    public Money getCost() {
        return this.price;
    }
    
    /**
     * return the area using the square and circle area methods
     * area is multiplied by the remaining fraction
     */
    public double getRemainingArea() {
        //convert numerators and denominators to doubles
        return shape.getArea() * ((double) this.fractionRemaining.getNumerator() / (double) this.fractionRemaining.getDenominator());
    }
    
    /**
     * change the shape
     */
    public void setShape(Shape s) {shape = (Shape) s.clone();}
    
    /**
     * return the shape 
     */
    public Shape getShape() { return (Shape) shape.clone();}
    
    /**
     * add an ingredient to the list of ingredients
     */
    public void addIngredient(Ingredient a) {
        //check if the list is empty
        if (this.ingredients == null) {
            //add to the start of the arraylist
            ingredients.insert(a, 0);
        } else {
            //add to the end of the arraylist
            ingredients.insert(a, this.ingredients.size() - 1);
        }
        
        //add to the cost
        this.price.add(a.getCost());
        
        //add to calories
        this.calorieCount += a.getCalories();
    }
    
    /**
     * subtract from the current fraction of pizza
     */
    public void eatSomePizza(Fraction amt) {
        //store the fractionRemaining to test for >= 0
        Fraction temp = this.fractionRemaining.clone();
        
        try {
            //subtract from the temp
            temp.subtract(amt);
            
            //check if the amount left is >= 0 
            if (temp.getNumerator() == 0) {
                //if the amount is exactly zero, then subtract from the actual fraction 
                //then print out that the pizza is eaten 
                this.fractionRemaining = this.fractionRemaining.subtract(amt);
                throw new PizzaException();
            } else if (temp.getNumerator() < 0) {
                //dont subtract and return error message 
                throw new IllegalArgumentException();
            } else {
                //if there will be some left over, just subtract
                this.fractionRemaining = this.fractionRemaining.subtract(amt);
            }
        } catch (PizzaException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("That fraction is more than what is left of that pizza.");
        }
    }
    
    /**
     * convert the pizza to a string
     */
    public String toString() {
        String s = "";     //holds shape string
        
        //check if circle or square
        if (this.shape instanceof Circle) {
            s = "circle";
        } else {
            s = "square";
        }
        
        return "Pizza costs " + this.getCost().toString() + " and has " + this.getCalories() + " calories." + 
            " Fraction remaining: " + this.getRemaining() + "; Area left: " + this.getRemainingArea() + "; Shape: " + s;
    }
    
    /**
     * compares two pizzas by price
     */
    @Override 
    public int compareTo(Object other) {
        //first make sure the object is a pizza
        if (other == null || !(other instanceof Pizza)) {
            //throw an illegal argument exception if the argument isnt a pizza
            throw new IllegalArgumentException();
        }
        
        //now type cast to manipulate
        Pizza that = (Pizza) other;
        
        try {
            //use the compareTo method in money to compare pizzas 
            if (this.price.compareTo(that.price) == 1) {
                return 1;
            } else if (this.price.compareTo(that.price) == 0) {
                return 0;
            } else {
                return -1;
            }
        } catch (IllegalArgumentException e) {
            //catch the thrown exception and print that it was an invalid argument
            System.out.println("Argument is not a pizza.");
        }
        
        //it shouldnt get here, but return -2 so that we will know if something has gone wrong
        return -2;
    } 
    
    /**
     * compares two pizzas by area left
     */
    @Override 
    public int compareToBySize(Object other) {
        //first make sure the object is a pizza
        if (other == null || !(other instanceof Pizza)) {
            //throw an illegal argument exception if the argument isnt a pizza
            throw new IllegalArgumentException();
        }
        
        //now type cast to manipulate
        Pizza that = (Pizza) other;
        
        try {
            //use the compareTo method in money to compare pizzas 
            if (this.getRemainingArea() > that.getRemainingArea()) {
                return 1;
            } else if (this.getRemainingArea() == that.getRemainingArea()) {
                return 0;
            } else {
                return -1;
            }
        } catch (IllegalArgumentException e) {
            //catch the thrown exception and print that it was an invalid argument
            System.out.println("Argument is not a pizza.");
        }
        
        //it shouldnt get here, but return -2 so that we will know if something has gone wrong
        return -2;
    } 
    
    /**
     * compares two pizzas by amount of calories
     */
    @Override 
    public int compareToByCalories(Object other) {
        //first make sure the object is a pizza
        if (other == null || !(other instanceof Pizza)) {
            //throw an illegal argument exception if the argument isnt a pizza
            throw new IllegalArgumentException();
        }
        
        //now type cast to manipulate
        Pizza that = (Pizza) other;
        
        try {
            //use the compareTo method in money to compare pizzas 
            if (this.getCalories() > that.getCalories()) {
                return 1;
            } else if (this.getCalories() == that.getCalories()) {
                return 0;
            } else {
                return -1;
            }
        } catch (IllegalArgumentException e) {
            //catch the thrown exception and print that it was an invalid argument
            System.out.println("Argument is not a pizza.");
        }
        
        //it shouldnt get here, but return -2 so that we will know if something has gone wrong
        return -2;
    } 
    
    /**
     * helper method to make random pizzas
     */
    public int getRandInt() {
        return (int) (Math.random() * 2) + 1;
    }
}
