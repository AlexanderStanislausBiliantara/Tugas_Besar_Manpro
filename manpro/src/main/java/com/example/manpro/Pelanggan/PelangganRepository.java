package com.example.manpro.Pelanggan;

import java.util.Optional;

public interface PelangganRepository {
    void save(Pelanggan pelanggan) throws Exception;
    Optional<Pelanggan> findByEmailPelanggan(String emailPelanggan);
    
}
