package com.example.evernotarios;

import java.io.Serializable;
import java.util.ArrayList;

public class NoteBook implements Serializable {
    ArrayList<Note> notebookList = new ArrayList<>();


    public void addNote(Note note){
        notebookList.add(note);
    }

    @Override
    public String toString() {

        String allNotes = "";

        for (Note note:notebookList) {
            allNotes += note.toString();

        }

        return allNotes;
    }
}
