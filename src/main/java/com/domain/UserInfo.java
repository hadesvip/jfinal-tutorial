package com.domain;

import com.jfinal.plugin.activerecord.Model;

/**
 * Created by wangyong on 2016/10/2.
 */
public class UserInfo extends Model<UserInfo> {

    public static final UserInfo userDao = new UserInfo();


    /**
     * 用户编号
     */
    private int userId;

    /**
     * 用户名
     */
    private String userName;
    /**
     * 用户密码
     */
    private String password;

    /**
     * 用户描述
     */
    private String userDesc;

}
