package com.example.demospringboot.controller;

import com.example.demospringboot.entity.Minuman;
import com.example.demospringboot.repository.MinumanRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/menu/minuman")
public class MinumanController {

    private final MinumanRepository repo;

    public MinumanController(MinumanRepository repo) {
        this.repo = repo;
    }

    // ==================== TAMBAH MINUMAN ====================
    @PostMapping("/tambah")
    public String tambahMinuman(@ModelAttribute Minuman minuman) {
        repo.save(minuman);
        return "redirect:/menu";
    }

    // ==================== FORM EDIT ====================
    @GetMapping("/edit/{id}")
    public String formEdit(@PathVariable Long id, Model model) {
        Minuman mn = repo.findById(id).orElse(null);

        if (mn == null) {
            return "redirect:/menu";
        }

        model.addAttribute("minuman", mn);
        return "edit_minuman";  // nama file HTML
    }

    // ==================== UPDATE ====================
    @PostMapping("/update")
    public String updateMinuman(@ModelAttribute Minuman minuman) {
        repo.save(minuman);
        return "redirect:/menu";
    }

    // ==================== DELETE ====================
    @GetMapping("/delete/{id}")
    public String deleteMinuman(@PathVariable Long id) {
        repo.deleteById(id);
        return "redirect:/menu";
    }
}
