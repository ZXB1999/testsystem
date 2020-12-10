package com.jmr.service.impl;

import com.jmr.dao.UserMapper;
import com.jmr.pojo.User;
import com.jmr.pojo.UserList;
import com.jmr.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired(required = false)
    public UserMapper userMapper;

    private  final  static Logger logger = LoggerFactory.getLogger(UserService.class);

    public Map<Integer, List<User>> FindAllUser() {
        List<UserList> userLists = userMapper.findAllUser();
        Map<Integer,List<User>> map = new HashMap();
        userLists.forEach(UserList -> {
            Integer id=UserList.getId();
            List<User> users = UserList.getUserList();
            map.put(id,users);
        });
        logger.info("list.size={}",userLists.size());
        return map;
    }

    public boolean wasuserexist(String nowUser) {
        String code =  userMapper.userexist(nowUser);
        if (code != null){
            return true;
        }
        return false;
    }

}
