package com.example.manpro.Pelanggan;

import java.util.List;

import com.example.manpro.Unit.Unit;

public interface PelangganRepository {
    List<Unit> findUnitByKode(String kodeUnit);
    void sewaApartemen(String kodeUnit);
}
