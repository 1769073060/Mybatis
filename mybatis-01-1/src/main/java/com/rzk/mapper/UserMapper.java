package com.rzk.mapper;

import com.rzk.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper  {
    //查询用户
    List<User> getUserList();
    //根据ID查询用户
    User getUserById(@Param("userId") int id);
    //insert 一个用户
    int addUser(User user);
    //修改用户
    int updateUser(User user);
    //删除用户
    int deleteUser(@Param("userId") int id);
}
