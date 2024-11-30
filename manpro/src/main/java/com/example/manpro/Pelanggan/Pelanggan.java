package com.example.manpro.Pelanggan;

import lombok.Data;

@Data
public class Pelanggan {
    private String email;
    private String pass;
    private String noHp;
    private String alamatPel;
    private String namaPel;
    private int idKelurahan;

    public Pelanggan(String email, String pass, String noHp, String alamatPel, String namaPel, int idKelurahan) {
        this.email = email;
        this.pass = pass;
        this.noHp = noHp;
        this.alamatPel = alamatPel;
        this.namaPel = namaPel;
        this.idKelurahan = idKelurahan;
    }

    
}


