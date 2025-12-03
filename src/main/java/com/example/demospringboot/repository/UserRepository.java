package com.example.demospringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demospringboot.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByKodeAndPassword(String kode, String password);

}
