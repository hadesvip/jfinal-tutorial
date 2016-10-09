package com.config;

import com.controller.BlogController;
import com.controller.SysController;
import com.domain.Blog;
import com.domain.UserInfo;
import com.jfinal.config.*;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;

/**
 * jfinal 启动配置
 * Created by wangyong on 2016/10/7.
 */
public class AppConfig extends JFinalConfig {


    /**
     * 配置jfinal的常量参数
     *
     * @param constants 开发者模式，视图。。
     *                  tips:视图缺省配置是freemarker
     */
    @Override
    public void configConstant(Constants constants) {
        constants.setDevMode(true);

        //加载配置文件
        PropKit.use("app.properties");
    }

    /**
     * 配置路由
     *
     * @param routes
     */
    @Override
    public void configRoute(Routes routes) {
        routes.add("/", SysController.class);
        routes.add("/blog", BlogController.class);
    }

    /**
     * 插件
     *
     * @param plugins
     */
    @Override
    public void configPlugin(Plugins plugins) {

        // druid
        String url = PropKit.get("jdbc.url");
        String userName = PropKit.get("jdbc.username");
        String password = PropKit.get("jdbc.password");
        DruidPlugin druidPlugin = new DruidPlugin(url, userName, password);

        // activeRecordPlugin
        ActiveRecordPlugin activeRecordPlugin = new ActiveRecordPlugin(druidPlugin);
        activeRecordPlugin.addMapping("blog", Blog.class);
        activeRecordPlugin.addMapping("userinfo", "user_id", UserInfo.class);

        plugins.add(druidPlugin);
        plugins.add(activeRecordPlugin);

    }

    /**
     * 拦截器:全局拦截器
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
