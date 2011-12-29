package com.reliablerabbit.timeproject;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Time time1 = new Time((60*60*40) + 67);
        Time time2 = new Time(25);
        Time time3 = time1.timeBetween(time2);
        
        spamTime(time1);
        System.out.println();
        spamTime(time2);
        System.out.println();
        spamTime(time3);
    }
    
    private static void spamTime(Time time){
        System.out.println("Days: " + time.getDays());
        System.out.println("Hours: " + time.getHours());
        System.out.println("Minutes: " + time.getMinutes());
        System.out.println("Seconds: " + time.getSeconds());
        System.out.println("To String: " + time.toString());
    }
}
