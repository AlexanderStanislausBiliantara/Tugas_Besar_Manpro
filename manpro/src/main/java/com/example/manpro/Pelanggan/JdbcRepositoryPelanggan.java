package com.example.manpro.Pelanggan;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcRepositoryPelanggan implements PelangganRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void save(Pelanggan pelanggan) throws Exception {
        String sql = "INSERT INTO Pelanggan (email, pass, nohp, namapel) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, pelanggan.getEmail(), pelanggan.getPass(), pelanggan.getNoHp(), pelanggan.getNamaPel());        
    }

    @Override
    public Optional<Pelanggan> findByEmailPelanggan(String emailPelanggan) {
        String sql = "SELECT * FROM Pelanggan WHERE = ?";
        List<Pelanggan> results = jdbcTemplate.query(sql, this::mapRowToPelanggan, emailPelanggan);
        return results.size() == 0 ? Optional.empty() : Optional.of(results.get(0));
    }

    private Pelanggan mapRowToPelanggan(ResultSet resultSet, int rowNum) throws SQLException {
        return new Pelanggan(
            resultSet.getString("email"), 
            resultSet.getString("pass"), 
            resultSet.getString("noHp"), 
            resultSet.getString("namaPel")
            );
    }
    
}