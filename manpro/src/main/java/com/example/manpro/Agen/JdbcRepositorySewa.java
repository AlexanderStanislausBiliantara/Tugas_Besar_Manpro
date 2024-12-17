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
        String sql = "SELECT kodeunit, waktusewa, waktuselesai" +
                     "FROM sewa WHERE waktusewa = ?";
        return jdbcTemplate.query(sql, new SewaRowMapper(), tanggal);
    }

    // Mapper untuk memetakan hasil query ke objek Sewa
    private static class SewaRowMapper implements org.springframework.jdbc.core.RowMapper<Sewa> {
        @Override
        public Sewa mapRow(ResultSet rs, int rowNum) throws SQLException {
            Sewa sewa = new Sewa();
            sewa.setKodeUnit(rs.getString("kodeunit"));
            sewa.setWaktusewa(rs.getDate("waktusewa").toString());
            sewa.setWaktuselesai(rs.getDate("waktuselesai").toString());
            return sewa;
        }
    }
}
