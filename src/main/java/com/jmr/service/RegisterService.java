package com.jmr.service;

import org.springframework.stereotype.Service;

@Service
public interface RegisterService {
    String RegisterUser(String username,String password);
}
