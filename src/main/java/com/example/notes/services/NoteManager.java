package com.example.notes.services;

import java.util.List;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.notes.entity.Note;
import com.example.notes.repos.NoteRepository;
import com.example.notes.services.contracts.NoteService;



@Service
@Repository("mysql")
public class NoteManager implements NoteService{

    private final NoteRepository noteRepository;

    public NoteManager(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public List<Note> getAllNotes(int userId, String isCompleted) {
        return noteRepository.findByUserIdAndIsCompleted(userId, isCompleted); 
    }

    @Override
public Note getOneNoteById(int id) {
    return noteRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Note not found without specific id"));
}


    @Override
    public Note createOneNote (Note product) {
        return noteRepository.save(product);
    }

    @Override
    public Note updateOneNote(int id, String state) {
        Note existingNote = noteRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Setting not found with id: " + id));

        existingNote.setIsCompleted(state);
        return noteRepository.save(existingNote);
    }

    @Override
    public void deleteOneNote(int id) {
        noteRepository.deleteById(id);
    }

    @Override
    public void deleteAllNotes(){
        noteRepository.deleteAll();
    }
    
}
