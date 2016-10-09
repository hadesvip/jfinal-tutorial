package com.controller;

import com.interceptor.BlogInterceptor;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;

/**
 * Created by wangyong on 2016/10/7.
 */
public class SysController extends Controller {


    @Before(BlogInterceptor.class)
    public void index() {
        renderText("hello,jfinal...");
    }


    public void home() {

        String userName = this.getPara("userName");

        System.out.println("[userName ]-->" + userName);

        renderJson("{'words':'hello,jfinal!'}");
    }
}
