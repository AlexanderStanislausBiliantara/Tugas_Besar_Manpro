package com.example.manpro.Unit;

import java.util.Locale;
import java.text.NumberFormat;

import lombok.Data;

@Data
public class Unit {
    private String kodeUnit;
    private String tipe;
    private String noUnit;
    private boolean status;
    private double tarif;
    private String nikAgen;
    private String noLantai;
    private String namaTower;

    public Unit(String kodeUnit, String tipe, String noUnit, boolean status, double tarif, String nikAgen,
            String noLantai, String namaTower) {
        this.kodeUnit = kodeUnit;
        this.tipe = tipe;
        this.noUnit = noUnit;
        this.status = status;
        this.tarif = tarif;
        this.nikAgen = nikAgen;
        this.noLantai = noLantai;
        this.namaTower = namaTower;
        transformPrice();
    }

    private String priceString;

    public void transformPrice(){
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
        currencyFormat.setMaximumFractionDigits(0); // Remove decimal places
        this.priceString = currencyFormat.format(tarif);
    }

    
}
