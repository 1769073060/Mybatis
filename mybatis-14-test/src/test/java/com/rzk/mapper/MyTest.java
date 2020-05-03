package com.rzk.mapper;

import com.rzk.mapper.user.UserMapper;
import com.rzk.pojo.User;
import com.rzk.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import static javax.print.attribute.standard.MediaPrintableArea.MM;

public class MyTest {

    /*1登录*/
    @Test
    public void getLoginUser() throws Exception {
        SqlSession sqLSession = MybatisUtils.getSqlSessionFactory();
        UserMapper mapper = sqLSession.getMapper(UserMapper.class);
        User loginUser = mapper.getLoginUser("admin");
        System.out.println(loginUser);

        sqLSession.close();
    }
    /*2*/
    @Test
    public void getUserList() throws Exception {
        SqlSession sqlSession = MybatisUtils.getSqlSessionFactory();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        HashMap<String, Object> map = new HashMap<>();
        /*模糊查询  userName里面的系统有多少个*/
        map.put("userName","系统");
        /*输出为1的用户角色*/
        map.put("userRole",1);
        /*分页*/
        map.put("pageIndex",0);
        map.put("pageSize",2);

        List<User> userList = mapper.getUserList(map);
        System.out.println(userList);

        sqlSession.close();
    }

    /*3查询用户数量 */
    @Test
    public void getUserCount() throws Exception {
        SqlSession sqlSession = MybatisUtils.getSqlSessionFactory();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int count = mapper.getUserCount("系");
        System.out.println(count);
        sqlSession.close();
    }

    /*删除id*/
    @Test
    public void deleteByPrimaryKey() throws Exception {
        SqlSession sqlSession = MybatisUtils.getSqlSessionFactory();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int i = mapper.deleteByPrimaryKey(1);
        if (i>0){
            System.out.println("删除成功");
        }
        System.out.println(i);
        sqlSession.close();
    }

    /*  查询userCode是否存在*/
    @Test
    public void selectUserCodeExist() throws Exception {
        SqlSession sqlSession = MybatisUtils.getSqlSessionFactory();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectUserCodeExist("admin");
        System.out.println(user);
        sqlSession.close();
    }
    /*根据用户id 修改密码*/
    @Test
    public void updatePwd() throws Exception {
        SqlSession sqlSession = MybatisUtils.getSqlSessionFactory();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        boolean b = mapper.updatePwd(1, "123123");
        if (b == true) {
            System.out.println("修改密码成功");
            sqlSession.commit();
        }
        sqlSession.close();
    }

    /*添加一条完整数据*/
    @Test
    public void insert(){
        SqlSession sqlSession = MybatisUtils.getSqlSessionFactory();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int i = mapper.insert(new User (62,"admin", "管理员",
                "1234567", 1, new Date(MM), "13688889999",
                "北京市海淀区成府路207号", 1,
                null, null,1,null));
                if (i>0){
            System.out.println("插入成功");
            sqlSession.commit();
        }
        sqlSession.close();
    }

    /*添加一条可任意选择*/
    @Test
    public void insertSelective(){
        SqlSession sqlSession = MybatisUtils.getSqlSessionFactory();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int i = mapper.insert(new User (62,"admin1", "管理",
                "123456", 1, null, "13688889999",
                "北京市海淀区成府路207号", 1,
                null, null,1,null));
        if (i>0){
            System.out.println("插入成功");
            sqlSession.commit();
        }
        sqlSession.close();
    }

    /*根据用户id查询指定用户信息*/
    @Test
    public void selectByPrimaryKey() throws Exception {
        SqlSession sqlSession = MybatisUtils.getSqlSessionFactory();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectByPrimaryKey(1);
        System.out.println(user);
        sqlSession.close();
    }

    /*根据用户id修改用户不为空的字段信息*/
    @Test
    public void updateByPrimaryKeySelective() throws Exception {
        SqlSession sqlSession = MybatisUtils.getSqlSessionFactory();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int i = mapper.updateByPrimaryKeySelective(new User(1, "Admin", null, null, null, null, null, null, null, null, null, null, null));
        if (i>0) {
            System.out.println("修改成功");
            sqlSession.commit();
        }
        sqlSession.close();

    }

    /*根据用户id修改用户信息 如为空的字段在数据库中置为NULL*/
    @Test
    public void updateByPrimaryKey() throws Exception {
        SqlSession sqlSession = MybatisUtils.getSqlSessionFactory();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int i = mapper.updateByPrimaryKeySelective(new User(70,"大管理",null,null,null,null,null,null,null,null,null,null,null));
        if(i>0){
            System.out.println("插入成功");
            sqlSession.commit();
        }
        sqlSession.close();
    }


        /*根据用户id修改用户信息 如为空的字段在数据库中置为NULL。 */
        @Test
        public void getRoleIdByUserInfo() throws Exception {
            SqlSession sqlSession = MybatisUtils.getSqlSessionFactory();
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<User> userInfo = mapper.getRoleIdByUserInfo(2);
            for (User user : userInfo) {
                System.out.println(user);
            }
            sqlSession.close();
        }
}
