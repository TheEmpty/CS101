package com.reliablerabbit.prettyprint;

import java.io.PrintStream;

/**
 * TODO: make more returning functions along side a printing counter part?
 */

/**
 * Helps output data to the user generally in a clean format
 * @author Mohammad Typaldos [mohammad at reliablerabbit.com]
 * @version 0.75
 */
public class PrettyPrint {

    /**
     * How much padding in between the string and asterisks.
     */
    private int blockPadding = 1;
    /**
     * The stream to output to.
     */
    private PrintStream outputStream;

    /**
     * Initialize a PrettyPrint object on a stream.
     * @param stream The stream to output too
     */
    public PrettyPrint(PrintStream stream) {
        outputStream = stream;
    }

    /**
     * Assumes that there is no minimum width and lets it become longest length.
     * Outputs lines on different lines, surrounded by an asterisk block.
     * @param lines An array of Strings that you want to be outputted on different lines 
     * @see blockPrint(String[] lines, int minWidth)
     */
    public void blockPrint(String[] lines) {
        blockPrint(lines, 0);
    }

    /**
     * Creates a "block" that centers the text and surrounds it with asterisk.
     * @param lines The line to be printed
     * @param minWidth Minimum width, will be expanded if lines are longer then this.
     */
    public void blockPrint(String[] lines, int minWidth) {
        blockPrint(lines, minWidth, '*');
    }
    
    /**
     * Create a "block" that center the text and surrounds it with a character.
     * @param lines The lines to be printed
     * @param minWidth Minimum width, will be expanded if lines are longer then this.
     * @param surroundWith The character to surround the lines with.
     */
    public void blockPrint(String[] lines, int minWidth, char surroundWith) {
        int lineLength = minWidth;
        int i = 0;
        int borderLength;

        while (lines.length > i) {
            if (lines[i].length() > lineLength) {
                lineLength = lines[i].length();
            }
            i++;
        }

        borderLength = (lineLength + (blockPadding * 2) + 2);
        printTimes(borderLength, surroundWith);
        newLine();

        i = 0;
        while (lines.length > i) {
            outputStream.print(surroundWith); // prints the border
            outputStream.print(centerString(lines[i], lineLength + (blockPadding * 2)));
            outputStream.print(surroundWith); // prints the border
            newLine();
            i++;
        }

        printTimes(borderLength, surroundWith);
        newLine();
    }
    
    /**
     * Centers a string based on the length passed in.
     * @param string The string to center, leading and trailing white spaces are removed.
     * @param length The length to center it in. If this length is smaller then the string, the string will be returned uncut.
     * @return A string with leading and trailing white space to center the string in an amount of length.
     */
    public static String centerString(String string, int length){
        string = string.trim();
        
        int remaining = length - string.length();
        if(0 >= remaining){
            return string;
        }
        
        int leftPadding, rightPadding;
        leftPadding = rightPadding = remaining / 2;
        if(remaining % 2 == 1){
            leftPadding++;
        }
        
        String leftPaddingString = generateRepeatingString(leftPadding, ' ');
        String rightPaddingString = generateRepeatingString(rightPadding, ' ');
        
        return(leftPaddingString + string + rightPaddingString);
    }

    /**
     * Generates string with a character x times
     * @param times how many times to have the character
     * @param thing the character to repeat
     * @return a string with 'thing' repeated 'times'.
     */
    public static String generateRepeatingString(int times, char thing){
        int i = 0;
        StringBuilder string = new StringBuilder();
        
        while (times > i) {
            string.append(thing);
            i++;
        }
        return string.toString();
    }
    
    /**
     * Prints character X times, uses the generateRepeatingString method internally.
     * @param times How many times to print the character.
     * @param thing The character to repeat 
     * @see com.reliablerabbit.prettyprint.PrettyPrint#generateRepeatingString(int, char) 
     */
    public void printTimes(int times, char thing) {
        outputStream.print(generateRepeatingString(times, thing));
    }

    /**
     * Shorthand for printing to the stream
     * @param string The string to output 
     * @see java.io.PrintStream#print(String)
     */
    public void print(String string) {
        outputStream.print(string);
    }

    /**
     * Shorthand for printing to the stream and adding a new line
     * @param string The string to output followed by a new line
     * @see java.io.PrintStream#println(String)
     */
    public void println(String string) {
        outputStream.println(string);
    }

    /**
     * Uses println() to create a new line
     * @see java.io.PrintStream#println()
     */
    public void newLine() {
        outputStream.println();
    }
    
    /**
     * Allows developers to check the output stream
     * @return The current stream associated to the PrettyPrint object
     */
    public PrintStream getOutputStream() {
        return outputStream;
    }
    
    /**
     * Set the block padding, the space between the text and the border
     * @param ideal The positive integer of spaces
     * @return true if the amount was set, false if the number was negative
     */
    public boolean setBlockPadding(int ideal) {
        if(0 > ideal){
            return false;
        } else {
            blockPadding = ideal;
            return true;
        }
    }
}
