package com.rzk.dao;

import com.rzk.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    //查詢id
    User getUserById(int id);

    //
    List<User> getUserByLimit(Map<String,Integer> map);
}
