package com.example.demospringboot.entity;

public class PembayaranTunai implements MetodePembayaran {

    @Override
    public void bayar(double jumlah) {
    
    }

    @Override
    public String getTipe() {
        return "Tunai";
    }
}
