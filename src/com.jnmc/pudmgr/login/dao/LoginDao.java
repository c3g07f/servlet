package com.jnmc.pudmgr.login.dao;
/**
 * @author C3g07f
 * @date 2023/5/4 16:48
 */
import com.jnmc.jdbc.BaseDao;
import java.util.Map;

/**
 * 登录DAO
 */
public class LoginDao {
    /*
    手动注入BaseDao
    */
    private BaseDao baseDao = new BaseDao();
    /**
     *  检查用户名和密码是否正确
     * @param account 用户名
     * @param password 密码
     * @return */
    public Map<String, Object> findUser(String account, String password) {
        String sql = "select * from T_USER t where t.account=? and t.password=? ";
        System.out.println(sql);
        return baseDao.findOne(sql,account,password);
    }
}
