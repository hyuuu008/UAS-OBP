package com.example.demospringboot.entity;

import java.util.ArrayList;
import java.util.List;

public class Pesanan {

    private List<MenuItem> items = new ArrayList<>();
    private String status;
    private String tipePesanan; 
    private String nomorMeja;   

    public Pesanan() {
        this.status = "Belum Bayar";
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public void setItems(List<MenuItem> items) {
        this.items = items;
    }

    public void addItem(MenuItem item) {
        this.items.add(item);
    }

    public double getTotalHarga() {
        return items.stream().mapToDouble(MenuItem::getHarga).sum();
    }

    public boolean getEmpty() {
        return items.isEmpty();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String s) {
        this.status = s;
    }

    public String getTipePesanan() {
        return tipePesanan;
    }

    public void setTipePesanan(String tipePesanan) {
        this.tipePesanan = tipePesanan;
    }

    public String getNomorMeja() {
        return nomorMeja;
    }

    public void setNomorMeja(String nomorMeja) {
        this.nomorMeja = nomorMeja;
    }

    public void tampilkanKeranjang() {
    }
}