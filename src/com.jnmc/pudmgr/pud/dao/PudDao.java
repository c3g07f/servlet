package com.jnmc.pudmgr.pud.dao;

import com.jnmc.jdbc.BaseDao;
import java.util.List;
import java.util.Map;
/**
 * @author C3g07f
 * @date 2023/5/5 11:41
 */
public class PudDao {
    private BaseDao baseDao = new BaseDao();
    public List<Map<String, Object>> queryAll() {
        String sql = "SELECT * FROM T_PRODUCT";
        return baseDao.query(sql);
    }
    /**
     * 保存产品数据到数据库
     *
     * @param pud
     * @return
     */
    public int add(Map<String, Object> pud) {
        String sql = "INSERT INTO t_product (P_NAME, P_CODE, P_TYPE, P_PRICE, P_COUNT,"
                + " P_UNIT, P_METERIAL, P_TIME, P_DESCRIPTION) " + "VALUES (?,?,?,?,?,?,?,?,?) ";
        String price = (String) pud.get("P_PRICE");
        if ("".equals(price)) {
            price = "0";
        }
        String count = (String) pud.get("P_COUNT");
        if ("".equals(count)) {
            count = "0";
        }
        return baseDao.doDML(sql, pud.get("P_NAME"), pud.get("P_CODE"),
                pud.get("P_TYPE"),
                Double.parseDouble(price), Integer.parseInt(count),
                pud.get("P_UNIT"),
                pud.get("P_METERIAL"), pud.get("P_TIME"),
                pud.get("P_DESCRIPTION"));
    }
    /**
     * 删除产品信息
     *
     * @param id
     * @return
     */
    public int delete(String id) {
        String sql = "delete from t_product where ID = ?";
        return baseDao.doDML(sql, id);
    }
    /**
     * 根据产品id查询产品信息
     *
     * @param id
     * @return
     */
    public Map<String, Object> findOne(String id) {
        String sql = "select * from t_product where ID = ?";
        return baseDao.findOne(sql, id);
    }
    /**
     * 更新产品信息
     *
     * @param pud
     * @return
     */
    public int upd(Map<String, Object> pud) {
        String sql = "update t_product set P_NAME = ?,P_CODE= ?,P_TYPE = ?,"
                + " P_PRICE = ?,P_COUNT = ?,P_UNIT = ?,"
                + "P_METERIAL = ?, P_TIME = ? ,P_DESCRIPTION =?"
                + " where ID= ? ";
        String price = (String) pud.get("P_PRICE");
        if ("".equals(price)) {
            price = "0";
        }
        String count = (String) pud.get("P_COUNT");
        if ("".equals(count)) {
            count = "0";
        }
        return baseDao.doDML(sql, pud.get("P_NAME"), pud.get("P_CODE"),
                pud.get("P_TYPE"),
        Double.parseDouble(price), Integer.parseInt(count),
                pud.get("P_UNIT"),
                pud.get("P_METERIAL"), pud.get("P_TIME"),
                pud.get("P_DESCRIPTION"), pud.get("ID"));
    }
    public List<Map<String, Object>> qeuryProduct(String p_name, String p_code)
    {
        String sql = "select * from t_product where 1=1";
        if (!"".equals(p_name) && p_name != null) {
            sql += " and P_NAME like '%" + p_name + "%'";
        }
        if (!"".equals(p_code) && p_code != null) {
            sql += " and P_CODE like '%" + p_code + "%'";
        }
        return baseDao.query(sql);
    }
}