package edu.bridgeport.cartesianpoints;

import junit.framework.TestCase;

/**
 * Each method should have a JavaDoc with an @see to the method(s) that it is testing.
 * @author Mohammad Typaldos [mohammad at reliablerabbit.com]
 */
public class Point3DTest extends TestCase {
    
    /**
     * Setup the test suite
     * @param testName What test is being ran
     */
    public Point3DTest(String testName) {
        super(testName);
    }
    
    /**
     * @see Point3D#Point3D() 
     * @see Point3D#Point3D(int, int, int) 
     */
    public void testConstructors(){
        Point3D point1 = new Point3D();
        Point3D point2 = new Point3D(5, 10, -2);
        
        assertEquals(0, point1.getX());
        assertEquals(0, point1.getY());
        assertEquals(0, point1.getZ());
        
        assertEquals( 5, point2.getX());
        assertEquals(10, point2.getY());
        assertEquals(-2, point2.getZ());
    }
    
    /**
     * @see Point3D#setZ(int) 
     * @see Point3D#getZ()
     */
    public void testSettersGetters(){
        Point3D point = new Point3D();
        point.setZ(5);
        assertEquals(5, point.getZ());
    }
    
    /**
     * @see Point3D#setPoint(int, int, int)
     */
    public void testSetPoints(){
        Point3D point = new Point3D();
        point.setPoint(5, -3, 7);
        
        assertEquals( 5, point.getX());
        assertEquals(-3, point.getY());
        assertEquals( 7, point.getZ());
    }
    
    /**
     * @see Point3D#toString()
     */
    public void testToString(){
        Point3D point = new Point3D(2, -4, 6);
        assertEquals("[2, -4, 6]", point.toString());
    }
    
    /**
     * @see Point3D#distanceBetween(edu.bridgeport.cartesianpoints.Point3D) 
     */
    public void testDistanceBetween(){
        Point3D point1 = new Point3D(5,   6,   2);
        Point3D point2 = new Point3D(-7, 11, -13);
        // It's really 19.848433, but due to percison lost it becomes:
        double  dstnce = 19.849433241279208;
        
        assertEquals(dstnce, point1.distanceBetween(point2));
    }
    
    /**
     * @see Point3D#midpointBetween(edu.bridgeport.cartesianpoints.Point3D) 
     */
    public void testMidpointBetween(){
        Point3D point1 = new Point3D(2, 2, 2);
        Point3D expect = new Point3D(3, 3, 3);
        Point3D point2 = new Point3D(4, 4, 4);
        
        Point3D midpoint = point1.midpointBetween(point2);
        assertEquals(expect, midpoint);
    }
    
    /**
     * @see Point3D#equals(java.lang.Object) 
     */
    public void testEquals(){
        Point3D point1 = new Point3D(2, 5, 8);
        Point3D point2 = new Point3D(5, 2, 8);
        Point3D point3 = new Point3D(2, 5, 8);
        Point3D point4 = new Point3D(2, 5, 0);
        Point   point5 = new Point(2, 5);
        
        assertTrue(point1.equals(point1));
        assertTrue(point1.equals(point3));
        assertFalse(point1.equals(point2));
        assertTrue(point4.equals(point5));
    }
}
