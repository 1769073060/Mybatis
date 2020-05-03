package com.rzk.mapper;

import com.rzk.pojo.Student;
import com.rzk.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentMapper {
    //获得学生
    List<Student> getStudent();

}
