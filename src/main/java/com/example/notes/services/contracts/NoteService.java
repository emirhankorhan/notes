package com.example.notes.services.contracts;

import java.util.List;
import com.example.notes.entity.Note;

public interface NoteService {
    List<Note> getAllNotes(int userId, String isCompleted);
    Note getOneNoteById(int id);
    Note createOneNote(Note product);
    Note updateOneNote(int id, String state);
    void deleteOneNote(int id);
    void deleteAllNotes();
}
