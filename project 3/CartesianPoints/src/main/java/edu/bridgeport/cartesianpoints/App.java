package edu.bridgeport.cartesianpoints;

/**
 * @author Yasser Elleithy [yelleithy at bridgeport.edu]
 */
public class App 
{
    /**
     * Main driver for the application
     * @param arguments Command line arguments.
     */
    public static void main(String[] arguments){
        // Create a new point using the default constructor
        Point myPoint1 = new Point(); 
        
        // Display the points
        System.out.println("\nPoints from Default constructor");
        System.out.println("X coordinate of Point 1: " + myPoint1.getX());
        System.out.println("Y coordinate of Point 1: " + myPoint1.getY());
        System.out.println("Point 1: " + myPoint1.toString() + "\n");

        // Now change the points using the setPoint method
        myPoint1.setPoint(4, 6);
        
        // Display the points
        System.out.println("New points");
        System.out.println("X coordinate of Point 1: " + myPoint1.getX());
        System.out.println("Y coordinate of Point 1: " + myPoint1.getY());
        System.out.println("Point 1: " + myPoint1.toString() + "\n");

        // Create a new point using another constructor
        Point myPoint2 = new Point(6, 9);
        
        // Display the points
        System.out.println("X coordinate of Point 2: " + myPoint2.getX());
        System.out.println("Y coordinate of Point 2: " + myPoint2.getY());
        System.out.println("Point 2: " + myPoint2.toString() + "\n");
    }
}
