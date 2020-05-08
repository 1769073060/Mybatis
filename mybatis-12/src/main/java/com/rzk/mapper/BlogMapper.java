package com.rzk.mapper;

import com.rzk.pojo.Blog;
import org.apache.ibatis.annotations.Insert;

import java.util.List;
import java.util.Map;

public interface BlogMapper {
    //插入数据
    int addBlog(Blog blog);

    //查询bolg
    List<Blog> queryBlogIF(Map map);

    //查询你
    List<Blog> queryBlogChoose(Map map);

    //修改
    int updateBlog(Map map);

    //查询第1-2-3号记录的博客
    List<Blog> queryBlogForeach(Map map);
}