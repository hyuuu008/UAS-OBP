package com.example.demospringboot.repository;

import com.example.demospringboot.entity.PembayaranTunai;
import org.springframework.stereotype.Repository;

@Repository
public class PembayaranTunaiRepository {

    private PembayaranTunai metode = new PembayaranTunai();

    public PembayaranTunai getMetode() {
        return metode;
    }
}
