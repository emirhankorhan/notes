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
@Table(name = "user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;

    @Column(name = "name", columnDefinition = "VARCHAR(50)")
    private String name;

    @Column(name = "surname", columnDefinition = "VARCHAR(50)")
    private String surname;

    @Column(name = "user_name", columnDefinition = "VARCHAR(50)")
    private String userName;

    @Column(name = "user_password", columnDefinition = "VARCHAR(255)")
    private String userPassword;

    @Column(name = "user_salt", columnDefinition = "VARCHAR(255)")
    private String userSalt;

    @Column(name = "user_paw", columnDefinition = "INT")
    private int userPaw = 0;
}

