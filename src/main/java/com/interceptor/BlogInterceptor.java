package com.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

/**
 * 博客拦截器
 * Created by wangyong on 2016/10/9.
 */
public class BlogInterceptor implements Interceptor {

    @Override
    public void intercept(Invocation inv) {
        System.out.println("[inovke method before...]");

        inv.invoke();

        System.out.println("[invoke method after...]");

    }
}
