
package com.example.demospringboot.entity;

public class CartItem {
    private Integer id;
    private String nama;
    private double harga;
    private Integer qty = 1;

    public CartItem() {}
    public CartItem(Integer id, String nama, double harga, Integer qty) {
        this.id = id; this.nama = nama; this.harga = harga; this.qty = qty;
    }

  
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }
    public double getHarga() { return harga; }
    public void setHarga(double harga) { this.harga = harga; }
    public Integer getQty() { return qty; }
    public void setQty(Integer qty) { this.qty = qty; }
}   