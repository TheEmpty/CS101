package edu.bridgeport.evilgeniusarmy;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class QuestionNodeTest extends TestCase {
    
    public QuestionNodeTest(String testName) {
        super(testName);
    }
    
    public static Test suite()
    {
        return new TestSuite( QuestionNodeTest.class );
    }
    
    public void testDualLink(){
        QuestionNode qn1  = new QuestionNode("Is this a question?", "yes", "no");
        QuestionNode qn2  = new QuestionNode("Are you a question?", "yes", "no");
        ConclusionNode a1 = new ConclusionNode("You're pretty smart!");
        ConclusionNode a2 = new ConclusionNode("You need some help.");
        
        qn1.setPositiveNode(a1);
        qn1.setNegativeNode(qn2);
        qn2.setPositiveNode(a2);
        qn2.setNegativeNode(a1);
        
        assertEquals(qn1.getPositiveNode(), a1);
        assertEquals(qn1.getNegativeNode(), qn2);
    }
}
