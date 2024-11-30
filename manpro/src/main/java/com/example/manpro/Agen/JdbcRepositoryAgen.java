package com.example.manpro.Agen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.example.manpro.Unit.*;

@Repository
public class JdbcRepositoryAgen implements AgenRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void addUnit(String kodeUnit, String tipe, String noUnit, boolean status, double tarif, String nikAgen, String noLantai, String namaTower) {
        String sql = "INSERT INTO Unit (kodeUnit, tipe, noUnit, status, tarif, NIKAgen, noLantai, namaTower) VALUES (?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, kodeUnit, tipe, noUnit, status, tarif, nikAgen, noLantai, namaTower);
    }

    private Unit mapRowToUnit(ResultSet resultSet, int rowNum) throws SQLException {
        return new Unit(
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

    @Override
    public List<Unit> showAllAddedUnits(int limit) {
        String sql = "SELECT * FROM Unit ORDER BY ctid DESC LIMIT ?";
        List<Unit> addedUnits = jdbcTemplate.query(sql, this::mapRowToUnit, limit);
        return addedUnits;
    }
}
