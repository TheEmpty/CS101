package edu.bridgeport.evilgeniusarmy;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.util.Scanner;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class GameTest extends TestCase {
    
    public GameTest(String testName) {
        super(testName);
    }
    
    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( GameTest.class );
    }
    
    /**
     * Test that it flows as expected
     */
    public void testGameloop()
    {
        Game game = new Game();
        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        PrintStream output = new PrintStream(outputData);
        game.setOutput(output);
        
        // Stick to coding
        for(int i = 0; TestData.stickToCoding.length > i; i++){
            Scanner in = new Scanner(TestData.stickToCoding[i]);
            game.setScanner(in);
            try {
                game.gameLoop();
                assertFalse(outputData.toString().indexOf(TestData.stick) == -1);
            } catch(Exception ex) {
                System.out.println(ex);
            }
        }
        
        // Threat
        for(int i = 0; TestData.threat.length > i; i++){
            Scanner in = new Scanner(TestData.threat[i]);
            game.setScanner(in);
            try {
                game.gameLoop();
                assertFalse(outputData.toString().indexOf(TestData.genius) == -1);
                assertFalse(outputData.toString().indexOf(TestData.animal) == -1);
            } catch(Exception ex) {
                System.out.println(ex);
            }
        }
        
        // Leutanit
        for(int i = 0; TestData.leu.length > i; i++){
            Scanner in = new Scanner(TestData.leu[i]);
            game.setScanner(in);
            try {
                game.gameLoop();
                assertFalse(outputData.toString().indexOf(TestData.leut) == -1);
            } catch(Exception ex) {
                System.out.println(ex);
            }
        }
        
        // Minon
        for(int i = 0; TestData.min.length > i; i++){
            Scanner in = new Scanner(TestData.min[i]);
            game.setScanner(in);
            try {
                game.gameLoop();
                assertFalse(outputData.toString().indexOf(TestData.minio) == -1);
            } catch(Exception ex) {
                System.out.println(ex);
            }
        }
        
        // Animal
        for(int i = 0; TestData.ani.length > i; i++){
            Scanner in = new Scanner(TestData.ani[i]);
            game.setScanner(in);
            try {
                game.gameLoop();
                assertFalse(outputData.toString().indexOf(TestData.animal) == -1);
            } catch(Exception ex) {
                System.out.println(ex);
            }
        }
        
    }
}
