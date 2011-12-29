/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reliablerabbit.timeproject;

/**
 *
 * @author Mohammad Typaldos [mohammad at reliablerabbit.com]
 */
public class Time implements TimeSkeleton {
    private static final String numberFormat = "%02d";
    public  long seconds;
    private long cachedSeconds, cachedMinutes, cachedHours, cachedDays;
    
    public Time()               { seconds = 0;            }
    public Time(long newSeconds){ setSeconds(newSeconds); }
    
    public void setTime(long newSeconds)   { setSeconds(newSeconds); }
    public void setSeconds(long newSeconds){
        seconds = newSeconds;
    }
    
    public Time timeBetween(TimeSkeleton otherTime){
        return timeBetween(otherTime.getSeconds(true));
    }
    
    public Time timeBetween(long otherSeconds){
        return new Time(
                        Math.abs(
                            this.seconds - otherSeconds
                        ));
    }
    
    public long getMinutes(){
        long   remainingSeconds = seconds % 3600;
        return remainingSeconds/60;
    }
    
    public long getSeconds(boolean skipMod){
      if(skipMod){
          return seconds;
      } else {
          return getSeconds();
      }  
    }
    
    public long getSeconds(){ return seconds % 60;       }
    public long getHours()  { return seconds/(60*60);    }
    public long getDays()   { return seconds/(60*60*24); }
     
    @Override
    public String toString(){
        // uses getters because of "DRY"
        return getHours() + ":" +
               String.format(numberFormat, getMinutes()) +":" +
               String.format(numberFormat, getSeconds());
    }
}
