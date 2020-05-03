package com.rzk.dao;

import com.rzk.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    //模糊查詢
    List<User> getUserLike(String value);
    //查询全部用户
    List<User> getUserList();
    //根据ID查询用户
    User getUserById(int id);
    //插入一个用户
    int addUser(User user);
    //修改用户
    int updateUser(User user);
    //删除一个用户
    int deleteUser(int id);
    //插入的Map--------有帮助------------
    int addUser1(Map<String,Object> map);
    //查询的Map
    User getUserId1(Map<String,Object> map);

}
