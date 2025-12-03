package com.example.demospringboot.repository;

import com.example.demospringboot.entity.Makanan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MakananRepository extends JpaRepository<Makanan, Long> {}