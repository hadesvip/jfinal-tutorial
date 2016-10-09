package com.controller;

import com.domain.Blog;
import com.jfinal.core.Controller;

/**
 * 博客控制层
 * Created by wangyong on 2016/10/8.
 */
public class BlogController extends Controller {

    public void save() {

        // 接收前端传过来的数据
        Blog blog = this.getModel(Blog.class);

        new Blog().set("title", "我的博客开通了").set("content", "我的博客开通了，欢迎大家关注!").save();

        System.out.println(blog);

    }

    public void getPost(){

        Blog blog = Blog.blogDao.findById(1);

        System.out.println(blog);
    }


}
