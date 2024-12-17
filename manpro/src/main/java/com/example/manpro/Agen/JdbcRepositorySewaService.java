package com.example.manpro.Agen;

import java.time.LocalDate;
import java.util.List;

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

    public List<Sewa> getCheckOutByDate(LocalDate date) {
        return repository.findCheckOutByDate(date);
    }
}
