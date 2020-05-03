package com.rzk.mapper;

import com.rzk.pojo.Teacher;
import com.rzk.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class Test1 {
    @Test
    public void test(){
        SqlSession sqlSessionFactory = MybatisUtils.getSqlSessionFactory();
        for (Teacher teacher : sqlSessionFactory.getMapper(TeacherMapper.class).getTeacher()) {
            System.out.println(teacher);
        }

        sqlSessionFactory.close();
    }

}
