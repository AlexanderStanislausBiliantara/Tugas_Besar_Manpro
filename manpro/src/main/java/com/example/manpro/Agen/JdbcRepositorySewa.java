package com.example.manpro.Agen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcRepositorySewa {
     private final JdbcTemplate jdbcTemplate;

    public JdbcRepositorySewa(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Method untuk mengambil daftar sewa dengan tanggal check-in
    public List<Sewa> findCheckInByDate(LocalDate tanggal) {
        String sql = "SELECT kodeunit, waktusewa, waktuselesai " +
                     "FROM sewa WHERE waktusewa = ?";
        return jdbcTemplate.query(sql, this::mapRow, tanggal);
    }

    public List<Sewa> findCheckOutByDate(LocalDate tanggal) {
        String sql = "SELECT kodeunit, waktusewa, waktuselesai " +
                     "FROM sewa WHERE waktuselesai = ?";
        return jdbcTemplate.query(sql, this::mapRow, tanggal);
    }

    private Sewa mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Sewa(
            rs.getString("kodeunit"),
            rs.getDate("waktusewa"),
            rs.getDate("waktuselesai")
        );
    }

}