package com.example.demospringboot.service;

import com.example.demospringboot.entity.Kasir;
import com.example.demospringboot.repository.KasirRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KasirService {

    @Autowired
    private KasirRepository kasirRepository;

    public Kasir getKasir() {
        return kasirRepository.getKasir();
    }

    public void setPilihan(String pilihan) {
        kasirRepository.setPilihan(pilihan);
    }
}
