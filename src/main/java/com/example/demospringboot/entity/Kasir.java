package com.example.demospringboot.entity;

import java.util.List;

public class Kasir {

    private String nama;
    private String pilihan; // dinein / takeaway
    private List<MenuItem> daftarMenu;

    public Kasir(String nama) {
        this.nama = nama;
    }

    public Kasir(String nama, String pilihan) {
        this.nama = nama;
        this.pilihan = pilihan;
    }

    public String getNama() {
        return nama;
    }

    public String getPilihan() {
        return pilihan;
    }

    public void setPilihan(String pilihan) {
        this.pilihan = pilihan;
    }

    public void tampilkanMenuMakanan() {}

    public void tampilkanMenuMinuman() {}

    public void simpanStrukFile(Pesanan pesanan, MetodePembayaran metode) {}

    public void prosesPembayaran(Pesanan pesanan, MetodePembayaran metodePembayaran) {}
}
