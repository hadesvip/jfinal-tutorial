package com.config;

import com.controller.IndexController;
import com.jfinal.config.*;
import com.jfinal.ext.handler.ContextPathHandler;
import com.jfinal.ext.interceptor.ExceptionInterceptor;
import com.jfinal.ext.plugin.sqlinxml.SqlInXmlPlugin;
import com.jfinal.ext.plugin.tablebind.AutoTableBindPlugin;
import com.jfinal.ext.plugin.tablebind.SimpleNameStyles;
import com.jfinal.ext.route.AutoBindRoutes;
import com.jfinal.kit.PathKit;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.CaseInsensitiveContainerFactory;
import com.jfinal.plugin.activerecord.dialect.Dialect;
import com.jfinal.plugin.activerecord.dialect.OracleDialect;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.template.Engine;

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

        PropKit.use("app.properties");

        constants.setDevMode(PropKit.getBoolean("devMode", false));

    }

    /**
     * 配置路由:采用注解的方式
     *
     * @param routes
     */
    @Override
    public void configRoute(Routes routes) {
        routes.add(new AutoBindRoutes());
//        routes.add("/", IndexController.class);
    }

    @Override
    public void configEngine(Engine engine) {

    }

    /**
     * 插件
     *
     * @param plugins
     */
    @Override
    public void configPlugin(Plugins plugins) {

        loadPropertyFile("jdbc.properties");

        // druid
        DruidPlugin druidPlugin = new DruidPlugin(PropKit.get("jdbc.url"), PropKit.get("jdbc.username"), PropKit.get("jdbc.password"));
        druidPlugin.setDriverClass("oracle.jdbc.driver.OracleDriver");

        //自动绑定表跟model的插件
//        AutoTableBindPlugin autoTableBindPlugin = new AutoTableBindPlugin(druidPlugin, SimpleNameStyles.LOWER_UNDERLINE);
//        autoTableBindPlugin.setShowSql(true);
//        autoTableBindPlugin.addScanPackages("com.dao.model");

        ActiveRecordPlugin activeRecordPlugin = new ActiveRecordPlugin(druidPlugin);
        activeRecordPlugin.setShowSql(true);
        activeRecordPlugin.setDialect(new OracleDialect());
        activeRecordPlugin.setContainerFactory(new CaseInsensitiveContainerFactory());
        activeRecordPlugin.setBaseSqlTemplatePath(PathKit.getRootClassPath());
        activeRecordPlugin.addSqlTemplate("/sqlMap/config-sql.sql");

        plugins.add(druidPlugin);
        plugins.add(activeRecordPlugin);
//        plugins.add(autoTableBindPlugin);
//        plugins.add(new SqlInXmlPlugin());

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
        exceptionInterceptor.setDefault("/exception");
        interceptors.add(exceptionInterceptor);

    }


    @Override
    public void configHandler(Handlers handlers) {
        handlers.add(new ContextPathHandler("baseUrl"));
    }

}
