package com.example.demospringboot.repository;

import com.example.demospringboot.entity.Kasir;
import org.springframework.stereotype.Repository;

@Repository
public class KasirRepository {

    private Kasir kasir = new Kasir("Admin");

    public Kasir getKasir() {
        return kasir;
    }

    public void setPilihan(String pilihan) {
        kasir.setPilihan(pilihan);
    }
}
