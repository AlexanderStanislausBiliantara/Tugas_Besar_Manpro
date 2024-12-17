package com.example.manpro.Agen;

import java.time.LocalDate;
import java.util.List;
import com.example.manpro.Agen.JdbcRepositorySewa;

import org.springframework.stereotype.Service;

@Service
public class JdbcRepositorySewaService {
    private final JdbcRepositorySewa repository;

    public JdbcRepositorySewaService(JdbcRepositorySewa repository) {
        this.repository = repository;
    }

    public List<Sewa> getCheckInByDate(LocalDate date) {
        return repository.findCheckInByDate(date);
    }
}
