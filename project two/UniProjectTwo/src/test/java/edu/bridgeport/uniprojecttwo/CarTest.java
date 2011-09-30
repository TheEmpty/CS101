package edu.bridgeport.uniprojecttwo;

import junit.framework.TestCase;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Test the car class for edu.bridgeport.uniprojecttwo
 * @author Mohammad Typaldos [mohammad at reliablerabbit.com]
 */
public class CarTest extends TestCase {

    /**
     * The line separator of the OS, generally \n on *nix and \r\n and Windows
     */
    private static final String lineSeparator = System.getProperty("line.separator");

    /**
     * Create the test case
     * @param testName name of the test case
     */
    public CarTest(String testName) {
        super(testName);
    }

    /**
     * Tests that the outputCar method correctly prints the information
     * @see edu.bridgeport.uniprojecttwo.Car#outputCar(java.io.PrintStream)
     */
    public static void testOutputCar() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream output = new PrintStream(outContent);

        Car car = new Car("Nisan", "370Z", 2011);

        String expected =
                  "**********************" + lineSeparator
                + "*  Car Information:  *" + lineSeparator
                + "*     Make: Nisan    *" + lineSeparator
                + "*     Model: 370Z    *" + lineSeparator
                + "*     Year: 2011     *" + lineSeparator
                + "**********************" + lineSeparator;

        car.outputCar(output);

        assertEquals(expected, outContent.toString());
    }
}
