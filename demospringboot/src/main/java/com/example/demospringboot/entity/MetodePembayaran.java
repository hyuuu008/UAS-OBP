package com.example.demospringboot.entity;

public interface MetodePembayaran {
    void bayar(double jumlah);
    String getTipe();
}
