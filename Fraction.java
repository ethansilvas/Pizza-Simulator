
/**
 * HW2 Fraction used for pizza simulator
 * 
 * added subtraction method to change pizza sizes 
 * 
 * @author Ethan Silvas 
 */
public class Fraction implements Comparable, Cloneable
{
    //data members
    private int numerator;
    private int denominator;
    
    //constructors
    /**
     * no arg constructor
     */
    Fraction() {}
    
    /**
     * creates a fraction by taking in a numerator and denominator
     */
    Fraction(int nx, int nd) {
        this.numerator = nx;
        this.denominator = nd;
    }
    
    /**
     * reused gcd method to use
     */
    private int euclid(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }
        
        return euclid(n2, n1 % n2);
    }
    
    /**
     * simplify a fraction
     */
    public Fraction simplify() {
        //get the gcd
        int gcd = euclid(this.numerator, this.denominator);
        
        //store numerator and denominator
        int n = this.numerator;
        int d = this.denominator;
        
        //simplify 
        n /= gcd;
        d /= gcd;
        
        //make new fraction with simplified numbers
        Fraction simple = new Fraction(n, d);
        return simple;
    }
    
    /**
     * subtract two fractions
     * a/b - c/d = (ad - cb)/bd
     */
    public Fraction subtract(Fraction f) {
        //find the common denominator
        int cd = this.denominator * f.denominator;
        
        //store denominators
        int d1 = this.denominator;
        int d2 = f.denominator;
        
        //multiply numerators by the quotient of the common denominator and their denominators
        int num1 = this.numerator * (cd / d1);
        int num2 = f.numerator * (cd / d2);
        
        //new numerator is the manipulated numerators subtracted 
        int num3 = num1 - num2;
         
        //make new fraction out of manipulated numerator and common denominator 
        Fraction difference = new Fraction(num3, cd);
        //difference.simplify();
        
        return difference;
    }
    
    /**
     * compares fractions 
     * negative - this < other
     * zero - this = other
     * positive - this > other
     */
    public int compareTo(Object other) {
        //first make sure the object is a fraction
        if (other == null || !(other instanceof Fraction)) {
            //throw an illegal argument exception if the argument isnt a fraction
            throw new IllegalArgumentException();
        }
        
        //now type cast to manipulate
        Fraction that = (Fraction) other;
        
        try {
            //cross multiply 
            int left = this.getNumerator() * that.getDenominator();
            int right = this.getDenominator() * that.getNumerator();
            return left - right;
        } catch (IllegalArgumentException e) {
            //catch the thrown exception and print that it was an invalid argument
            System.out.println("Argument is not a Fraction.");
        }
        
        //it shouldnt get here, but return 0 so that we will know if something has gone wrong
        return 0;
    }
    
    /**
     * uses gcd to check if two fractions are equal
     */
    public boolean equals(Fraction other) {
        //find the gcd's of both fractions
        int thisFractionGcd = euclid(this.numerator, this.denominator);
        int otherFractionGcd = euclid(other.numerator, other.denominator);
        
        //simplify both fractions using their respective gcd's
        int thisSimplifiedNum = this.numerator / thisFractionGcd;
        int thisSimplifiedDenom = this.denominator / thisFractionGcd;
        
        int otherSimplifiedNum = other.numerator / otherFractionGcd;
        int otherSimplifiedDenom = other.denominator / otherFractionGcd;
        
        //compare the simplified fractions and return true if they are equal
        if (thisSimplifiedNum == otherSimplifiedNum && thisSimplifiedDenom == otherSimplifiedDenom) {
            return true;
        }
        
        return false;
    }
    
    /**
     * clone a fraction
     */
    @Override
    public Fraction clone() {
        return new Fraction(this.getNumerator(), this.getDenominator());
    }
    
    /**
     * toString method that saves the fraction as a string
     * also functions as the fraction simplifier 
     */
    @Override
    public String toString() {
        //consider that the fraction has a zero for a denominator
        //dont simplify and just print the fraction as is 
        if (this.denominator == 0) {
            String zero = this.numerator + "/" + this.denominator; 
            return zero;
        }
        
        //simplify the fraction by using euclids on just the fraction
        int gcd = euclid(this.numerator, this.denominator);
        
        //return only the simplified fraction
        String fractionString = (this.numerator / gcd) + "/" + (this.denominator / gcd);
        return fractionString;
    }
    
    //accessors
    /**
     * return the numerator
     */
    public int getNumerator() {
        return this.numerator;
    }
    
    /**
     * return the denominator
     */
    public int getDenominator() {
        return this.denominator;
    }
    
    //mutators
    /**
     * set the numerator
     */
    public void setNumerator(int num) {
        this.numerator = num;
    }
    
    /**
     * set the denominator
     */
    public void setDenominator(int denom) {
        this.denominator = denom;
    }
}
