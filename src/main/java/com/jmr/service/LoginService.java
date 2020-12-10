package com.jmr.service;

import com.jmr.pojo.User;

public interface LoginService {
    User Finduser(User user);
    String Userexist(String username);
}
