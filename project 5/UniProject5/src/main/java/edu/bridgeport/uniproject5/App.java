package edu.bridgeport.uniproject5;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cur;
        String classification;
        
        System.out.println("Please enter some integers:");

        while (in.hasNextInt()) {
            cur = in.nextInt();
            classification = classifyValue(cur);

            // made it blue text to separate from user input
            System.out.println("\033[1;34m" + cur + " is " + classification + "\033[0m");
        }
    }

    private static String classifyValue(int cur) {
        String temp = "";

        if (cur == 0) {
            temp += "zero, ";
        } else if (cur > 0) {
            temp += "positive, ";
        } else {
            temp += "negative, ";
        }

        if (10 > cur && cur > -10 && cur != 0) {
            temp += "single digit, ";
        }

        if (cur > 100) {
            temp += "greater than 100, ";
        } else if (-100 > cur) {
            temp += "less than -100, ";
        }

        return temp.substring(0, temp.length() - 2);
    }
}
