package com.controller;

import com.base.BaseController;
import com.jfinal.ext.route.ControllerBind;

/**
 * 系统配置
 * Created by wangyong on 2016/10/7.
 */

@ControllerBind(controllerKey = "/sys", viewPath = "sys")
public class SysController extends BaseController {

    public void index() {

        render("index.html");
    }


}
