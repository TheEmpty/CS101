package edu.bridgeport.cartesianpoints;

import junit.framework.TestCase;

/**
 * @author Mohammad Typaldos [mohammad at reliablerabbit.com]
 */
public class GraphTest extends TestCase {
    
    /**
     * Setup the test suite
     * @param testName What test is being ran
     */
    public GraphTest(String testName) {
        super(testName);
    }
    
    /**
     * Basic test for the graph drawing
     * @see Graph#textualGraph() 
     */
    public void testTextualGraph(){
        Graph graph = new Graph();
        
        graph.addPoint(new Point(2,2));
        graph.addPoint(new Point(-2, -2));
        graph.addPoint(new Point(0,0));
        
        String actual = graph.textualGraph();
        
        String expected =
                "+3 ...|..." + "\n" +
                "+2 ...|.*." + "\n" +
                "+1 ...|..." + "\n" +
                "+0 ---*---" + "\n" +
                "-1 ...|..." + "\n" +
                "-1 ...|..." + "\n" +
                "-2 .*.|..." + "\n" +
                "-3 ...|..." + "\n" +
                               "\n" +
                "   ---++++" + "\n" +
                "   3210123" + "\n";
        
        // remove the colors
        actual = actual.replaceAll("\033\\[1;31m", "");
        actual = actual.replaceAll("\033\\[1;34m", "");
        actual = actual.replaceAll("\033\\[1;35m", "");
        
        System.out.println("---");
        System.out.println(actual);
        System.out.println("---");
        System.out.println(expected);
        System.out.println("---");
        
        assertEquals(expected, actual);
    }
    
    public void testEquals(){
        Graph graph1 = new Graph();
        Graph graph2 = new Graph();
        Graph graph3 = new Graph();
        
        graph1.addPoint(5, 2);
        graph2.addPoint(5, 2);
        graph3.addPoint(5, 2);
        
        graph1.addPoint(-2, 3);
        graph2.addPoint(-2, 3);
        
        assertEquals(graph1, graph2);
        assertFalse(graph1.equals(graph3));
    }
}
