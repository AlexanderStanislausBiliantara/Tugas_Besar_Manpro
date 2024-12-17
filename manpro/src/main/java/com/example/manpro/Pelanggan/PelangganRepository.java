package com.example.manpro.Pelanggan;


import java.util.List;

import com.example.manpro.Unit.Unit;

public interface PelangganRepository {
    List<Unit> findUnitByKode(String kodeUnit);
    int sewaApartemen(String kodeUnit);

import java.util.Optional;

public interface PelangganRepository {
    void save(Pelanggan pelanggan) throws Exception;
    Optional<Pelanggan> findByEmailPelanggan(String emailPelanggan);
    
}
