package com.example.demospringboot.service;

import com.example.demospringboot.entity.Minuman;
import com.example.demospringboot.repository.MinumanRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MinumanService {

    private final MinumanRepository minumanRepository;

    public MinumanService(MinumanRepository minumanRepository) {
        this.minumanRepository = minumanRepository;
    }

    public List<Minuman> getAll() {
        return minumanRepository.findAll();
    }

    public Minuman getById(Long id) {
        return minumanRepository.findById(id).orElse(null);
    }

    public void save(Minuman minuman) {
        minumanRepository.save(minuman);
    }

    public void delete(Long id) {
        minumanRepository.deleteById(id);
    }
}
