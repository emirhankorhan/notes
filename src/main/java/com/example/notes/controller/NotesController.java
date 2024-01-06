package com.example.notes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.notes.entity.Note;
import com.example.notes.services.NoteManager;



@RestController
@RequestMapping("/api/notes")
@CrossOrigin
public class NotesController {
    private final NoteManager noteService;

    public NotesController(@Qualifier("mysql") NoteManager noteService) {
        this.noteService = noteService;
    }

    @GetMapping
    public ResponseEntity<?> getAllNotes(@RequestParam int userId, @RequestParam List<String> isCompleted) {
        var notes = noteService.getAllNotes(userId, isCompleted);
        return new ResponseEntity<>(notes, HttpStatus.OK);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Note> getOneNote(@PathVariable(name = "id") int id) {
        var note = noteService.getOneNoteById(id);
        return ResponseEntity.ok(note);
    }

    @PostMapping
    public ResponseEntity<?> createOneNote(@RequestBody Note product) {
        noteService.createOneNote(product);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<?> updateOneNote(@PathVariable(name = "id", required = true) int id,
            @RequestBody Note note) {
        var state = note.getIsCompleted();
        noteService.updateOneNote(id, state);
        return ResponseEntity.ok()
        .body(note);   
    }

    @DeleteMapping(path = "{id}")
    @ResponseBody
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deleteOneNote(@PathVariable(name = "id", required = true) int id) {
        noteService.deleteOneNote(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    @ResponseBody
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deleteAllNotes() {
        noteService.deleteAllNotes(); // Tüm ögeleri silen metodu çağırın
        return ResponseEntity.noContent().build();
    }

    // @ExceptionHandler(NotFoundException.class)
    // @ResponseBody
    // public ResponseEntity<Object> handleException(NotFoundException ex,
    // WebRequest request) {

    // var errordetails = ErrorDetails
    // .builder()
    // .statusCode(404)
    // .message(ex.getMessage())
    // .path(request.getDescription(false))
    // .build();
    // return new ResponseEntity<>(errordetails, HttpStatus.NOT_FOUND);
    // }

}
