package com.example.demospringboot.service;

import com.example.demospringboot.entity.User;
import com.example.demospringboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean validate(String kode, String password) {
        User user = userRepository.findByKodeAndPassword(kode, password);
        return user != null;
    }
}
