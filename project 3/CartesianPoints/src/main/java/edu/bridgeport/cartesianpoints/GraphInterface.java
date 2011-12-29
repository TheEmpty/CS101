package edu.bridgeport.cartesianpoints;

/**
 *
 * @author Mohammad Typaldos [mohammad at reliablerabbit.com]
 */
interface GraphInterface {
    public void   addPoint(Point point);
    public void   removePoint(Point point);
    public String textualGraph();
    // public void drawLine(Point start, Point end)
}
