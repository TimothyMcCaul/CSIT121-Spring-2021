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
import java.util.Scanner;

/**
 *
 * @author Timothy McCaul
 */
public class Lab02Task1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AlarmManagement am = new AlarmManagement();
        am.addAlarmFromView();
        am.displayAlarmFromView();
    }
    
}

class AlarmView {
    public AlarmView() {}
    
    public String[] userCreateAnAlarm() {
        System.out.println("Please input an alarm in the format name,hour,minute:");
        Scanner input = new Scanner(System.in);
        return input.nextLine().split(",");
    }
    
    public int getAlarmIndex() {
        System.out.println("Please enter the index of the alarm you wish to see:");
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }
    
    public void displayAlarm(String display) {
        System.out.println(display);
    }
}

class AlarmManagement {
    private ArrayList<Alarm> alarms;
    private AlarmView view;

    public AlarmManagement() {
        alarms = new ArrayList<Alarm>();
        view = new AlarmView();
    }
    
    public void addAlarm(Alarm alarm) {
        if(!alarms.contains(alarm))
            alarms.add(alarm);
    }
    
    public Alarm getAlarmAt(int index) {
        if(index >= 0 && index < alarms.size())
            return alarms.get(index);
        else
            return null;
    }
    
    public void addAlarmFromView() {
        String[] userinput = view.userCreateAnAlarm();
        
        // Note: This code is very fragile and expects valid user input, more on this when we get to exception handling.
        addAlarm(new Alarm(userinput[0], Integer.parseInt(userinput[1]), Integer.parseInt(userinput[2])));
    }
    
    public void displayAlarmFromView() {
        int index = view.getAlarmIndex();
        Alarm alarm = getAlarmAt(index);
        view.displayAlarm(alarm.toString());
    }
}

class Alarm {
    private String alarmName;
    private int hour, minute;

    public Alarm(String alarmName, int hour, int minute) {
        this.alarmName = alarmName;
        
        if(hour >= 0 && hour < 24)
            this.hour = hour;
        
        if(minute >= 0 && minute < 60)
            this.minute = minute;
    }

    public Alarm(int hour, int minute) {
        this("", hour, minute);
    }

    public String getAlarmName() {
        return alarmName;
    }

    public void setAlarmName(String alarmName) {
        this.alarmName = alarmName;
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
    
    public String toString() {
        // Takeaway: String formatting is an important way to manipulate output
        return "Alarm: " + alarmName + " Time: " + String.format("%02d", hour) + ":" + String.format("%02d", minute);
    }
}
