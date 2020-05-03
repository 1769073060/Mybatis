package com.rzk.utils.dao;


public class BaseDaoTest {

    public static void main(String[] args) {

        BaseDao baseDao =  new BaseDao();

        String sql = "insert  into  student_tb (name,age,sex,height,birthday)values (?,?,?,?,?)";

        Student student = new Student();
        student.setName("lisi");
        student.setAge(18);
        student.setSex("M");
        student.setHeight(170);
        student.setBirthday(Date.valueOf("2011-01-23"));
        Object[] params = {student.getName(),student.getAge(),student.getSex(),student.getHeight(),student.getBirthday()};
        // 将一个 java bean  -----》 插入到数据库里面 mysql
        int num =  baseDao.executeUpdate(sql,params);
        System.out.println("num:"+num);



        String querySql = "select * from student_tb where age > ?";
        Object[] queryParams = {10};

        List<Map<String,Object>> resultList =  baseDao.executeQuery(querySql,queryParams);
        System.out.println("resultList:"+resultList);


        List<Student> studentList = baseDao.executeQuery(querySql,queryParams,Student.class);
        for (Student student1:studentList){
            System.out.println("student1===="+student1);
        }

        // 如何把 List<Map<String,Object>> 转化为  List<Student>

    }

}
