package com.rzk.Mapper;

import com.rzk.mapper.StudentMapper;
import com.rzk.mapper.TeacherMapper;
import com.rzk.pojo.Student;
import com.rzk.pojo.Teacher;
import com.rzk.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mytest {
  @Test
    public void getTeacher(){
      SqlSession sqlsession = MybatisUtils.getSqlSessionFactory();
    TeacherMapper mapper = sqlsession.getMapper(TeacherMapper.class);
    Teacher teacher = mapper.getTeacher(1);
    System.out.println(teacher);
    sqlsession.close();
  }
  @Test
  public void getStudentByTeacherId(){
    SqlSession sqlsession = MybatisUtils.getSqlSessionFactory();

    TeacherMapper mapper = sqlsession.getMapper(TeacherMapper.class);

    Teacher teacher1 = mapper.getTeacher1(1);
    System.out.println(teacher1);
    sqlsession.close();
  }

  @Test
  public void getStudentByTeacher(){
    SqlSession sqlSessionFactory = MybatisUtils.getSqlSessionFactory();
    TeacherMapper mapper = sqlSessionFactory.getMapper(TeacherMapper.class);
    Teacher teacher2 = mapper.getTeacher2(1);
    System.out.println(teacher2);

    sqlSessionFactory.close();
  }
}
