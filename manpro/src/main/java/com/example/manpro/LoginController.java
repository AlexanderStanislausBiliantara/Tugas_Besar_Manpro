package com.example.manpro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.manpro.Agen.AgenService;
import com.example.manpro.Pelanggan.PelangganService;

@Controller
public class LoginController {
    
    @Autowired
    private AgenService agenService;

    @Autowired
    private PelangganService pelangganService;

    @GetMapping("/agen/login")
    public String indexAgen() {
        return "agen/AgenLogin";
    }

    @PostMapping("agenLogin")
    public String loginAgen(@RequestParam String nikAgen) {
        try {
            if(agenService.login(nikAgen)!=null) {
                return "agen/HomePageLogin";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "agen/AgenLogin";
        }

        return "agen/AgenLogin";
    }

    @GetMapping("/agen/agen/login")
    public String indexLogin() {
        return "templates/agen/HomePageLogin";
    }

    @GetMapping("/pelanggan/login_page.html")
    public String indexPelanggan() {
        return "pelanggan/login_page";
    }

    @PostMapping("login")
    public String login(@RequestParam String email, @RequestParam String pass) {
        if(pelangganService.login(email, pass)!=null) {
            return "pelanggan/index";
        }
        return "pelanggan/login_page";
    }
}
