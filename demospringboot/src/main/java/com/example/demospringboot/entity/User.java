package com.example.demospringboot.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String kode;
    private String password;

    public User() {}

    public User(String kode, String password) {
        this.kode = kode;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getKode() {
        return kode;
    }

    public String getPassword() {
        return password;
    }
}
