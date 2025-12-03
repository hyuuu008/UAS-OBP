package com.example.demospringboot.entity;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nama;
    private double harga;

    public Long getId() { 
        return id; 
    }

    // FIX PALING PENTING
    public void setId(Long id) { 
        this.id = id; 
    }

    public String getNama() { 
        return nama; 
    }

    public void setNama(String nama) { 
        this.nama = nama; 
    }

    public double getHarga() { 
        return harga; 
    }

    public void setHarga(double harga) { 
        this.harga = harga; 
    }
}
