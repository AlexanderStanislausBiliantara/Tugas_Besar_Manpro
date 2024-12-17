package com.example.manpro.Agen;

import java.time.LocalDate;
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

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping ("/agen")
public class AgenController {

    @Autowired
    private AgenRepository repo;
    private int addedUnitCounter = 0;

    @Autowired
    AgenService agenService;
    private JdbcRepositorySewaService repository;

    @GetMapping("/")
    public String agen(){
        return "agen/HomePageAgen";
    }

    @GetMapping("/unitDipesan")
    public String unitDipesan(Model model, HttpSession session){
        String nikagen = (String) session.getAttribute("nikagen");
        model.addAttribute("namaagen", agenService.login(nikagen).getNamaAgen());
        return "agen/DaftarUnitDipesan";
    }

    @GetMapping("/daftarCheckinCheckout")
    public String daftarCheckinCheckout(Model model, HttpSession session){
        String nikagen = (String) session.getAttribute("nikagen");
        model.addAttribute("namaagen", agenService.login(nikagen).getNamaAgen());
        return "agen/DaftarCheckInOut";
    }
  
    @GetMapping("/cariKelolaUnit")
    public String agenSearchUnit(Model model, HttpSession session) {
        String nikagen = (String) session.getAttribute("nikagen");
        model.addAttribute("namaagen", agenService.login(nikagen).getNamaAgen());
        return "agen/cariUntukKelolaUnit";
    }

    @GetMapping("/checkin")
    public String check(){
        return "agen/DaftarCheckInOut";
    }

    @PostMapping("/checkin")
    public String cekincekout(@RequestParam String waktusewa, Model model){
        LocalDate date = LocalDate.parse(waktusewa);
        List<Sewa> checkInList = repository.getCheckInByDate(date);
        List<Sewa> checkOutList = repository.getCheckOutByDate(date);

        model.addAttribute("checkin", checkInList);
        model.addAttribute("checkout", checkOutList);
        return "agen/DaftarCheckInOut";
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
