
/**
 * Data Structures: ArrayList like structures, stacks and queues
 * ArrayList class
 * 
 * @author Ethan Silvas 
 * @SuppressWarnings("unchecked");
 */
public class ArrayList<E>
{
    //data members
    @SuppressWarnings("unchecked")
    private E[] array;   //array that will hold all of the objects  
    
    /**
     * no arg constructor
     */
    public ArrayList() {
        //sets an array with no length
        this.array = (E[]) new Object[0];
    }
    
    /**
     * insert an element and move over all of the other ones after the index
     */ 
    public void insert(Object obj, int index) {
        /*
         * make an if statement that checks if it is trying to add the first element in the array
         * since the default constructor makes an array with 0 length
         */
        
        if (this.array.length == 0) {
            //if it is the one and only element in the array
            //then simply set up the array so that it holds the desired element
            this.array = (E[]) new Object[1];
            this.array[0] = (E) obj;
        } else {
            /*
             * this code will be executed whenever there is at least one element 
             * already in the array
             */
            
            //set up a temp array that will be used to copy the array with the new element
            E[] temp = (E[]) new Object[this.array.length + 1];   //it holds one more element than the current array

            //first copy over all the elements before the desired index
            for (int i = 0; i < index; i++) {
                temp[i] = this.array[i];
            }
            
            //then set the desired index to the object
            temp[index] = (E) obj;
            
            //copy over the rest of the array
            for (int i = index + 1; i < temp.length; i++) {
                /* since the temp array is one index larger, and we have inserted the new element
                 * take in the previous element from the original array
                 * 
                 * this will "shift over" the elements after the index one index to the right
                 */
                temp[i] = this.array[i - 1];
            }
            
            //set the array to the copy
            this.array = (E[]) temp;
        }
    } 
  
    /**
     * remove an element from the array and move the elements after it to the left one index
     */
     public E remove(int index) {
        //first make a copy of the element we are going to remove later
        //so that it can be returned
        E copy = this.array[index];
         
        /*
         * make an if to find out if there is only one element in the array or not
         * if there is, then simply make the array empty
         */
        if (this.array.length == 1) {
            //only one element in the array, so there is nothing to slide over
            this.array = (E[]) new Object[0];
        } else {
            //make a temp array that has one less index than the current array
            Object[] temp = new Object[this.array.length - 1];
            
            //copy everything up to the desired index
            for (int i = 0; i < index; i++) {
                temp[i] = this.array[i];
            }
            
            //now copy all of the other elements after the index, but skip over the desired element to remove
            for (int i = index; i < temp.length; i++) {
                /*
                 * take in the element from the next index over from this.array
                 * this will automatically skip over the element that we want to remove
                 */
                temp[i] = this.array[i + 1];
            }
            
            //set the array to the temp now that the element is removed
            this.array = (E[]) temp;
        }
         
        //return the copy that we created before we removed the element
        return (E) copy;
    }
    
    /**
     * return the size or length of the array
     */ 
    public int size() {
        //encapsulate
        int size = this.array.length;
        return size;
    }
    
    /**
     * store the entire array into a string
     */
    @Override
    public String toString() {
        String arrString = "";
        
        //loop to add all the elements
        for (int i = 0; i < this.array.length; i++) {
            arrString = arrString + " " + this.array[i];
        }
        
        return arrString;
    }
    
    /**
     * check if an array is empty
     */
    public boolean isEmpty() {
        //if the array length is 0, then the array is empty
        if (this.array.length < 1) {
            return true;
        }
        
        //return false if the length is greater than 0
        return false;
    }
    
    /**
     * find the index of an object
     */
    public int indexOf(Object element) {
        //loop through the array
        for (int i = 0; i < this.array.length; i++) {
            //check each element to see if they are equal
            if (this.array[i] == element) {
                //return the index 
                return i;
            }
        }
        
        //if it makes it through the array, then no elements are equal
        return -1;
    }
    
    /**
     * check to see if two
     */ 
    public boolean equals(Object other) {
        //first make sure that the object is an arraylist
        //and also make sure that it isnt null
        if (other == null || !(other instanceof ArrayList)) {
           return false;
        }
        
        //type cast the argument into an array, now that we know that it is one
        ArrayList<E> that = (ArrayList<E>) other;
        
        //check to see if the lengths are the same
        if (this.array.length == that.array.length) {
            //if the lengths are the same, check each value to see if they are the same
            //loop through the array only once
            for (int i = 0; i < this.array.length; i++) {
                //compare the elements of each index
                if (this.array[i] == that.array[i]) {
                    //continue to check all elements
                    continue;
                } else {
                    //if one of the elements aren't the same, return false
                    return false;
                }
            }
        } else {
            //return false if the lengths are not the same
            return false;
        }
        
        //if it gets through the loop, then all of the elements are equal 
        return true;
    }
    
    /**
     * swaps elements 
     */
    public void swap(E obj1, E obj2) {
        
    }
    
    /**
     * replaces an element
     */
    public void set(int index, Object obj) {
        array[index] = (E) obj;
    }
    
    /**
     * return the object of the specified index
     */
    public E get(int index) {
        //make sure the index is valid
        if (this.array.length - 1 >= index) {
            //encapsulate
            Object element = this.array[index];
            return (E) element;
        } 
        
        //if the index is invalid, return -1
        throw new IllegalArgumentException();
    }
}
