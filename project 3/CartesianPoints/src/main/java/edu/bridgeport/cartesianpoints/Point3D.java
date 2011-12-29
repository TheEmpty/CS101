package edu.bridgeport.cartesianpoints;

/**
 * A class for graphing points on an invisible 3D graph.
 * @author Mohammad Typaldos [mohammad at reliablerabbit.com]
 */
public class Point3D extends Point {
    /**
     * the Z coordinate, x and y are defined in Point
     */
    private int zCord;
    
    /**
     * Create a new 3D point at the origin (0,0,0)
     */
    public Point3D(){
        setX(0);
        setY(0);
        setZ(0);
    }
    
    /**
     * Creates a new 3D point at x,y,z
     * @param newX The initial X value
     * @param newY The initial Y value
     * @param newZ The initial Z value
     */
    public Point3D(int newX, int newY, int newZ){
        setPoint(newX, newY, newZ);
    }
    
    /**
     * @return The current Z coordinate
     */
    public int getZ(){
        return zCord;
    }
    
    /**
     * @param newZ New Z coordinate
     */
    public void setZ(int newZ){
        zCord = newZ;
    }
    
    /**
     * A simple method to set the x, y, and z variables all at once.
     * @param newX The new X value of the point
     * @param newY The new Y value of the point
     * @param newZ The new Z value of the point
     */
    public void setPoint(int newX, int newY, int newZ){
        setX(newX);
        setY(newY);
        setZ(newZ);
    }
    
    /**
     * @return The coordinate of the 3D position in format: [x, y, z]
     */
    @Override
    public String toString(){
        return("[" + getX() +", " + getY() + ", " + getZ() + "]");
    }
    
    /**
     * Uses an altered distance formula to calculate the distance between two 3D points
     * @param point The 3D point that you want to know the distance between
     * @return positive double of the distance between the two 3D points.
     */
    public double distanceBetween(Point3D point){
        // d = |sqrt( (x2 - x1)^2 + (y2 - y1)^2 + (z2 - z1)^2)|
        double distance;
        
        // (x2 - x1)^2
        distance  = Math.pow(point.getX() - getX(), 2);
        // + (y2 - y1)^2
        distance += Math.pow(point.getY() - getY(), 2);
        // + (z2 - z1)^2
        distance += Math.pow(point.getZ() - getZ(), 2);
        // absolute value of the square root
        distance = Math.abs(Math.sqrt(distance));
                
        return distance;
    }
    
    /**
     * Uses an altered midpoint formula to create a new 3D point that is between the two 3D points
     * @param point The end point of the line.
     * @return A point object that resides in the middle of the line.
     */
    public Point3D midpointBetween(Point3D point){
        int x = (getX() + point.getX()) / 2;
        int y = (getY() + point.getY()) / 2;
        int z = (getZ() + point.getZ()) / 2;
        
        return new Point3D(x, y, z);
    }
    
    /**
     * Tells if points are equal to each other. Checks their X, Y, and Z values
     * @param object The object to compare
     */
    @Override
    public boolean equals(Object object){
        if(this == object) return true; // same object?
        
        if(object.getClass() == Point.class){
            Point point = (Point) object; // cast as point to access methods
            return(
                    getZ() == 0 &&
                    getX() == point.getX() &&
                    getY() == point.getY()
                  ); // same points?
            
        } else if(object.getClass() == Point3D.class){
            Point3D point = (Point3D) object;
            return(
                    getZ() == point.getZ() &&
                    getX() == point.getX() &&
                    getY() == point.getY()
                  );
        } else {
            return false;
        }
       
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + getX();
        hash = 53 * hash + getY();
        hash = 53 * hash + getZ();
        return hash;
    }
    
    /**
     * A method from the inheritance, please see dinstanceBetween(Point3D)
     * @param point The end of the line
     * @return A double with the length of the line, disregarding the Z axis.
     * @see Point3D#distanceBetween(edu.bridgeport.cartesianpoints.Point3D) 
     * @deprecated
     */
    @Override
    @Deprecated
    public double distanceBetween(Point point){
        return super.distanceBetween(point);
    }
    
    /**
     * A method from the inheritance, please see midpointBetween(Point3D)
     * @param point The end of the line
     * @return a point in the middle of the line, disregarding the Z axis.
     * @see Point3D#midpointBetween(edu.bridgeport.cartesianpoints.Point3D) 
     * @deprecated
     */
    @Override
    @Deprecated
    public Point midpointBetween(Point point){
        return super.midpointBetween(point);
    }
}
