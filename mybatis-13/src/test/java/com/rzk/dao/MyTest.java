package com.rzk.dao;

import com.rzk.mapper.UserMapper;
import com.rzk.pojo.User;
import com.rzk.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MyTest {
    @Test
    public void queryUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlSessionFactory();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.queryUserById(1);
        System.out.println(user);

        System.out.println("=================");
        User user1 = mapper.queryUserById(1);
        System.out.println(user1);
        System.out.println(user==user1);
        sqlSession.close();
    }
}
