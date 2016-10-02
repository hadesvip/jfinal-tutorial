package com.domain;

/**
 * Created by wangyong on 2016/10/2.
 */
public class UserInfo {

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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserDesc() {
        return userDesc;
    }

    public void setUserDesc(String userDesc) {
        this.userDesc = userDesc;
    }
}
