package com.rzk.dao;

import com.rzk.pojo.User;
import jdk.nashorn.internal.objects.annotations.Setter;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    //查詢id
//    User getUserById(int id);
    //
    @Select("select * from user")
    List<User> getUsers();
    //方法存在多个参数，所有的参数前面必须加上@Param("id")注解
    @Select("select name from User where id =#{id}")
    List<User>  getUserById(int id);

    //插入
//    User updateUser()
}
