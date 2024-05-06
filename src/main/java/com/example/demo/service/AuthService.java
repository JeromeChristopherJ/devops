package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Login;
import com.example.demo.repository.AuthRepo;

@Service
public class AuthService {
    @Autowired
    private AuthRepo rep;

    public Login login(String username, String password)
    {
        Login user = rep.findByUsernameAndPassword(username, password);
        return user;
    }
}
