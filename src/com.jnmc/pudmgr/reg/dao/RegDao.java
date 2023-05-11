package com.jnmc.pudmgr.reg.dao;

/**
 * 数据持久层，数据库操作/jsp页面发送请求 --> servlet接收页面请求 <--> 调用service进行业务逻辑处理 -->
 *     调用DAO进行 数据库操作-->返回DAO --> 数据返回service 进行逻辑处理 --> 返回servlet响应jsp页面请求
 *
 * @author C3g07f
 * @date 2023/5/4 18:01
 */
import com.jnmc.jdbc.BaseDao;

import java.util.Map;


public class RegDao {
    private BaseDao baseDao = new BaseDao();
    public Map<String, Object> checkUser(String account) {
        String sql = "Select * FROM t_user t Where t.account = ?"; return baseDao.findOne(sql,account);
    }
    public int addUser(Map<String, Object> data) {
        String sql = "Insert Into  t_user (NAME,PASSWORD,SEX,XL,GZLL,ACCOUNT,ZT) " + "Values(?,?,?,?,?,?,?)";
        return baseDao.doDML(sql, data.get("name"),data.get("password"),
                data.get("sex"),data.get("xl"),data.get("gzll"),data.get("account"),"zc");
    }
}