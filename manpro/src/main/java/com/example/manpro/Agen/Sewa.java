package com.example.manpro.Agen;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Sewa {
    private String kodeUnit;
    private Date waktusewa;
    private Date waktuselesai;
}
