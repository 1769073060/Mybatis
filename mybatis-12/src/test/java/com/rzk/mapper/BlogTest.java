package com.rzk.mapper;

import com.rzk.pojo.Blog;
import com.rzk.utils.IDutils;
import com.rzk.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.*;

public class BlogTest {
    @Test
    public void addBlog(){
        SqlSession sqlSession = MybatisUtils.getSqlSessionFactory();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        Blog blog = new Blog();
        blog.setId(IDutils.getId());
        blog.setTitle("Mybati如此简单");
        blog.setAuthor("rzk博客");
        blog.setCreateTime(new Date());
        blog.setViews(6666);

        mapper.addBlog(blog);

        blog.setId(IDutils.getId());
        blog.setTitle("Java如此简单");
        mapper.addBlog(blog);

        blog.setId(IDutils.getId());
        blog.setTitle("Spring如此简单");
        mapper.addBlog(blog);

        blog.setId(IDutils.getId());
        blog.setTitle("微服务如此简单");
        mapper.addBlog(blog);
        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public void queryBlogIF(){
        SqlSession sqlSession = MybatisUtils.getSqlSessionFactory();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Map<Object, Object> map = new HashMap<>();
        map.put("title","J");
        List<Blog> blogs = mapper.queryBlogIF(map);

        for (Blog blog : blogs) {
            System.out.println(blog);
        }

        sqlSession.close();
    }

    @Test
    public void queryBlogchoose(){
        SqlSession sqlSession = MybatisUtils.getSqlSessionFactory();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        Map<Object, Object> map = new HashMap<>();
//        map.put("title","Mybati如此简单");
        map.put("views",6666);
        map.put("author","rzk博客");


        List<Blog> blogs = mapper.queryBlogChoose(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        sqlSession.close();
    }

    @Test
    public void updateBlog(){
        SqlSession sqlSession = MybatisUtils.getSqlSessionFactory();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        Map<Object, Object> map = new HashMap<>();
//        map.put("title","Mybati如此简单");
        map.put("views",555);
        map.put("author","欢迎来到rzk");
        map.put("id","bcd63dcc934e4f4a9bbdc48547f6f88d");
        mapper.updateBlog(map);
        sqlSession.close();
    }

    @Test
    public void queryBlogForeach(){
        SqlSession sqlSessionFactory = MybatisUtils.getSqlSessionFactory();
        BlogMapper mapper = sqlSessionFactory.getMapper(BlogMapper.class);
        HashMap map = new HashMap<>();

        ArrayList<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        ids.add(4);
        map.put("ids",ids);
        List<Blog> blogs = mapper.queryBlogForeach(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }


        sqlSessionFactory.close();
    }
}
