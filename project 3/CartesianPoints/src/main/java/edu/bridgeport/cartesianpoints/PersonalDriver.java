package edu.bridgeport.cartesianpoints;
import java.io.PrintStream;

/**
 *
 * @author Mohammad Typaldos <mohammad at reliablerabbit.com>
 */
public class PersonalDriver {
    public static void main(String[] args) {
        Point point1 = new Point();
        displayPoint(point1, "Point 1", System.out);
        
        System.out.println();
        
        point1.setPoint(4, 4);
        System.out.println("New Points");
        displayPoint(point1, "Point 1", System.out);
        
        System.out.println();
        
        Point point2 = new Point(8, 8);
        displayPoint(point2, "Point 2", System.out);
        
        System.out.println();
        
        System.out.print("Distance between the two points: ");
        System.out.println(point1.distanceBetween(point2));
        Point point3;
        point3 = point1.midpointBetween(point2);
        System.out.print("Midpoint between the two points: ");
        System.out.println(point3);
        
        System.out.println();
        System.out.println("3D points");
        
        Point3D point4 = new Point3D(8, 8, 10);
        System.out.println(point4);
        Point3D point5 = new Point3D(4, 4, 0);
        System.out.println(point5);
        System.out.println(point4.midpointBetween(point5));
        System.out.println(point4.distanceBetween(point5));
        System.out.println(point2.equals(point3));
        System.out.println(point3.equals(point2));
        
        System.out.println();
        
        Graph graph = new Graph();
        graph.addPoint(point1);
        graph.addPoint(point2);
        graph.addPoint(point3);
        graph.addPoint(new Point(-10, 5));
        graph.addPoint(new Point(0,0));
        System.out.println(graph);
    }
    
    private static void displayPoint(Point point, String pointTitle, PrintStream stream){
        System.out.println("X coordinate of " + pointTitle + ": " + point.getX());
        System.out.println("Y coordinate of " + pointTitle + ": " + point.getY());
        System.out.println(pointTitle + ": " + point.toString());
    }
}
