package com.example.manpro.Pelanggan;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.manpro.Unit.Unit;


@Controller
@RequestMapping ("/pelanggan")
public class PelangganController {

    @Autowired
    private PelangganRepository repoPelanggan;
    
    @GetMapping("/")
    public String pelanggan(){
        return "pelanggan/index";
    }

    @GetMapping("/login")
    public String login(){
        return "pelanggan/login_page";
    }

    @GetMapping("/daftar")
    public String daftar(){
        return "pelanggan/daftar";
    }

    @GetMapping("/cariApartemen")
    public String cariApartemen(){
        return "pelanggan/mencariApartemen";
    }

    private String kodeUnit;

    @GetMapping("/sewaApartemen")
    public String sewaApartemen(@RequestParam String kodeUnit, Model model){
        List<Unit> unit = repoPelanggan.findUnitByKode(kodeUnit);
        this.kodeUnit = kodeUnit;

        model.addAttribute("unit", unit.get(0));

        return "pelanggan/sewaApartemen";
    }

    @PostMapping("/sewa")
    public String sewa(){
        repoPelanggan.sewaApartemen(kodeUnit);
        return "/";
    }

}
