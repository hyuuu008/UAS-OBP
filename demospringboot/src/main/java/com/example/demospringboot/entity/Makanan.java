package com.example.demospringboot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "makanan")
public class Makanan extends MenuItem {

    @Column(name = "pedas_level")
    private int pedasLevel;

    public int getPedasLevel() {
        return pedasLevel;
    }

    public void setPedasLevel(int pedasLevel) {
        this.pedasLevel = pedasLevel;
    }

    public String getInfoStruk() { 
        return getNama() + " (Pedas Lv." + pedasLevel + ") - Rp " + getHarga();
    }
}
