package com.example.reservasrestauranteapp;

import java.io.Serializable;
import java.sql.Time;
import java.text.DateFormat;
import java.util.Calendar;

public class Book implements Serializable {
    Calendar day;
    Calendar time;

    Integer guests;

    public Book(Calendar day, Calendar time, Integer guests){
        this.day = day;
        this.time = time;
        this.guests = guests;
    }

    public String dayToString(Calendar day){
        String currentDateString = DateFormat.getDateInstance().format(day.getTime());
        return currentDateString;
    }

    public String timeToString(Calendar time){
        String currentTimeString = time.get(Calendar.HOUR_OF_DAY) + ":" + time.get(Calendar.MINUTE);
        return currentTimeString;
    }


    @Override
    public String toString() {
        return "Book{" +
                "day=" + dayToString(day) +
                ", time=" + timeToString(time) +
                ", guests=" + guests +
                '}';
    }
}
