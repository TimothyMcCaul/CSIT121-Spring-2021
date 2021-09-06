/*
 * Copyright (C) 2021 Timothy McCaul
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

import java.util.ArrayList;

/**
 *
 * @author Timothy McCaul
 */
public class Lab02Task2 {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ArrayList<Time> timeObjects = new ArrayList<Time>();
        
        Time basicTime = new Time(1, 2, 3);
        Alarm testAlarm = new Alarm("Testing", 4, 5);
        Timer testTimer = new Timer(4, 5, 6);
        
        timeObjects.add(basicTime);
        timeObjects.add(testAlarm);
        timeObjects.add(testTimer);
        
        for(Time t : timeObjects) {
            System.out.println(t);
        }
    }
}

class Time {
    private int hour, minute, second;
    
    // Takeaway: We can call the most parameterised constructor from the other constructors.
    public Time() {
        this(0, 0, 0);
    }
    
    public Time(int hour) {
        this(hour, 0, 0);
    }
    
    public Time(int hour, int minute) {
        this(hour, minute, 0);
        //System.out.println("Time with 2 ints finished consruction");
    }

    public Time(int hour, int minute, int second) {
        //System.out.println("Time(int hour, int minute, int second)) started consruction");

        // Takeaway: By having all of our validation logic in one location we don't need it in each constructor.
        // Note: We could also call the setters as they contain the validation logic as well and it would save more duplicate code.
        if (hour >= 0 && hour < 24)
            this.hour = hour;
        
        if (minute >= 0 && minute < 60)
            this.minute = minute;
        
        if (second >= 0 && second < 60)
            this.second = second;
        
        //System.out.println("Time(int hour, int minute, int second)) finished consruction");
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        if (hour >= 0 && hour < 24)
            this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        if(minute >= 0 && minute < 60)
            this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        if(second >= 0 && second < 60)
            this.second = second;
    }
    
    public String toString() {
        return "Time: " + String.format("%02d", hour) + ":" + String.format("%02d", minute) + ":" + String.format("%02d", second);
    }
}

class Alarm extends Time {
    private String name;
    
    public Alarm(String name, int hour, int minute) {
        super(hour, minute);
        this.name = name;
        //System.out.println("Alarm2(String name, int hour, int minute) finished consruction");
    }
    
    public Alarm(int hour, int minute) {
        this("", hour, minute);
        //System.out.println("Alarm2(int hour, int minute) finished consruction");
    }
    
    public String toString() {
        // Takeaway: You can call the base class methods by using super.methodName()
        //return "Alarm: " + name + " " + super.toString();
        return "Alarm: " + name + " " + String.format("%02d", super.getHour()) + ":" + String.format("%02d", super.getMinute());
    }
}

class Timer extends Time {
    
    public Timer(int hour, int minute, int second) {
        super(hour, minute, second);
    }
    
    public String toString() {
        return "Timer: " + String.format("%02d", super.getHour()) + ":" + String.format("%02d", super.getMinute()) + ":" + String.format("%02d", super.getSecond());
    }
    
    public void start() {
        System.out.println("Timer starts here");
    }
}
