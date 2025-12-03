package com.example.demospringboot.controller;

import com.example.demospringboot.entity.Pesanan;
import com.example.demospringboot.service.PembayaranKartuService;
import com.example.demospringboot.service.PembayaranTunaiService;
import com.example.demospringboot.service.PesananService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PembayaranController {

    @Autowired
    private PembayaranTunaiService pembayaranTunaiService;

    @Autowired
    private PembayaranKartuService pembayaranKartuService;

    @Autowired
    private PesananService pesananService;

    @GetMapping("/pembayaran")
    public String pilihPembayaran() {
        return "pembayaran"; 
    }

    @GetMapping("/pembayaran/tunai")
    public String tunaiPage() {
        return "pembayarantunai";
    }

    @PostMapping("/pembayaran/tunai/submit")
    public String bayarTunai() {

        Pesanan p = (Pesanan) pesananService.getPesanan();
        if (p == null || p.getItems().isEmpty()) {
            return "redirect:/pesanan"; // Kalau keranjang kosong
        }

        double total = p.getTotalHarga();
        pembayaranTunaiService.bayar(total);

        return "redirect:/struk";
    }

    @GetMapping("/pembayaran/kartu")
    public String kartuPage() {
        return "pembayarankartu";
    }

    @PostMapping("/pembayaran/kartu/submit")
    public String bayarKartu(@RequestParam String nomorKartu) {

        Pesanan p = (Pesanan) pesananService.getPesanan();
        if (p == null || p.getItems().isEmpty()) {
            return "redirect:/pesanan";
        }

        pembayaranKartuService.setNomorKartu(nomorKartu);

        double total = p.getTotalHarga();
        pembayaranKartuService.bayar(total);

        return "redirect:/struk";
    }
}