package com.jmr.dao;

import com.jmr.pojo.User;
import com.jmr.pojo.UserList;
import java.util.List;


public interface UserMapper {
    List<UserList> findAllUser();
    String userexist(String nowUser);
}
