 
import java.util.Scanner;
/**  
 *  PizzaManager Skeleton File
 *  CSS 143, Final Project
 * 
 *  This class is a starting point for your final project and is incomplete.
 *  Start by reading the documentation(comments), and then the code.  Find the 
 *  empty stub methods you are to fill in using a Top-Down approach (see the
 *  assignment for more information on this and Stepwise Refinement)
 * 
 *  Author: Rob Nash with minor edits by Johnny Lin
 *  
 *  Used and edits made by Ethan Silvas for Pizza simulator
 */

public class PizzaManager {
    //data members
    private ArrayList<Pizza> pizzas = new ArrayList<Pizza>();                //holds all of the pizzas 
    
    /** 
     * The console interface is defined in the start method 
     * You can exit or extend the code below to accomplish all of 
     * the outcomes defined in the homework document
     */
    public void start() {
        char selection='q';
        
        Scanner foo = new Scanner(System.in);
        
        while(true) {
            displayAllPizzas();
            displayInstructions();
            
            //take the first character of the line
            selection = foo.next().charAt(0);
            
            switch(selection) {
                case 'A':    
                case 'a':    System.out.println("Adding a random pizza to the ArrayList<Pizza>.");
                                this.addRandomPizza();
                                break;
                case 'H':    
                case 'h':    System.out.println("Adding one hundred random pizzas to the ArrayList<Pizza>.");
                                //loop 100 times and call addRandomPizza each time
                                for (int i = 0; i <= 100; i++) {
                                    this.addRandomPizza();
                                }
                                break;                    
                case 'E':    
                case 'e':    System.out.println("Eating a fraction of a pizza.");
                                this.eatSomePizza(foo);
                                break;            
                case 'P':    
                case 'p':     System.out.println("Sorting pizzas by (P)rice");
                                this.sortByPrice();
                                break;    
                case 'S':    
                case 's':     System.out.println("Sorting pizzas by (S)ize");
                                 this.sortBySize();
                                 break;          
                case 'C':    
                case 'c':     System.out.println("Sorting pizzas by (C)alories");
                                 this.sortByCalories();
                                 break;
                case 'B':
                case 'b':    System.out.println("(B)inary search over pizzas by calories(int). Sorting first. Please enter a calorie count to find:");
                                //sort first
                                this.sortByCalories();
                                
                                //take in an int to use for calories
                                int cals = foo.nextInt();
                                System.out.println("Calorie count found at index: " + this.binarySearchByCalories(cals));;
                                break;
                case 'Q':
                case 'q':    System.out.println("(Q)uitting!");
                                //exit the program
                                System.out.println("Thanks for choosing PizzaManager.");
                                System.exit(0);
                                break;
                                
                default:    System.out.println("Unrecognized input - try again");
            }
        }
    }

    /**
     * lists all the pizzas in the arraylist 
     */
    private void displayAllPizzas() {
        //loop through pizzas and print out each pizza
        for (int i = 0; i < this.pizzas.size(); i++) {
            System.out.println(this.pizzas.get(i).toString());
        }
    }
    
    /**
     * subtracts a fractional amount from the pizza
     */
    private void eatSomePizza(Scanner keys) {
        //set up a new scanner to read in user input
        keys = new Scanner(System.in);
            
        //find the index to pick from arraylist
        System.out.println("What index of pizza would you like to eat?");
        int index = 0;
        if (keys.hasNextInt()) {
            index = keys.nextInt();
        } else {
            System.out.println("Integers only please.");
        }
            
        //find the ratio to eat
        System.out.println("What fractional amount would you like to eat?");
            
        //get the numerator 
        System.out.println("Please enter the numerator:");
        int numerator = 0;
        if (keys.hasNextInt()) {
            numerator = keys.nextInt();
        } else {
            System.out.println("Integers only please.");
        }
        
        //get the denominator
        System.out.println("Please enter the denominator:");
        int denominator = 0;
        if (keys.hasNextInt()) {
            denominator = keys.nextInt();
        } else {
            System.out.println("Integers only please.");
        }

        //eat the pizza
        pizzas.get(index).eatSomePizza(new Fraction(numerator, denominator));
    }
    
