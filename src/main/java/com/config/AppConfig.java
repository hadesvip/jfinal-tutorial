package com.config;

import com.controller.SysController;
import com.jfinal.config.*;

/**
 * jfinal 启动配置
 * Created by wangyong on 2016/10/7.
 */
public class AppConfig extends JFinalConfig {


    /**
     * 配置jfinal的常量参数
     *
     * @param constants 开发者模式，视图。。
     */
    @Override
    public void configConstant(Constants constants) {
        constants.setDevMode(true);
    }

    /**
     * 配置路由
     *
     * @param routes
     */
    @Override
    public void configRoute(Routes routes) {
        routes.add("/", SysController.class);
    }

    /**
     * 插件
     *
     * @param plugins
     */
    @Override
    public void configPlugin(Plugins plugins) {

    }

    /**
     * 拦截器
     *
     * @param interceptors
     */
    @Override
    public void configInterceptor(Interceptors interceptors) {

    }


    @Override
    public void configHandler(Handlers handlers) {

    }
}
