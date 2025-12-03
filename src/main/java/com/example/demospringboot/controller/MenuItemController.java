package com.example.demospringboot.controller;

import com.example.demospringboot.repository.MakananRepository;
import com.example.demospringboot.repository.MinumanRepository;
import com.example.demospringboot.service.MenuItemService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/menu")
public class MenuItemController {

    @Autowired
    private MenuItemService menuItemService;

    @Autowired
    private MakananRepository makananRepo;

    @Autowired
    private MinumanRepository minumanRepo;


    // ===================== HALAMAN MENU ======================
    @GetMapping
    public String halamanMenu(HttpServletRequest request, Model model) {

        // CEK LOGIN
        Boolean logged = (Boolean) request.getSession().getAttribute("logged");
        if (logged == null || !logged) {
            return "redirect:/login";
        }

        // KIRIM DATA KE HTML
        model.addAttribute("makananList", makananRepo.findAll());
        model.addAttribute("minumanList", minumanRepo.findAll());

        return "menu";
    }


    // ===================== TAMBAH MAKANAN ======================
    @PostMapping("/tambah-makanan")
    public String tambahMakanan(@RequestParam String nama,
                                @RequestParam double harga,
                                @RequestParam(required = false, defaultValue = "0") int pedasLevel,
                                HttpServletRequest request) {

        Boolean logged = (Boolean) request.getSession().getAttribute("logged");
        if (logged == null || !logged) {
            return "redirect:/login";
        }

        menuItemService.addMakanan(nama, harga, pedasLevel);
        return "redirect:/menu";
    }


    // ===================== TAMBAH MINUMAN ======================
    @PostMapping("/tambah-minuman")
    public String tambahMinuman(@RequestParam String nama,
                                @RequestParam double harga,
                                @RequestParam(required = false, defaultValue = "") String ukuran,
                                HttpServletRequest request) {

        Boolean logged = (Boolean) request.getSession().getAttribute("logged");
        if (logged == null || !logged) {
            return "redirect:/login";
        }

        menuItemService.addMinuman(nama, harga, ukuran);
        return "redirect:/menu";
    }

}
