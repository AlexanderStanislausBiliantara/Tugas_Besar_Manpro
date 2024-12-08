package com.example.manpro.Agen;

import java.util.List;
import java.util.Optional;

import com.example.manpro.Unit.*;

public interface AgenRepository {
    void addUnit(String kodeUnit, String tipe, String noUnit, boolean status, double tarif, String nikAgen, String noLantai, String namaTower);
    List<Unit> showAllAddedUnits(int limit);
    Optional<Agen> findByNikAgen(String nikAgen);
}
