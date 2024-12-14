package com.example.manpro.Agen;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.manpro.Unit.Unit;

@Controller
@RequestMapping ("/agen")
public class AgenController {

    @Autowired
    private AgenRepository repo;
    private int addedUnitCounter = 0;

    @GetMapping("/")
    public String agen(){
        return "agen/HomePageAgen";
    }

    @GetMapping("/unitDipesan")
    public String unitDipesan(){
        return "agen/DaftarUnitDipesan";
    }

    @GetMapping("/daftarCheckinCheckout")
    public String daftarCheckinCheckout(){
        return "agen/DaftarCheckInOut";
    }

    @GetMapping("/cariKelolaUnit")
    public String agenSearchUnit() {
        return "agen/cariUntukKelolaUnit";
    }

    @GetMapping("/addUnit")
    public String showForm(Model model) {
        model.addAttribute("units", repo.showAllAddedUnits(addedUnitCounter));
        return "agen/MenambahApartemen";
    }

    @GetMapping("/search")
    public String showSearchedUnits(Model model, @RequestParam String namaTower, @RequestParam String noLantai, @RequestParam String tipe) {
        if(Integer.parseInt(noLantai)<10){
            noLantai = "0".concat(noLantai);
        }
        model.addAttribute("managing_units", repo.findUnitByQuery(namaTower, noLantai, tipe));
        return "agen/KelolaUnit";
    }

    @GetMapping("/formKelolaUnit")
    public String formKelolaUnit(@RequestParam("kodeUnit") String kodeUnit, Model model) {
        Optional<Unit> currUnit = this.repo.findUnitByKode(kodeUnit);
        model.addAttribute("unit", currUnit.get());
        return "agen/FormKelolaUnit";
    }

    @PostMapping("/add")
    public String addUnitController(@RequestParam String namaTower, @RequestParam String noLantai, @RequestParam String noUnit, @RequestParam String tipe, @RequestParam double tarif) {
        String kodeUnit = namaTower+noLantai+noUnit;
        this.repo.addUnit(kodeUnit, tipe, noUnit, true, tarif, "9876543210987654", noLantai, namaTower);
        addedUnitCounter++;

        if(addedUnitCounter > 10) {
            addedUnitCounter = 0;
        }
        
        return "redirect:/agen/addUnit";
    }

    @PostMapping("/save-unit")
    public String updateUnit(@RequestParam String kodeUnit, @RequestParam String jenis, @RequestParam double harga, @RequestParam boolean status) {
        this.repo.updateUnit(kodeUnit, jenis, harga, status);
        return "redirect:/agen/cariKelolaUnit";
    }
}
