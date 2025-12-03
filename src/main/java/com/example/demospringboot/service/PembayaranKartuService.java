package com.example.demospringboot.service;

import com.example.demospringboot.entity.PembayaranKartu;
import com.example.demospringboot.repository.PembayaranKartuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PembayaranKartuService {

    @Autowired
    private PembayaranKartuRepository pembayaranKartuRepository;

    public PembayaranKartu getMetode() {
        return pembayaranKartuRepository.getMetode();
    }

    public void setNomorKartu(String nomor) {
        pembayaranKartuRepository.setNomorKartu(nomor);
    }

    // FIX: Tambahkan getter untuk dicek di Struk
    public String getNomorKartu() {
        if (pembayaranKartuRepository.getMetode() != null) {
            return pembayaranKartuRepository.getMetode().getNomorKartu();
        }
        return null;
    }

    public void bayar(double jumlah) {
        if (pembayaranKartuRepository.getMetode() != null) {
            pembayaranKartuRepository.getMetode().bayar(jumlah);
        }
    }
}