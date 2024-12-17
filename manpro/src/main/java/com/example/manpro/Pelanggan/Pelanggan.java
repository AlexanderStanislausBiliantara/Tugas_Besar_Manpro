package com.example.manpro.Pelanggan;

import lombok.Data;

@Data
public class Pelanggan {
    private String email;
    private String namapel;
    private String nohp;
    private String pass;
    
    public Pelanggan(String email, String namapel, String nohp, String pass) {
        this.email = email;
        this.namapel = namapel;
        this.nohp = nohp;
        this.pass = pass;
    }

}


