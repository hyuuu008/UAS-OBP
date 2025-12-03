package com.example.demospringboot.service;

import com.example.demospringboot.entity.PembayaranTunai;
import com.example.demospringboot.repository.PembayaranTunaiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PembayaranTunaiService {

    @Autowired
    private PembayaranTunaiRepository pembayaranTunaiRepository;

    public PembayaranTunai getMetode() {
        return pembayaranTunaiRepository.getMetode();
    }

    public void bayar(double jumlah) {
        pembayaranTunaiRepository.getMetode().bayar(jumlah);
    }
}
