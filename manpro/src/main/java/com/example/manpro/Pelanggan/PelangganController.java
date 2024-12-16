package com.example.manpro.Pelanggan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

@RequestMapping("/pelanggan")
@Controller
public class PelangganController {
    
    @Autowired
    private PelangganService pelangganService;

    @GetMapping("/register")
    public String registerPelanggan(Pelanggan pelanggan) {
        return "daftar";
    }

    @GetMapping("/login")
    public String index() {
        return "KelolaUnit";
    }

    // @PostMapping("daftar")
    // public String addPelanggan(@Valid Pelanggan pelanggan) {

    // }
}
