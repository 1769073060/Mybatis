package com.rzk.mapper;

import com.rzk.pojo.User;
import com.rzk.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {
    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();

       UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
       List<User> userList = userMapper.getUserList();
       for (User user : userList){
           System.out.println(user);
       }
        sqlSession.close();
    }
}

































