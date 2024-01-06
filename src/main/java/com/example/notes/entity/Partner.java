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
@Table(name = "partner")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Partner {
    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "partner_id")
    private int partnerId;

    @Column(name = "partner_text", columnDefinition = "TEXT")
    private String partnerText;

    @Column(name = "how_paw", columnDefinition = "INT")
    private String howPaw; 
}
