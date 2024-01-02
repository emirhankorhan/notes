package com.example.notes.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "notes")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Note {
    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notes_id")
    private int noteId;

    @Column(name = "user_id", columnDefinition = "INT")
    private int userId;

    @Column(name = "input_text", columnDefinition = "TEXT")
    private String text;

    @Column(name = "input_date", columnDefinition = "VARCHAR(50)")
    private String date; 

    @Column(name = "is_completed", columnDefinition = "VARCHAR(50)")
    private String isCompleted; 


}
