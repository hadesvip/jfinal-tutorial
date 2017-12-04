package com.service.impl;

import com.dao.model.UserModel;
import com.jfinal.plugin.activerecord.Db;

import java.util.List;

/**
 * @author created by wangyong on 17-12-4
 */
public class AdminUserServiceImpl {

    public void getUser(){

        List<UserModel> findAdminUserList = UserModel.userDao.find(Db.getSql("findAdminUserList"));
    }
}
