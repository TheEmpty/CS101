package edu.bridgeport.uniprojecttwo;

import com.reliablerabbit.prettyprint.PrettyPrint;
import java.util.Scanner;

/**
 * An application to read from System.in and parse the data.
 * After all the data is collected, pretty print it back.
 * @author Mohammad Typaldos [mohammad at reliablerabbit.com]
 */
public class App {

    /**
     * Create a PrettyPrint object on the System.out stream
     */
    static PrettyPrint pp = new PrettyPrint(System.out);
    /**
     * The manufacturer of the car 
     */
    static String carMake = "";
    /**
     * What model the car is
     */
    static String carModel = "";
    /**
     * Used to parse input
     */
    static String temp = "";
    /**
     * What year the car was made
     */
    static int carYear;
    /**
     * For taking input from the user
     */
    static Scanner input = new Scanner(System.in);

    /**
     * The driver of the application
     * @param args Arguments passed into the application
     */
    public static void main(String[] args) {
        pp.setBlockPadding(2);

        while (carMake.isEmpty()) {
            pp.print("Enter a car make: ");
            carMake = input.nextLine();
        }

        while (carModel.isEmpty()) {
            pp.print("Enter a car model: ");
            carModel = input.nextLine();
        }

        while (carYear == 0) {
            pp.print("Enter the year of the model: ");
            temp = input.nextLine();
            if (temp.trim().matches("^[0-9]+$")) {
                carYear = Integer.parseInt(temp);
            } else {
                pp.newLine();
                pp.println("Please enter the year using only digits (0-9)");
            }
        }

        // Print the block
        String[] lines = {"Car Information:", "Make: " + carMake, "Model: " + carModel, "Year: " + carYear};
        pp.blockPrint(lines);

        // Spacing
        pp.newLine();
        pp.newLine();

        // Moving application logic to carInformation()
        carInformation();

        // Spacing
        pp.newLine();
        pp.newLine();

        // Class
        getCarInput();
        Car car = new Car(carMake, carModel, carYear);
        car.outputCar(pp);
    }

    /**
     * Input carMake, carModel, and carYear and then output it to the user
     */
    private static void carInformation() {
        carMake = carModel = "";
        carYear = 0;

        while (carMake.isEmpty()) {
            pp.print("Enter a car make: ");
            carMake = input.nextLine();
        }

        while (carModel.isEmpty()) {
            pp.print("Enter a car model: ");
            carModel = input.nextLine();
        }

        while (carYear == 0) {
            pp.print("Enter the year of the model: ");
            temp = input.nextLine();
            if (temp.trim().matches("^[0-9]+$")) {
                carYear = Integer.parseInt(temp);
            } else {
                pp.newLine();
                pp.println("Please enter the year using only digits (0-9)");
            }
        }

        // Print the block
        String[] lines = {"Car Information:", "Make: " + carMake, "Model: " + carModel, "Year: " + carYear};
        pp.blockPrint(lines);
    }
    
    public static void getCarInput(){
        carMake = carModel = "";
        carYear = 0;
        
        while (carMake.isEmpty()) {
            pp.print("Enter a car make: ");
            carMake = input.nextLine();
        }

        while (carModel.isEmpty()) {
            pp.print("Enter a car model: ");
            carModel = input.nextLine();
        }

        while (carYear == 0) {
            pp.print("Enter the year of the model: ");
            temp = input.nextLine();
            if (temp.trim().matches("^[0-9]+$")) {
                carYear = Integer.parseInt(temp);
            } else {
                pp.newLine();
                pp.println("Please enter the year using only digits (0-9)");
            }
        }
    }
}
