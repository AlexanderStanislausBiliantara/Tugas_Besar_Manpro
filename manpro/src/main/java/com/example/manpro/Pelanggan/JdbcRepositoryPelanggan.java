package com.example.manpro.Pelanggan;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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


}
