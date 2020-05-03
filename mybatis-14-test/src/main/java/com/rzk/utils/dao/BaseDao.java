package com.rzk.utils.dao;


import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseDao {
    // 数据的访问路径
    private static final String url = "jdbc:mysql://localhost:3306/mybatis";
    // 用户名
    private static final String username = "root";
    private static final String password = "123456";

    // 1.加载驱动
    // 只执行一次，在类加载的时
    static {
        // 1加载驱动  加载驱动 只加载一次到jvm种
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    // 2.获取连接
    public Connection getConnection(){
        Connection connection = null;
        // 2获取连接
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }


    // 增 删 改
    public int executeUpdate(String sql,Object[] params){
        // 获取connection
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;

        int num = -1;

        try {

            preparedStatement = connection.prepareStatement(sql);

            // 设置参数
            if (params!=null){
                for (int i=0;i<params.length;i++){
                    // 设置参数
                    preparedStatement.setObject(i+1,params[i]);
                }
            }

            // 执行sql 语句
            num =  preparedStatement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            // 释放资源
            try {
                if (preparedStatement!=null){
                    preparedStatement.close();
                }

                if (connection!=null){
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return num;
    }

    // 查询  因为我们查询时不确定数据库种的字段
    public List<Map<String,Object>> executeQuery(String sql,Object[] params){
        List<Map<String,Object>> mapList = new ArrayList<>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        connection = getConnection();

        try {
            preparedStatement = connection.prepareStatement(sql);
            // 设置参数
            if (params!=null){
                for (int i=0;i<params.length;i++){
                    // 设置参数
                    preparedStatement.setObject(i+1,params[i]);
                }
            }

            ResultSet resultSet =  preparedStatement.executeQuery();

            // metaData 描述了我们插叙得到的结果一个表结构
            ResultSetMetaData metaData =  resultSet.getMetaData();
            // 获取结果有几列
            int count = metaData.getColumnCount();
            // 遍历每一行，获取结果
            while (resultSet.next()){
                Map<String,Object> map = new HashMap<>();
                // 在每一行遍历列
                for (int i=0;i<count;i++){
                    //列 从1 计数
                    Object o =  resultSet.getObject(i+1);
                    // 获取当前的列名
                    String columnName = metaData.getColumnName(i+1);
                    map.put(columnName,o);
                }

                // 要把一行的数据 放在结果集种
                mapList.add(map);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            // 释放资源
            try {
                if (preparedStatement!=null){
                    preparedStatement.close();
                }

                if (connection!=null){
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return mapList;
    }

    // 返回试题对象 集合
    public <T> List<T> executeQuery(String sql,Object[] params,Class<?>  classes){
        List<T> resultList = new ArrayList<>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        connection = getConnection();

        try {
            preparedStatement = connection.prepareStatement(sql);
            // 设置参数
            if (params!=null){
                for (int i=0;i<params.length;i++){
                    // 设置参数
                    preparedStatement.setObject(i+1,params[i]);
                }
            }

            ResultSet resultSet =  preparedStatement.executeQuery();

            // metaData 描述了我们插叙得到的结果一个表结构
            ResultSetMetaData metaData =  resultSet.getMetaData();
            // 获取结果有几列
            int count = metaData.getColumnCount();
            // 遍历每一行，获取结果
            while (resultSet.next()){
                try {
                    // 通过反射拿到一个对象，T 编译之后都会类擦除 ，都是Object
                    T o = (T) classes.newInstance();

                    // 在每一行遍历列
                    for (int i=0;i<count;i++){

                        // 获取当前的列名 和 实体对象 的字段名一样
                        String columnName = metaData.getColumnName(i+1);
                        Field field =  classes.getDeclaredField(columnName);
                        field.setAccessible(true);

                        // 为java student 实体类的字段设置值
                        if (resultSet.getObject(i+1)!=null){
                            field.set(o,resultSet.getObject(i+1));
                        }
                    }
                    // 要把一行的数据 放在结果集种
                    resultList.add(o);

                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            // 释放资源
            try {
                if (preparedStatement!=null){
                    preparedStatement.close();
                }

                if (connection!=null){
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return resultList;
    }


}
