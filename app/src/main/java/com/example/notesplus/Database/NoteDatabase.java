package com.example.notesplus.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.notesplus.DAO.NoteDao;
import com.example.notesplus.Entities.Notes;

@Database(entities = Notes.class, version = 1, exportSchema = false)
public  abstract class NoteDatabase  extends RoomDatabase {

    private static NoteDatabase noteDatabase;

    public static  synchronized  NoteDatabase getNoteDatabase(Context context){
        if(noteDatabase == null){
            noteDatabase = Room.databaseBuilder(
                    context,NoteDatabase.class,"note_db"
            ).build();
        }
        return noteDatabase;
    }

    public abstract NoteDao noteDao();

}
