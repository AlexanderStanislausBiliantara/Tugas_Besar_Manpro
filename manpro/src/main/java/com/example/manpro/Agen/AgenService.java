package com.example.manpro.Agen;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AgenService {

    @Autowired
    private AgenRepository agenRepository;

    public Agen login(String nikAgen) {
        Optional<Agen> optional = agenRepository.findByNikAgen(nikAgen);
        Agen agen = optional.get();

        try {
            if(optional.isPresent()) {
                return agen;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return null;
    }
    
}
