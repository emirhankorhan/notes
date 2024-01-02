package com.example.notes.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.notes.entity.Note;
import java.util.List;


public interface NoteRepository extends JpaRepository<Note, Integer>{
 public List<Note> findByUserIdAndIsCompleted(int userId, String isCompleted);    
}
