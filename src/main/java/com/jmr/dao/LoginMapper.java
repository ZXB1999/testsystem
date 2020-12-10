package com.jmr.dao;

public interface LoginMapper {
    String findUser(String username,String password);
    String userExist(String username);
}
