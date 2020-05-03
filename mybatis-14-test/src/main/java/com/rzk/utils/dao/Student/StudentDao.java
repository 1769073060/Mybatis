package com.rzk.utils.dao.Student;

import com.rzk.pojo.User;

public class StudentDao {

    // 增加学生
    int addStudent(User user);

    // 删除学生
    int deleteStudent(int id);

    // 更新学生
    int updateStudent(User user);

    // 更具id查询学生
    User findStudentById(int id);

    // 查询所有学生
    List<User> findAllStudent();
}
