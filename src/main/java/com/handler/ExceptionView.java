package com.handler;

import com.base.BaseController;
import com.jfinal.ext.route.ControllerBind;

/**
 * Created by wangyong on 16-12-6.
 */
@ControllerBind(controllerKey = "/exception")
public class ExceptionView extends BaseController {

    public void index() {
        renderJson("系统异常");
    }
}
