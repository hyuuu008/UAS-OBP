package com.example.demospringboot.controller;

import com.example.demospringboot.entity.Makanan;
import com.example.demospringboot.repository.MakananRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/menu/makanan")  // prefix "/menu/makanan" agar sesuai HTML
public class MakananController {

    private final MakananRepository makananRepo;

    public MakananController(MakananRepository makananRepo) {
        this.makananRepo = makananRepo;
    }

    // ==================== TAMBAH MAKANAN ====================
    @PostMapping("/tambah")
    public String tambahMakanan(@ModelAttribute Makanan makanan) {
        makananRepo.save(makanan);
        return "redirect:/menu";  // redirect ke halaman menu utama
    }

    // ==================== FORM EDIT ====================
    @GetMapping("/edit/{id}")
    public String formEditMakanan(@PathVariable Long id, Model model) {
        Makanan makanan = makananRepo.findById(id).orElse(null);

        if (makanan == null) {
            return "redirect:/menu";  // jika id tidak ditemukan, kembali ke menu
        }

        model.addAttribute("makanan", makanan);
        return "edit_makanan";  // nama file HTML untuk form edit
    }

    // ==================== UPDATE ====================
    @PostMapping("/update")
    public String updateMakanan(@ModelAttribute Makanan makanan) {
        makananRepo.save(makanan);
        return "redirect:/menu";  // redirect ke halaman menu utama
    }

    // ==================== DELETE ====================
    @GetMapping("/delete/{id}")
    public String deleteMakanan(@PathVariable Long id) {
        makananRepo.deleteById(id);
        return "redirect:/menu";  // redirect ke halaman menu utama
    }

    // ==================== DAFTAR MAKANAN ====================
    @GetMapping
    public String tampilkanMakanan(Model model) {
        model.addAttribute("makananList", makananRepo.findAll());
        return "menu";  // halaman menu utama yang menampilkan daftar makanan dan minuman
    }
}
