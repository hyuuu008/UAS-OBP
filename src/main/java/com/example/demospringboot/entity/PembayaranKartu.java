package com.example.demospringboot.entity;

public class PembayaranKartu implements MetodePembayaran {

    private String nomorKartu;

    public PembayaranKartu(String nomorKartu) {
        this.nomorKartu = nomorKartu;
    }

    // Tambahkan GETTER & SETTER
    public String getNomorKartu() {
        return nomorKartu;
    }

    public void setNomorKartu(String nomorKartu) {
        this.nomorKartu = nomorKartu;
    }

    @Override
    public void bayar(double jumlah) {
        // Implementasi pembayaran kartu nanti
    }

    @Override
    public String getTipe() {
        return "Kartu Kredit";
    }
}