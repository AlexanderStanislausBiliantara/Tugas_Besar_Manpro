package com.example.manpro.Pelanggan;

import lombok.Data;

@Data
public class Pelanggan {
    private String email;
    private String pass;
    private String noHp;
    private String namaPel;

    public Pelanggan(String email, String pass, String noHp, String namaPel) {
        this.email = email;
        this.pass = pass;
        this.noHp = noHp;
        this.namaPel = namaPel;
    }

    
}


