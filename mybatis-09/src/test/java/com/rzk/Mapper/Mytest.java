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
    /*获取老师的id*/
    @Test
    public void getTeacher(){
        SqlSession sqlSession = MybatisUtils.getSqlSessionFactory();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacherById(1);
        System.out.println(teacher);
        sqlSession.close();
    }
    /*插入老师*/
    @Test
    public void addTeacher(){
        SqlSession sqlSession = MybatisUtils.getSqlSessionFactory();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("id",2);
//        map.put("name","大豬豬");
        int i = mapper.addTeacher(new Teacher(2, "大豬豬"));
        if(i>0){
            System.out.println("插入成功");
            sqlSession.commit();
        }
        sqlSession.close();
    }

    /*删除*/
    @Test
    public void deleteTeacher(){
        SqlSession sqlSession = MybatisUtils.getSqlSessionFactory();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        int i = mapper.deleteTeacher(6);
        if (i>0){
            System.out.println("删除成功");
            sqlSession.commit();
        }

        sqlSession.close();
    }

    /*获取学生的id*/
    @Test
    public void getStudentById(){
        SqlSession sqlSession = MybatisUtils.getSqlSessionFactory();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> studentList = mapper.getStudent();
        for (Student student : studentList) {
            System.out.println(student);
        }
        sqlSession.close();
    }

    /*map修改*/
    @Test
    public void updateTeacherMap(){
        SqlSession sqlSession = MybatisUtils.getSqlSessionFactory();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("id",1);
        map.put("name","精致的猪猪女孩");
        //增删改查都要进行提交
        int i = mapper.updateTeacherMap(map);
        if (i>0){
            System.out.println("修改成功");
            sqlSession.commit();
        }


        sqlSession.close();
    }


    /*map的插入*/
    @Test
    public void addTeacher1(){
        SqlSession sqlSession = MybatisUtils.getSqlSessionFactory();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Map<String, Object> map = new HashMap<String,Object>();
        map.put("tid",3);
        map.put("tname","李大强");
        mapper.addTeacherMap(map);
        sqlSession.commit();
        sqlSession.close();
    }


}
