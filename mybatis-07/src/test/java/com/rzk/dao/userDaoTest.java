package com.rzk.dao;

import com.rzk.pojo.User;
import com.rzk.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class userDaoTest {
    static Logger logger = Logger.getLogger(userDaoTest.class);
    @Test
    public void getUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlSessionFactory();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        logger.info("进入测试文件");
        User id = mapper.getUserById(1);
        System.out.println(id);

        sqlSession.close();
    }
    @Test
    public void testLog4j(){
        logger.info("info进入testLog4j");
        logger.debug("debug:进入了Log4j");
        logger.error("error:进入了Log4j");
    }

        /*分页*/
    @Test
    public void getUserByLimit(){
        SqlSession sqlSession = MybatisUtils.getSqlSessionFactory();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Integer> map = new HashMap<>();
        map.put("starIndex",1);
        map.put("pageSize",2);

        List<User> userList = mapper.getUserByLimit(map);
        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }
}
