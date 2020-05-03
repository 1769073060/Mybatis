package com.rzk.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
public class MybatisUtils {
    private static SqlSessionFactory sqlSessionFactory;
    static{
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory =  new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //顾名思义，现在有了SqlSessionFactory，您可以获取SqlSession的实例。
    // SqlSession绝对包含对数据库执行SQL命令所需的所有方法。您可以直接对SqlSession实例执行映射的SQL语句
    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();

    }
}
