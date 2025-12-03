package com.example.demospringboot.service;

import com.example.demospringboot.entity.MenuItem;
import com.example.demospringboot.entity.Pesanan;
import org.springframework.stereotype.Service;

@Service
public class PesananService {

    private Pesanan pesanan = new Pesanan(); 
    public Pesanan getPesanan() {
        return pesanan;
    }

    public void addItem(MenuItem item) {
        pesanan.getItems().add(item);
    }

    public double getTotalHarga() {
        return pesanan.getTotalHarga();
    }

    public void clear() {
        pesanan = new Pesanan(); 
    }
}