package com.rzk.dao;

import com.rzk.pojo.User;
import com.rzk.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class daoTest {
    @Test
    public void getUsers(){
        SqlSession sqlSession = MybatisUtils.getSqlSessionFactory();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.getUsers();
        for (User user : users) {
            System.out.println(user);
        }
        sqlSession.close();

    }

    @Test
    public void getUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlSessionFactory();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userById = mapper.getUserById(1);
        System.out.println(userById);


        sqlSession.close();
    }
//    @Test
//    public void addUser(){
//        SqlSession sqlSession= MybatisUtils.getSqlSessionFactory();
//        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        mapper.addUser(new User(7,"lisi","123123"));
//
//
//        sqlSession.close();
//
//    }
//    @Test
//    public void updateUser(){
//        SqlSession sqlSession = MybatisUtils.getSqlSessionFactory();
//        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        mapper.updateUser(new User(6, "libai", "123456"));
//
//
//        sqlSession.close();
//    }
}
