package edu.bridgeport.evilgeniusarmy;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Ensure all application functions are working as expected
 */
public class AppTest extends TestCase {
    /**
     * Create the test case
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        TestSuite suite = new TestSuite(AppTest.class);
        suite.addTest(new TestSuite(GameTest.class));
        suite.addTest(new TestSuite(NodeTest.class));
        suite.addTest(new TestSuite(QuestionNodeTest.class));
        return suite;
    }

    /**
     * Test that it reads the input and loops correctly
     */
    public void testApp()
    {
        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        PrintStream output = new PrintStream(outputData);
        PrintStream orgOut = System.out;
        System.setOut(output);
        
        String input = TestData.ani[0] + "y" + TestData.breakline + TestData.leu[0] + TestData.breakline;
        InputStream orgIn = System.in;
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        String[] args = {""};
        
        try {
            App.main(args);
            assertTrue(outputData.toString().indexOf(TestData.animal) != -1);
            assertTrue(outputData.toString().indexOf(TestData.leut) != -1);
        } catch(Exception ex) {
            orgOut.println(ex);
        }
        
        System.setIn(orgIn);
        System.setOut(orgOut);
    }
}
