package com;

import com.jfinal.core.JFinal;

/**
 * 程序入口
 * Created by wangyong on 2016/10/7.
 */
public class Console {

    public static void main(String[] args) {
        JFinal.start("src/main/webapp", 80, "/", 5);
    }
}
