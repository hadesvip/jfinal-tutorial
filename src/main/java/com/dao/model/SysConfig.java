package com.dao.model;

import com.jfinal.ext.plugin.sqlinxml.SqlKit;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

/**
 * Created by wangyong on 2016/12/5.
 */
public class SysConfig extends Model {


    public Page<SysConfig> page() {
        String sql = SqlKit.sql("SysConfig.findSysconfig");

        return null;

    }

}
