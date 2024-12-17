package com.example.manpro.Pelanggan;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.manpro.Unit.Unit;

@Repository
public class JdbcRepositoryPelanggan implements PelangganRepository{


    @Autowired
    JdbcTemplate jdbcTemplate;

    private Unit mapRowToUnit(ResultSet resultSet, int rowNum) throws SQLException {
        return new Unit(
            resultSet.getString("kodeunit"),
            resultSet.getString("tipe"),
            resultSet.getString("nounit"),
            resultSet.getBoolean("status"),
            resultSet.getDouble("tarif"),
            resultSet.getString("nikagen"),
            resultSet.getString("nolantai"),
            resultSet.getString("namatower")
        );
    }

    @Override
    public List<Unit> findUnitByKode(String kodeUnit) {
        String sql = "SELECT * FROM Unit WHERE kodeUnit = ?";
        List<Unit> foundUnit = jdbcTemplate.query(sql, this::mapRowToUnit, kodeUnit);
        return foundUnit;
    }

    @Override
    public int sewaApartemen(String kodeUnit){
        List<Unit> unit = findUnitByKode(kodeUnit);
        Unit unitFinal = unit.get(0);

        String sql = "INSERT INTO sewa (waktusewa, waktuselesai, totalbiaya, email, kodeUnit)"+
        "VALUES('20241217', '20241225', ?, 'andi_pratama@gmail.com', ?)";
        return jdbcTemplate.query(sql, unitFinal.getTarif(), kodeUnit);
    }



    @Override
    public void save(Pelanggan pelanggan) throws Exception {
        String sql = "INSERT INTO Pelanggan (email, pass, nohp, namapel) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, pelanggan.getEmail(), pelanggan.getPass(), pelanggan.getNohp(), pelanggan.getNamapel());        
    }

    @Override
    public Optional<Pelanggan> findByEmailPelanggan(String email) {
        String sql = "SELECT * FROM Pelanggan WHERE email = ?";
        List<Pelanggan> results = jdbcTemplate.query(sql, this::mapRowToPelanggan, email);
        return results.size() == 0 ? Optional.empty() : Optional.of(results.get(0));
    }

    @Override
    public List<Unit> findUnit(String tipe, String checkin, String checkout, String hargaterendah, String hargatertinggi) {
        String sql = "SELECT unit.tipe, sewa.waktusewa, sewa.waktuselesai, unit.tarif FROM unit LEFT OUTER JOIN sewa ON unit.kodeunit = sewa.kodeunit WHERE(unit.tipe = ?, sewa.kodeunit IS NULL OR NOT (sewa.waktusewa = ? AND sewa.waktuselesai = ?) unit.tarif >= ? AND unit.tarif <= ?)";
        return jdbcTemplate.query(sql, this::mapRowToUnit, tipe, checkin, checkout, hargaterendah, hargatertinggi);
    }

    private Pelanggan mapRowToPelanggan(ResultSet resultSet, int rowNum) throws SQLException {
        return new Pelanggan(
            resultSet.getString("email"), 
            resultSet.getString("namapel"), 
            resultSet.getString("nohp"), 
            resultSet.getString("pass")
            );
    }

    private Unit mapRowToUnit (ResultSet resultSet, int rowNum) throws SQLException {
        return new Unit (
            resultSet.getString("kodeUnit"),
            resultSet.getString("tipe"),
            resultSet.getString("noUnit"),
            resultSet.getBoolean("status"),
            resultSet.getDouble("tarif"),
            resultSet.getString("nikAgen"),
            resultSet.getString("noLantai"),
            resultSet.getString("namaTower")
        );
    }
    
}
