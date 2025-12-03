package com.example.demospringboot.controller;

import com.example.demospringboot.entity.Makanan;
import com.example.demospringboot.repository.MakananRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/menu/makanan")  
public class MakananController {

    private final MakananRepository makananRepo;

    public MakananController(MakananRepository makananRepo) {
        this.makananRepo = makananRepo;
    }


    @PostMapping("/tambah")
    public String tambahMakanan(@ModelAttribute Makanan makanan) {
        makananRepo.save(makanan);
        return "redirect:/menu";  
    }


    @GetMapping("/edit/{id}")
    public String formEditMakanan(@PathVariable Long id, Model model) {
        Makanan makanan = makananRepo.findById(id).orElse(null);

        if (makanan == null) {
            return "redirect:/menu"; 
        }

        model.addAttribute("makanan", makanan);
        return "edit_makanan";  
    }

    @PostMapping("/update")
    public String updateMakanan(@ModelAttribute Makanan makanan) {
        makananRepo.save(makanan);
        return "redirect:/menu";  
    }

    @GetMapping("/delete/{id}")
    public String deleteMakanan(@PathVariable Long id) {
        makananRepo.deleteById(id);
        return "redirect:/menu";  
    }

    @GetMapping
    public String tampilkanMakanan(Model model) {
        model.addAttribute("makananList", makananRepo.findAll());
        return "menu";  
    }
}
