package com.example.demospringboot.repository;

import com.example.demospringboot.entity.PembayaranKartu;
import org.springframework.stereotype.Repository;

@Repository
public class PembayaranKartuRepository {

    private PembayaranKartu metode;

    public void setNomorKartu(String nomor) {
        metode = new PembayaranKartu(nomor);
    }

    public PembayaranKartu getMetode() {
        return metode;
    }
}
