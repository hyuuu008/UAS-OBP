package com.example.demospringboot.controller;

import com.example.demospringboot.entity.Makanan;
import com.example.demospringboot.entity.Minuman;
import com.example.demospringboot.entity.Pesanan;
import com.example.demospringboot.service.MakananService;
import com.example.demospringboot.service.MinumanService;
import com.example.demospringboot.service.PesananService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PesananController {

    
    @Autowired
    private MakananService makananService;

    @Autowired
    private MinumanService minumanService;

    @Autowired
    private PesananService pesananService;

    @GetMapping("/pesanan") 
    public String pesananPage(Model model) {
        model.addAttribute("makananList", makananService.getAll());
        model.addAttribute("minumanList", minumanService.getAll());
        model.addAttribute("pesanan", pesananService.getPesanan());
        return "pesanan";
    }

    @PostMapping("/pesanan/addMakanan")
    public String tambahMakanan(@RequestParam("idMakanan") Long idMakanan) {
        Makanan m = makananService.getById(idMakanan);
        if (m != null) {
        pesananService.addItem(m);
        }
        return "redirect:/pesanan";
    }

    @PostMapping("/pesanan/addMinuman")
    public String tambahMinuman(@RequestParam("idMinuman") Long idMinuman) {
        Minuman m = minumanService.getById(idMinuman);
        if (m != null) {
        pesananService.addItem(m);
        }
        return "redirect:/pesanan";
    }

    @PostMapping("/pesanan/next")
    public String nextKasir() {
        return "redirect:/kasir";
    }

}
