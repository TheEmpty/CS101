package edu.bridgeport.uniprojecttwo;

import com.reliablerabbit.prettyprint.PrettyPrint;
import java.io.PrintStream;

/**
 * A class for holding car data and printing it back to a PrintStream.
 * @author Mohammad Typaldos [mohammad at reliablerabbit.com]
 */
public class Car {
    /**
     * The make/manufacture of the car
     */
    String make;
    /**
     * The model of the car
     */
    String model;
    /**
     * The year of the model
     */
    int year;
    
    /**
     * Creates a Car object that takes the make, model, and year of the car.
     * @param setMake The make/manufacture of the car
     * @param setModel The model of the car
     * @param setYear  The year of the model
     */
    Car(String setMake, String setModel, int setYear){
        make  = setMake;
        model = setModel;
        year  = setYear;
    }
    
    /**
     * Uses a pretty print class to render the information about the car.
     * @param outputStream the stream to print to
     * @see edu.bridgeport.uniprojecttwo.Car#outputCar(com.reliablerabbit.prettyprint.PrettyPrint) 
     * @see com.reliablerabbit.prettyprint.PrettyPrint#blockPrint(java.lang.String[])
     */
    public void outputCar(PrintStream outputStream){
        PrettyPrint prettyPrint = new PrettyPrint(outputStream);
        prettyPrint.setBlockPadding(2);
        outputCar(prettyPrint);
    }
    
    /**
     * Outputs car information to an exisiting PrettyPrint object. Useful
     * if you want to customize settings or already have an instance and
     * want to keep RAM usage low. Method uses blockPrint
     * @param pp Your PettyPrint object
     * @see com.reliablerabbit.prettyprint.PrettyPrint#blockPrint(java.lang.String[]) 
     */
    public void outputCar(PrettyPrint pp){
        String[] lines = {"Car Information:", "Make: " + make, "Model: " + model, "Year: " + year};
        pp.blockPrint(lines);   
    }
}
