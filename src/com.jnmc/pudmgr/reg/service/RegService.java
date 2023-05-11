package com.jnmc.pudmgr.reg.service;

/**
 * 业务层，逻辑处理
 *
 * @author C3g07f
 * @date 2023/5/4 17:59
 */
import com.jnmc.pudmgr.reg.service.RegService;

import com.jnmc.pudmgr.reg.dao.RegDao;

import java.util.Map;


public class RegService {
    private RegDao regDao = new RegDao();

    public Map<String, Object> checkUser(String account) {

        return regDao.checkUser(account);
}
    public int addUser(Map<String, Object> data) {

        return regDao.addUser(data);
    }

}