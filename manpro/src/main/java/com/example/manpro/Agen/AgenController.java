package com.example.manpro.Agen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping ("/agen")
public class AgenController {

    @Autowired
    private AgenRepository repo;
    private int addedUnitCounter = 0;

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
        model.addAttribute("managing_units", repo.findUnitByQuery(namaTower, noLantai, tipe));
        return "agen/KelolaUnit";
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
}
