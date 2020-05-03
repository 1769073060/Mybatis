package com.rzk.utils.dao;

import java.sql.*;

public class PrepareStatementTest {

    public static void main(String[] args) {

        // 安全性提高
        insertData("lishangyin",2600,"M",110.23F);

        // 删除

        // 更具年龄查询

        // 根据性别

        // 更新

    }

    public static void insertData(String name,int age,String sex,float height) {

        // 数据的访问路径
        String url = "jdbc:mysql://localhost:3306/szqy08";
        // 用户名
        String username = "root";
        String password = "123456";


        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // 1加载驱动  加载驱动 只加载一次到jvm种
            Class.forName("com.mysql.jdbc.Driver");

            // 2获取连接
            connection = DriverManager.getConnection(url, username, password);

            // 3获取statement

            // ?  占位符
            String sql = "insert  into  student_tb (name,age,sex,height,birthday)values (?,?,?,?,?)";
            // 1. 预编译sql 防止slq 注入，提高安全型  2.根据占位符传递参数
//            preparedStatement = connection.prepareStatement(sql);

            //   当数据插入时候
            preparedStatement =  connection.prepareStatement(sql);

            // 在preparedStatement 预编译sql 语句中设置值

            // 通过下标设置 预编译sql 的值
            // Sting ---> varchar
            preparedStatement.setString(1, name);
            // int ---> int
            preparedStatement.setInt(2, age);

            // String ---> char
            preparedStatement.setString(3, sex);

            preparedStatement.setFloat(4, height);



            // 3 首先将时间str转换成 java.sql.Date,再转换为datetime    str -->Date-->datetime 时间格式为 年 月日
            preparedStatement.setDate(5, Date.valueOf("2020-01-02"));





            // 4执行sql语句
            int len = preparedStatement.executeUpdate();

            if (len > 0) {
                System.out.println("插入成功");
            } else {
                System.out.println("插入失败");
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            // 5关闭连接
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }

                if (connection != null) {
                    connection.close();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }


        }
    }

}

