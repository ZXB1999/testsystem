package com.jmr.service;

import com.jmr.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public interface UserService {
    Map<Integer, List<User>> FindAllUser();
    boolean wasuserexist(String nowUsername);
}
