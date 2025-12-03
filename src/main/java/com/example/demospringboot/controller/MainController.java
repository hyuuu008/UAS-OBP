package com.example.demospringboot.controller;

import com.example.demospringboot.service.KasirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    @Autowired
    private KasirService kasirService;

    @GetMapping("/pilihan")
    public String pilihanPage() {
        return "pilihan";
    }

    @PostMapping("/pilihan/submit")
    public String submitPilihan(@RequestParam String pilihan) {

        kasirService.setPilihan(pilihan);

        return "redirect:/pesanan";
    }
}
