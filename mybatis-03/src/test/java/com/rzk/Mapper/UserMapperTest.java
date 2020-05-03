package com.rzk.Mapper;

import com.rzk.pojo.User;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class UserMapperTest {
///* public static void main(String []args){
////
//     int i=1;
//     while (i<=10){
//         System.out.println(i);
//         i+=1;
//     }
//     System.out.println("------");
//     for (int z=10;z>0;z--){
//         System.out.println(z);
//     }
// }*/
////    @Test
////    public void getUserLike(){
////        SqlSession sqlSession = MybatisUtil.getSqlSession();
////        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
////        List<User>userList = mapper.getUserLike("%王%");
////       for (User user : userList){
////           System.out.println(user);
////       }
////        sqlSession.close();
////    }
////    @Test
////    public void getUserLike(){
////        SqlSession sqlSession = MybatisUtil.getSqlSession();
////        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
////        List<User>userList = mapper.getUserLike("%宝%");
////        for (User user : userList){
////            System.out.println(user);
////        }
////        sqlSession.close();
////    }
////    @Test
////    public void getUserLimit(){
////        SqlSession sqlSession = MybatisUtil.getSqlSession();
////        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
////        HashMap<String,Object> map = new HashMap<String,Object>();
////        map.put("name","老子");
////        map.put("pwd","123321");
////        map.put("id",1);
////        mapper.getUserLimit(map);
////        sqlSession.commit();
////        sqlSession.close();
////    }
//    @Test
//    public void getUserLimit(){
//        SqlSession  sqlSession = MybatisUtil.getSqlSession();
//        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        Map<String ,Object>map = new HashMap<String, Object>();
//        map.put("startIndex",1);
//        map.put("pageSize",2);
//
//        mapper.getUserLimit(map);
//
//
//        sqlSession.close();
//    }
//    @Test
//    public void getUserRowBounds(){
//        SqlSession sqlSession = MybatisUtil.getSqlSession();
//        RowBounds rowBounds = new RowBounds(0,4);
//        List<User> userList = sqlSession.selectList("com.rzk.Mapper.UserMapper.getUserRowBounds",null,rowBounds);
//
//        for(User user : userList){
//            System.out.println(user);
//        }
//
//        sqlSession.close();
//    }
////    @Test
////    public void getUserLimit(){
////        SqlSession sqlSession = MybatisUtil.getSqlSession();
////        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
////        HashMap<String,Object> map = new HashMap<String,Object>();
////        map.put("userid",14);
////        map.put("userName","李四");
////        map.put("passWord",123431);
////        List<User> userList = mapper.getUserLimit(map);
////        for (User user:userList){
////            System.out.println(user);
////        }
////
////        sqlSession.close();
////    }
////    @Test
////    public void test(){
////        SqlSession sqlSession = MybatisUtil.getSqlSession();
////
////        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
////        List<User> userList = mapper.getCategory();
////        for (User user:userList){
////            System.out.println(user);
////        }
////        sqlSession.close();
////    }
//
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
////    @Test
////    public void getUserId2(){
////        SqlSession sqlSession = MybatisUtil.getSqlSession();
////        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
////        Map<String,Object>map = new HashMap<String,Object>();
////         map.put("userId",90);
////         map.put("name","王宝强");
////
////
////        mapper.addUser2(map);
////        System.out.println(mapper);
////
////        sqlSession.close();
////    }
////
////  @Test
////  public void addUser(){
////        SqlSession sqlSession = MybatisUtil.getSqlSession();
////        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
////        int res = mapper.addUser(new User(10,"哈士奇","123456"));
////        if (res>0){
////            System.out.println("添加成功");
////        }else{
////            System.out.println("添加失败");
////        }
////         sqlSession.commit();
////        sqlSession.close();
////
////    }
////    @Test
////    public void addUser2(){
////     SqlSession sqlSession =  MybatisUtil.getSqlSession();
////     UserMapper mapper = sqlSession.getMapper(UserMapper.class);
////     Map<String ,Object> map = new HashMap<String ,Object>();
////     map.put("userId",11);
////     map.put("userName","王宝强");
////     map.put("userPwd","123321");
////
////     int res = mapper.addUser2(map);
////     if (res>0){
////         System.out.println("增加成功");
////     }else{
////         System.out.println("增加失败");
////     }
////     sqlSession.commit();
////    sqlSession.close();
////    }
////    @Test
////    public void updateUser(){
////        SqlSession sqlSession = MybatisUtil.getSqlSession();
////        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
////
////        mapper.updateUser(new User(1,"哈哈","123123"));
////
////        sqlSession.commit();
////        sqlSession.close();
////    }
////
////    @Test
////    public void deleteUser(){
////        SqlSession sqlSession = MybatisUtil.getSqlSession();
////        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
////        mapper.deleteUser(7);
////        sqlSession.commit();
////        sqlSession.close();
////    }


}
