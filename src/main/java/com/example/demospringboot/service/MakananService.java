package com.example.demospringboot.service;

import com.example.demospringboot.entity.Makanan;
import com.example.demospringboot.repository.MakananRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MakananService {

    private final MakananRepository makananRepository; 

    public MakananService(MakananRepository makananRepository) {
        this.makananRepository = makananRepository;
    }

    public List<Makanan> getAll() {
        return makananRepository.findAll();
    }

    public Makanan getById(Long id) {
        return makananRepository.findById(id).orElse(null);
    }

    public void save(Makanan makanan) { 
        makananRepository.save(makanan);
    }

    public void delete(Long id) {
        makananRepository.deleteById(id);
    }
}
    