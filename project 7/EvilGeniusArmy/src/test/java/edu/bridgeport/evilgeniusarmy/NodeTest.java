package edu.bridgeport.evilgeniusarmy;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class NodeTest extends TestCase {
    
    public NodeTest(String testName) {
        super(testName);
    }
    
    public static Test suite()
    {
        return new TestSuite( NodeTest.class );
    }
    
    public void testNode(){
        Node n1 = new Node("Hello World");
        Node n2 = new Node("Goodbye World");
        
        assertFalse(n1.hasNextNode());
        assertNull(n1.getNextNode());
        n1.setNextNode(n2);
        assertTrue(n1.hasNextNode());
        assertEquals(n1.getNextNode(), n2);
        
        assertEquals(n1.getText(), "Hello World");
    }
}
