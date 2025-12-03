package com.example.demospringboot.controller;

import com.example.demospringboot.entity.Pesanan;
import com.example.demospringboot.service.PembayaranKartuService;
import com.example.demospringboot.service.PembayaranTunaiService;
import com.example.demospringboot.service.PesananService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StrukController {

    @Autowired
    private PesananService pesananService;

    @Autowired
    private PembayaranTunaiService pembayaranTunaiService;

    @Autowired
    private PembayaranKartuService pembayaranKartuService;

    @GetMapping("/struk")
    public String tampilkanStruk(Model model) {

        Pesanan p = pesananService.getPesanan();

        // FIX: hanya redirect kalau pesanan null
        if (p == null) {
            return "redirect:/pesanan";
        }

        model.addAttribute("items", p.getItems());
        model.addAttribute("total", p.getTotalHarga());
        model.addAttribute("nomorMeja", p.getNomorMeja());
        model.addAttribute("tipePesanan", p.getTipePesanan());

        // Cek metode pembayaran
        String metode = "Tunai";
        if (pembayaranKartuService.getNomorKartu() != null) {
            metode = "Kartu Kredit";
        }

        model.addAttribute("metode", metode);

        return "struk";
    }
}