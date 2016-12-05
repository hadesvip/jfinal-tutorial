package com.config;

import com.jfinal.config.*;
import com.jfinal.ext.interceptor.ExceptionInterceptor;
import com.jfinal.ext.plugin.sqlinxml.SqlInXmlPlugin;
import com.jfinal.ext.plugin.tablebind.AutoTableBindPlugin;
import com.jfinal.ext.plugin.tablebind.SimpleNameStyles;
import com.jfinal.kit.PropKit;
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

        // freemarker
        constants.setBaseViewPath("/WEB-INF/template");
        constants.setFreeMarkerViewExtension(".html");

        //加载配置文件
        PropKit.use("app.properties");
    }

    /**
     * 配置路由:采用注解的方式
     *
     * @param routes
     */
    @Override
    public void configRoute(Routes routes) {
        //routes.add(new AutoBindRoutes());
    }

    /**
     * 插件
     *
     * @param plugins
     */
    @Override
    public void configPlugin(Plugins plugins) {

        // druid
        DruidPlugin druidPlugin = new DruidPlugin(PropKit.get("jdbc.url"), PropKit.get("jdbc.username"), PropKit.get("jdbc.password"));

        //自动绑定表跟model的插件
        AutoTableBindPlugin autoTableBindPlugin = new AutoTableBindPlugin(druidPlugin, SimpleNameStyles.LOWER_UNDERLINE);
        autoTableBindPlugin.setShowSql(true);
        autoTableBindPlugin.addScanPackages("com.dao.model");

        plugins.add(druidPlugin);
        plugins.add(autoTableBindPlugin);
        plugins.add(new SqlInXmlPlugin());

    }

    /**
     * 拦截器:全局拦截器
     *
     * @param interceptors
     */
    @Override
    public void configInterceptor(Interceptors interceptors) {

        //统一异常处理
        ExceptionInterceptor exceptionInterceptor = new ExceptionInterceptor();
        //exceptionInterceptor.addMapping(NullPointerException.class,"");
        exceptionInterceptor.setDefault("系统异常");

        interceptors.add(exceptionInterceptor);

    }


    @Override
    public void configHandler(Handlers handlers) {

    }

}
