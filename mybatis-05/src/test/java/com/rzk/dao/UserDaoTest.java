package com.rzk.dao;

import com.rzk.dao.UserMapper;
import com.rzk.pojo.User;
import com.rzk.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoTest {
    //模糊查詢
    @Test
    public void getUserLike(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserLike("李");
        for (User user : userList){
            System.out.println(user);
        }
        sqlSession.close();
    }
    //查询全部用户
    @Test
    public void getUserList(){
        //获得sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //方式一：getMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserList();
        for (User user : userList) {
            System.out.println(user);
        }

        sqlSession.close();
    }
    //根据ID查询用户
    @Test
    public void getUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User userById = mapper.getUserById(1);
        System.out.println(userById);

        sqlSession.close();
    }
    //插入一个用户
    @Test
    public void addUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int i = mapper.addUser(new User(4,"赵柳","1234556"));
        sqlSession.commit();
        System.out.println("插入成功");

        sqlSession.close();
    }
    //修改用户
    @Test
    public void updateUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int user = mapper.updateUser(new User(1, "李倩", "123123"));
        if (user>0){
            System.out.println("修改成功");
        }
        sqlSession.commit();
        sqlSession.close();
    }
    //删除一个用户
    @Test
    public void deleteUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int i = mapper.deleteUser(5);
        if (i>0){
            System.out.println("删除成功");
        }else{
            System.out.println("删除失败");
        }
        sqlSession.commit();

        sqlSession.close();
    }
}
