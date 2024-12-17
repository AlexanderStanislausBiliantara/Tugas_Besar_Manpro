package com.example.manpro.Pelanggan;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PelangganService {

    @Autowired
    private PelangganRepository pelangganRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean register(Pelanggan pelanggan) {
        pelanggan.setPass(passwordEncoder.encode(pelanggan.getPass()));
        try {
            pelangganRepository.save(pelanggan);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;

    }

    public Pelanggan login(String email, String password) {
        Optional<Pelanggan> optional = pelangganRepository.findByEmailPelanggan(email);
        Pelanggan pelanggan = optional.get();

        try {
            if(optional.isPresent()) {
                return pelanggan;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return null;
    }
    
}
