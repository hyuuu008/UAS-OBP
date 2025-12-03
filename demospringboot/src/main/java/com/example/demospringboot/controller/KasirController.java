
package com.example.demospringboot.controller;

import com.example.demospringboot.service.PesananService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class KasirController {

    @Autowired
    private PesananService pesananService;

    @GetMapping("/kasir")
    public String kasirPage(Model model) {

        model.addAttribute("pesanan", pesananService.getPesanan());

        model.addAttribute("total", pesananService.getTotalHarga());

        return "kasir";
    }

    @PostMapping("/kasir/pembayaran")
    public String nextPembayaran() {
        return "redirect:/pembayaran";
    }
}
