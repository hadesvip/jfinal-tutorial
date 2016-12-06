package com.controller;

import com.base.BaseController;
import com.jfinal.ext.route.ControllerBind;

/**
 * Created by wangyong on 2016/12/5.
 */
@ControllerBind(controllerKey = "/", viewPath = "/")
public class IndexController extends BaseController {

    public void index() {

        getRequest().setAttribute("user", "admin");
        render("index.html");
    }
}
