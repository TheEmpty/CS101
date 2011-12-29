package uniprojectone;

import java.io.InputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.logging.FileHandler;

public class Helper {
    private final static Logger LOGGER = Logger.getLogger(Helper.class .getName());
    
    /**
     * @param fileLocation location to save log file
     */
    public static void saveLogAs(String fileLocation){
        saveLogAs(fileLocation, true);
    }
    
    /**
     * @param fileLocation location to save log file
     * @param appendFile is it appending or overwriting?
     */
    public static void saveLogAs(String fileLocation, boolean appendFile){
        try {
            FileHandler logFile = new FileHandler(fileLocation, appendFile);        
            LOGGER.addHandler(logFile);
        } catch(IOException exception){
            println("WARNING: Unable to open log file!");
            println(exception.toString());
        }
    }
        
    /**
     * @param text to be printed without a break line
     */
    private static void print(String text) {
        System.out.print(text);
    }

    /**
     * @param text string to output to console, followed by a break line
     */
    private static void println(String text) {
        System.out.println(text);
    }

    /**
     * @param resourceLocation is string of file to load, ex: "resources/README"
     */
    public static void outputResource(String resourceLocation) throws FileNotFoundException {
        InputStream inputStream = UniProjectOne.class.getResourceAsStream(resourceLocation);
        if(inputStream == null){
            throw new FileNotFoundException("Resource '" + resourceLocation + "' could not be found.");
        }
        try {
            println(inputStreamToString(inputStream));
        } catch(IOException exception) {
            LOGGER.log(Level.SEVERE, "Access denied (file) (403)",exception);
            println("The following error was raised while trying to access: " + resourceLocation);
            println(exception.toString());
        }
    }

    /**
     * @param in InputStream that you want returned as a String
     * @return String value of in
     */
    public static String inputStreamToString(InputStream in) throws IOException {
        StringBuilder output = new StringBuilder();
        byte[] b = new byte[4096];
        for (int n; (n = in.read(b)) != -1;) {
            output.append(new String(b, 0, n));
        }
        return output.toString();
    }

    public static void outputBookName() {
        println("Introduction to Programming and Problem Solving with Java");
    }

    public static void outputNameObsessively() {
        String firstName = "Mohammad";
        String lastName = "El-Abid";
        print(firstName + " " + lastName);
        println(firstName);
        println(lastName);
    }

    public static void outputBrokenPoem() {
        println("The moon\nis\nblue.");
    }

    public static void outputAbeSpeech() {
        println("a. Four score\n   and seven years ago");
        println("b. Four score\n   and seven\n   years ago");
    }
    
    public static void outputFace() {
        try {
            outputResource("resources/face.txt");
        } catch(FileNotFoundException exception) {
            LOGGER.log(Level.SEVERE, "File not found (404)", exception);
            println(exception.toString());
        }
    }
}