    /**
     * sorts all of the elements in pizzas by calorie count
     */
    private void sortByCalories() {
        //return if array is null or only one element
        if (pizzas == null || pizzas.size() == 0 || pizzas.size() == 1) {
            return;
        }

        int minIndex;          //store index that has smallest element
        int min;               //holds smallest calorie count

        //loop through pizzas
        for (int i = 0; i < pizzas.size(); i++) {
            //start by making smallests of the current index
            min = pizzas.get(i).getCalories();      
            minIndex = i;

            //loop starting after the currenct index
            for (int j = i + 1; j < pizzas.size(); j++) {
                //compare to see if next calorie counts are smaller
                if (min > pizzas.get(j).getCalories()) {
                    //change smallest if the next index is smaller
                    min = pizzas.get(j).getCalories();
                    minIndex = j;
                }
            }

            //swap
            if (minIndex == i) {
                //do nothing if it is the smallest index
                ;
            } else {
                //swap using selection sort if otherwise
                Pizza temp = pizzas.get(i);
                pizzas.set(i, pizzas.get(minIndex));
                pizzas.set(minIndex, temp);
            }
        }
    }
    
    /**
     * add a pizza to the arraylist using the pizza constructor
     */
    private void addRandomPizza() {
        //check if the list is empty
        if (this.pizzas == null) {
            this.pizzas.insert(new Pizza(), 0);
        } else {
            //add to the end of the array
            this.pizzas.insert(new Pizza(), this.pizzas.size() - 1);
        }
    }

    /**
     * sorts all of the elements in pizza by price
     */
    private void sortByPrice() {  
        //return if array is null or only one element
        if (pizzas == null || pizzas.size() == 0 || pizzas.size() == 1) {
            return;
        }

        int minIndex;          //store index that has smallest element
        Money min;             //holds smallest price count

        //loop through pizzas
        for (int i = 0; i < pizzas.size(); i++) {
            //start by making smallests of the current index
            min = pizzas.get(i).getCost();      
            minIndex = i;

            //loop starting after the currenct index
            for (int j = i + 1; j < pizzas.size(); j++) {
                //use compareTo method to compare Money objects
                if (min.compareTo(pizzas.get(j).getCost()) == 1) {
                    //change smallest if the next index is smaller
                    min = pizzas.get(j).getCost();
                    minIndex = j;
                }
            }

            //swap
            if (minIndex == i) {
                //do nothing if it is the smallest index
                ;
            } else {
                //swap using selection sort if otherwise
                Pizza temp = pizzas.get(i);
                pizzas.set(i, pizzas.get(minIndex));
                pizzas.set(minIndex, temp);
            }
        }
    }
    
    /**
     * sorts all elements in pizzas by remaining area
     */
    private void sortBySize() {
        //return if array is null or only one element
        if (pizzas == null || pizzas.size() == 0 || pizzas.size() == 1) {
            return;
        }

        int minIndex;          //store index that has smallest element
        double min;            //holds smallest area

        //loop through pizzas
        for (int i = 0; i < pizzas.size(); i++) {
            //start by making smallests of the current index
            min = pizzas.get(i).getRemainingArea();      
            minIndex = i;

            //loop starting after the currenct index
            for (int j = i + 1; j < pizzas.size(); j++) {
                //use compareTo method to compare areas
                if (min > pizzas.get(j).getRemainingArea()) {
                    //change smallest if the next index is smaller
                    min = pizzas.get(j).getRemainingArea();
                    minIndex = j;
                }
            }

            //swap
            if (minIndex == i) {
                //do nothing if it is the smallest index
                ;
            } else {
                //swap using selection sort if otherwise
                Pizza temp = pizzas.get(i);
                pizzas.set(i, pizzas.get(minIndex));
                pizzas.set(minIndex, temp);
            }
        }
    }
    
    /**
     * finds a specific calorie count pizza
     * will sort by calorie in the driver method
     */
    private int binarySearchByCalories(int cals) {
        int low = 0;                   //set low to first index
        int high = pizzas.size() - 1;  //set high to last index
        
        while (low <= high) {
            //set mid to the mid
            int mid = (low + high) / 2;
           
            if (pizzas.get(mid).getCalories() == cals)  {
                //if the mid value is equal, return it
                return mid;
            } else if (pizzas.get(mid).getCalories() < cals) {
                //if the imd is less than cals, set the low to the mid + 1
                low = mid + 1;
            } else {
                //if the mid is greater than calls, set the high to mid - 1
                high = mid - 1;
            }
        }
        
        //return -1 if not found
        return -1;
    }
    
    /*
     * No need to edit functions below this line, unless extending the menu or
     * changing the instructions
     */
    private static final String instructions = "-----------------------\nWelcome to PizzaManager\n-----------------------\n(A)dd a random pizza\nAdd a (H)undred random pizzas\n(E)at a fraction of a pizza\nSort pizzas by (P)rice\nSort pizzas by (S)ize\nSort pizzas by (C)alories\n(B)inary Search pizzas by calories\n(Q)uit\n";

    private void displayInstructions() {
        System.out.println(instructions);    
    }

    /*
     * Notice the one-line main function.
     */
    public static void main(String[] args) {
        new PizzaManager().start();
    }
}
