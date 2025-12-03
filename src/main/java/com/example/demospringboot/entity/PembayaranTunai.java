package com.example.demospringboot.entity;

public class PembayaranTunai implements MetodePembayaran {

    @Override
    public void bayar(double jumlah) {
        // nanti diisi di service/controller
    }

    @Override
    public String getTipe() {
        return "Tunai";
    }
}
