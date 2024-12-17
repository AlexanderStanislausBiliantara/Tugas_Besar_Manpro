package com.example.manpro.Agen;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/agen")
@Controller
public class SewaController {

    private final JdbcRepositorySewaService service;

    public SewaController(JdbcRepositorySewaService service) {
        this.service = service;
    }

    @GetMapping("/checkin")
    public String check(){
        return "DaftarCheckInCheckOut";
    }

    @PostMapping("/checkin")
    public String cekincekout(@RequestParam String waktusewa, Model model){
        LocalDate date = LocalDate.parse(waktusewa);
        List<Sewa> checkInList = service.getCheckInByDate(date);

        model.addAttribute("checkInList", checkInList);
        model.addAttribute("selectedDate", date);
        return "DaftarCheckInCheckOut"; // Nama file HTML
    }
       
}
