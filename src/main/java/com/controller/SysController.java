package com.controller;

import com.jfinal.core.Controller;

/**
 * Created by wangyong on 2016/10/7.
 */
public class SysController extends Controller {


    public void index() {
        renderText("hello,jfinal...");
    }


    public void home(){
        renderText("hello ,home...");
    }
}
