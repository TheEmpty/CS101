package com.reliablerabbit.timeproject;

/**
 *
 * @author Mohammad Typaldos [mohammad at reliablerabbit.com]
 */
public interface TimeSkeleton {
    // util
    @Override
    public String toString();
    public TimeSkeleton timeBetween(TimeSkeleton time);
    public TimeSkeleton timeBetween(long time);
    // setters
    public void setSeconds(long seconds);
    public void setTime(long seconds);
    // getters
    public long getSeconds(boolean skipMod);
    public long getSeconds();
    public long getMinutes();
    public long getHours();
    public long getDays();
}
