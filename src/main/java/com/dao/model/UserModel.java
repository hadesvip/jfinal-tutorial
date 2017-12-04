package com.dao.model;

import com.jfinal.plugin.activerecord.Model;

/**
 * @author created by wangyong on 17-12-4
 */
public class UserModel extends Model<UserModel> {

    public static final UserModel userDao = new UserModel().dao();



}
