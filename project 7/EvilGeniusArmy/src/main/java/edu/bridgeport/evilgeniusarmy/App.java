package edu.bridgeport.evilgeniusarmy;

import java.util.Scanner;

/**
 * Contains the driver and any helpers the driver needs.
 * @author Mohammad Typaldos [mohammad at reliablerabbit.com]
 */
public class App 
{
    /**
     * No chance of the exception happening since it's initalized with a Scanner object.
     * @param args
     * @throws Exception The game doesn't have a scanner
     */
    public static void main( String[] args ) throws Exception
    {
        Scanner in = new Scanner(System.in);
        Game g = new Game(in);
        do {
            g.gameLoop();
            System.out.println("y + enter to play again");
        } while(playAgain(in));
    }
    
    /**
     * Used to eaisly determine when to exit or repeat.
     * @param in Scanner to read from
     */
    private static boolean playAgain(Scanner in){
        String next = in.nextLine().trim();
        System.out.println();
        return(next.toLowerCase().equals("y"));
    }
}
