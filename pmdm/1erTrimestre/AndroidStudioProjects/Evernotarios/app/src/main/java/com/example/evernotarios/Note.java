package com.example.evernotarios;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class Note implements Serializable {

    String title;
    String msg;
    Calendar date;

    public Note(String title, String msg, Calendar date) {
        this.title = title;
        this.msg = msg;
        this.date = date;
    }

    @Override
    public String toString() {
        return title + "\n\t" + msg + "\n\t" + date.get(Calendar.DAY_OF_MONTH) + "/" +
                date.get(Calendar.MONTH) +1 + "/" + date.get(Calendar.YEAR) + "\n\n";
    }
}
