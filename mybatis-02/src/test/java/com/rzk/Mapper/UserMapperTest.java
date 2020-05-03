package com.rzk.Mapper;

import com.rzk.pojo.User;
import com.rzk.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest {
    @Test
    public void getCategory(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> category = mapper.getCategory();
        for (User user : category) {
            System.out.println(user);
        }


        sqlSession.close();
    }

//    @Test
//    public void getUserId(){
//        SqlSession sqlSession = MybatisUtil.getSqlSession();
//
//        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        User user = mapper.getUserId(1);
//        System.out.println(user);
//
//        sqlSession.close();
//    }


  @Test
  public void addUser(){
      SqlSession sqlSession = MybatisUtil.getSqlSession();
      UserMapper mapper = sqlSession.getMapper(UserMapper.class);
      int i = mapper.addUser(new User(8, "里奇納", "123123"));
      if (i>0){
            System.out.println("添加成功");
        }else{
            System.out.println("添加失败");
        }
         sqlSession.commit();
        sqlSession.close();

    }

//    @Test
//    public void updateUser(){
//        SqlSession sqlSession = MybatisUtil.getSqlSession();
//        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        mapper.updateUser(new User(1,"哈哈","123123"));
//
//
//        sqlSession.commit();
//        sqlSession.close();
//    }

//    @Test
//    public void deleteUser(){
//        SqlSession sqlSession = MybatisUtil.getSqlSession();
//        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        mapper.deleteUser(7);
//        sqlSession.commit();
//        sqlSession.close();
//    }

}
