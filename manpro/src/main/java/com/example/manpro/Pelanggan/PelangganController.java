package com.example.manpro.Pelanggan;
// import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;

// import jakarta.validation.Valid;

@RequestMapping("/pelanggan")
@Controller
public class PelangganController {
    
    @GetMapping("/")
    public String pelanggan(){
        return "pelanggan/index";
    }

    @GetMapping("/login")
    public String login(){
        return "pelanggan/login_page";
    }
}
