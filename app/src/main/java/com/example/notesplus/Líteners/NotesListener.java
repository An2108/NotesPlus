package com.example.notesplus.Líteners;

import com.example.notesplus.Entities.Notes;

public interface NotesListener {

    void onNoteClicked(Notes notes, int position);
}
