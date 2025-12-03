package com.example.demospringboot.service;

import com.example.demospringboot.entity.Makanan;
import com.example.demospringboot.entity.Minuman;
import com.example.demospringboot.repository.MakananRepository;
import com.example.demospringboot.repository.MinumanRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuItemService {

    private final MakananRepository makananRepository;
    private final MinumanRepository minumanRepository;

    public MenuItemService(MakananRepository makananRepository,
                           MinumanRepository minumanRepository) {
        this.makananRepository = makananRepository;
        this.minumanRepository = minumanRepository;
    }

    /** 🔹 Ambil semua menu dari database */
    public List<Object> getAllMenu() {
        List<Object> menu = new ArrayList<>();
        menu.addAll(makananRepository.findAll());
        menu.addAll(minumanRepository.findAll());
        return menu;
    }

    /** 🔹 Tambah makanan (sudah pakai pedasLevel) */
    public void addMakanan(String nama, double harga, int pedasLevel) {
        Makanan m = new Makanan();
        m.setNama(nama);
        m.setHarga(harga);
        m.setPedasLevel(pedasLevel);
        makananRepository.save(m);
    }

    /** 🔹 Tambah minuman (sudah pakai ukuran) */
    public void addMinuman(String nama, double harga, String ukuran) {
        Minuman mn = new Minuman();
        mn.setNama(nama);
        mn.setHarga(harga);
        mn.setUkuran(ukuran);
        minumanRepository.save(mn);
    }

    /** 🔹 Hapus makanan */
    public void deleteMakanan(Long id) {
        makananRepository.deleteById(id);
    }

    /** 🔹 Hapus minuman */
    public void deleteMinuman(Long id) {
        minumanRepository.deleteById(id);
    }
}
