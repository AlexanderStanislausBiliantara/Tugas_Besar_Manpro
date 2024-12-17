package com.example.manpro.Pelanggan;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.manpro.Unit.Unit;

import jakarta.validation.Valid;


@Controller
@RequestMapping ("/pelanggan")
public class PelangganController {

    @Autowired

    private PelangganRepository repoPelanggan;

    private PelangganService pelangganService;

    @Autowired
    private PelangganRepository repo;
    
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

    @PostMapping("mencariapartemen")
    public String cariUnit(@RequestParam String tipe, @RequestParam String checkin, @RequestParam String checkout, @RequestParam String hargaterendah, @RequestParam String hargatertinggi, Model model) {
        List<Unit> findUnit = this.repo.findUnit(tipe, checkin, checkout, hargaterendah, hargatertinggi);
        model.addAttribute("units", findUnit);
        return "redirect:/mencariApartemen";
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

    @GetMapping("/sewa")
    public String sewa(){
        repoPelanggan.sewaApartemen(kodeUnit);
        return "pelanggan/mencariApartemen";
    }

}
