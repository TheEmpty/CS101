package edu.bridgeport.uniprojecttwo;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.InputStream;

/**
 * Unit test for UniProjectTwo.
 * @author Mohammad Typaldos [mohammad at reliablerabbit.com]
 */
public class AppTest
        extends TestCase {

    /**
     * The line separator of the OS, generally \n on *nix and \r\n and Windows
     */
    private static final String lineSeparator = System.getProperty("line.separator");
    /**
     * Where we will store the data that is received from "System.out"
     */
    private ByteArrayOutputStream outContent;

    /**
     * Create the test case
     * @param testName name of the test case
     */
    public AppTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    /**
     * Runs the application like a user would, but reroutes the System.in and System.out
     * temporarily so that the test suite can interact with the program and confirm the output.
     */
    public void testApp() {
        InputStream stdin = System.in;
        PrintStream stdout = System.out;

        String input =
                  "Some Make" + lineSeparator + "Some Model" + lineSeparator + "2000" + lineSeparator
                + "Nisan" + lineSeparator + "370Z" + lineSeparator + "2011" + lineSeparator
                + "Random Make" + lineSeparator + "A long model name" + lineSeparator + "1010" + lineSeparator;
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        String[] args = {};
        App.main(args);

        String expected =
                  "Enter a car make: Enter a car model: Enter the year of the model: "
                + "***********************" + lineSeparator
                + "*   Car Information:  *" + lineSeparator
                + "*   Make: Some Make   *" + lineSeparator
                + "*  Model: Some Model  *" + lineSeparator
                + "*      Year: 2000     *" + lineSeparator
                + "***********************" + lineSeparator
                + lineSeparator
                + lineSeparator
                + "Enter a car make: Enter a car model: Enter the year of the model: "
                + "**********************" + lineSeparator
                + "*  Car Information:  *" + lineSeparator
                + "*     Make: Nisan    *" + lineSeparator
                + "*     Model: 370Z    *" + lineSeparator
                + "*     Year: 2011     *" + lineSeparator
                + "**********************" + lineSeparator
                + lineSeparator
                + lineSeparator
                + "Enter a car make: Enter a car model: Enter the year of the model: "
                + "******************************" + lineSeparator
                + "*      Car Information:      *" + lineSeparator
                + "*      Make: Random Make     *" + lineSeparator
                + "*  Model: A long model name  *" + lineSeparator
                + "*         Year: 1010         *" + lineSeparator
                + "******************************" + lineSeparator;

        System.setIn(stdin);
        System.setOut(stdout);

        /** DEBUG:
        System.out.println("---EXPECTED---");
        System.out.println(expected);
        System.out.println("---ACTUAL---");
        System.out.println(outContent.toString());
        System.out.println("---END---");
         */
        assertEquals(expected, outContent.toString());
    }
}
