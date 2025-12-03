package com.example.demospringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletRequest;

import com.example.demospringboot.entity.User;
import com.example.demospringboot.repository.UserRepository;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String homePage() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/validateLogin")
    public String validateLogin(HttpServletRequest request) {

        String kode = request.getParameter("kode");
        String password = request.getParameter("password");

        User user = userRepository.findByKodeAndPassword(kode, password);

        if (user != null) {
            request.getSession().setAttribute("logged", true);
            request.getSession().setAttribute("user", user);
            return "redirect:/menu";
        }

        return "redirect:/login?error=true";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/login";
    }
}
