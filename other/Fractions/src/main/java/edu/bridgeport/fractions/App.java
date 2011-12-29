package edu.bridgeport.fractions;

public class App 
{
    public static void main( String[] args )
    {
        Fraction f1 = new Fraction(2,3);
        Fraction f2 = new Fraction(1,3);
        
        System.out.println("a  : " + f1);
        System.out.println("b  : " + f2);
        System.out.println("a+b: " + f1.add(f2));
        System.out.println("a-b: " + f1.subtract(f2));
        System.out.println("a*b: " + f1.multiply(f2));
        System.out.println("a/b: " + f1.divide(f2));
        System.out.println("a with denominator of 9: " + f1.withDenominator(9));
    }
}
