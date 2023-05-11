package com.jnmc.pudmgr.login.service;

/**
 * 业务层，逻辑处理
 *
 * @author C3g07f
 * @date 2023/5/4 16:47
 */

import com.jnmc.pudmgr.login.dao.LoginDao;

import java.util.Map;


/**
 * 登录Service (业务层)
 */
public class LoginService {
    /*
    手动注入LoingDao对象
    */
    private LoginDao loginDao = new LoginDao();

    /**
     * 检查用户名和密码是否正确
     *
     * @param account  用户名
     * @param password 密码
     * @return 用户对象
     */
    public Map<String, Object> findUser(String account, String password) {
//调用dao查询用户信息
        Map<String, Object> user = loginDao.findUser(account, password);
        return user;
    }
}