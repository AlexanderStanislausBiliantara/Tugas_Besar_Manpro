package com.example.manpro.Pelanggan;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

@Controller
@RequestMapping ("/pelanggan")
public class PelangganController {

    @Autowired
    private PelangganService pelangganService;
    
    @GetMapping("/")
    public String pelanggan(){
        return "pelanggan/index";
    }

    @GetMapping("/daftar.html")
    public String daftarPelanggan() {
        return "pelanggan/daftar";
    }

    @PostMapping("daftar")
    public String addPelanggan(@Valid Pelanggan pelanggan) {
        boolean check = pelangganService.register(pelanggan);

        if(check==false) {
            return "pelanggan/daftar";
        }

        return "pelanggan/index";
    }

    @GetMapping("/mencariApartemen.html")
    public String indexCariUnit() {
        return "pelanggan/mencariApartemen";
    }
}
