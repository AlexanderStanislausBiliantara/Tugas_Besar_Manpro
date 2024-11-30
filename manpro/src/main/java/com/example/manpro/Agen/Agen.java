package com.example.manpro.Agen;

import lombok.Data;

@Data
public class Agen {
    private String nikAgen;
    private String alamatA;
    private String noHp;
    private String namaAgen;

    public Agen(String nikAgen, String alamatA, String noHp, String namaAgen) {
        this.nikAgen = nikAgen;
        this.alamatA = alamatA;
        this.noHp = noHp;
        this.namaAgen = namaAgen;
    }

    
}
