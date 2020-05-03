package com.rzk.Mapper;

import com.rzk.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    //查询所有用户
    List<User> getCategory();
//    //增加一条用户
    int addUser(User user);
//    //修改
//    int updateUser(User user);
    //删除
//    int deleteUser(int user);


}
