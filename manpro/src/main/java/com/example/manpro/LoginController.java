package com.example.manpro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.manpro.Agen.AgenService;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
    
    @Autowired
    private AgenService agenService;

    @GetMapping("/agen/login")
    public String indexAgen(HttpSession session) {
        String nikAgen = (String) session.getAttribute("nikAgen");
        if(nikAgen==null) {
            return "AgenLogin";
        }
        return "HomePageAgen";
    }

    @PostMapping("agen/login")
    public String loginAgen(@RequestParam String nikAgen, HttpSession session) {
        try {
            if(agenService.login(nikAgen)!=null) {
                session.setAttribute("nikAgen", nikAgen);
                return "HomePageLogin";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "AgenLogin";
        }

        return "AgenLogin";
    }
}
