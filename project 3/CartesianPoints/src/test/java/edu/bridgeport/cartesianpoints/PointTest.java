package edu.bridgeport.cartesianpoints;

import junit.framework.TestCase;

/**
 * @author Mohammad Typaldos <mohammad at reliablerabbit.com>
 */
public class PointTest extends TestCase {
    
    /**
     * Setup the test suite
     * @param testName What test is being ran
     */
    public PointTest(String testName) {
        super(testName);
    }
    
    /**
     * Tests the constructors, by using the getters.
     * @see Point#Point() 
     * @see Point#Point(int, int)
     * @see Point#getX()
     * @see Point#getY() 
     */
    public void testConstructorsAndGetters(){
        Point point1 = new Point();
        assertEquals(0, point1.getX());
        assertEquals(0, point1.getY());
        
        Point point2 = new Point(5,7);
        assertEquals(5, point2.getX());
        assertEquals(7, point2.getY());
    }
    
    /**
     * Test that the setters react as expected
     * @see Point#setX(int)
     * @see Point#setY(int) 
     */
    public void testSetters(){
        Point point = new Point();
        point.setX(2);
        assertEquals(2, point.getX());
        
        point.setY(-4);
        assertEquals(-4, point.getY());
    }
    
    /**
     * Test the setPoint method which sets x and y at the same time
     * @see Point#setPoint(int, int)
     */
    public void testSetPoint(){
        Point point = new Point();
        point.setPoint(10, -3);
        
        assertEquals(10, point.getX());
        assertEquals(-3, point.getY());
    }
    
    /**
     * Test the toString() method that was overridden to output [x, y]
     * @see Point#toString() 
     */
    public void testToString(){
        Point point = new Point();
        point.setPoint(12, 25);
        assertEquals("[12, 25]", point.toString());
    }
    
    /**
     * Test the distance formula method
     * @see Point#distanceBetween(edu.bridgeport.cartesianpoints.Point) 
     */
    public void testDistanceBetween(){
        Point point1 = new Point(0,0);
        Point point2 = new Point(0,4);
        assertEquals(4.0, point1.distanceBetween(point2));
    }
    
    /**
     * Tests the midpoint formula
     * @see Point#midpointBetween(edu.bridgeport.cartesianpoints.Point) 
     */
    public void testMidpointBetween(){
        Point   point1 = new Point(-1,2);
        Point   point2 = new Point(3,-6);
        Point expected = new Point(1,-2);
        
        assertEquals(expected, point1.midpointBetween(point2));
    }
    
    /**
     * Test the equals override
     * @see Point#equals(Object)
     */
    public void testEquals(){
        Point point1 = new Point(1,2);
        Point point2 = new Point(2,2);
        Point point3 = new Point(1,2);
        Point3D point4 = new Point3D(1,2,0);
        Point3D point5 = new Point3D(1,2,5);
        
        assertTrue( point1.equals(point1));
        assertTrue( point1.equals(point3));
        assertFalse(point1.equals(point2));
        
        assertTrue(point3.equals(point4));
        assertFalse(point3.equals(point5));
    }
}
