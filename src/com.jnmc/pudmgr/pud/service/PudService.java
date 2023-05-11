package com.jnmc.pudmgr.pud.service;
import com.jnmc.pudmgr.pud.dao.PudDao;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
/**
 * @author C3g07f
 * @date 2023/5/5 11:40
 */
public class PudService {
    private PudDao pudDao = new PudDao();
    /**
     * 查询所有商品信息
     * @return
     */
    public List<Map<String, Object>> queryAll() {
        List<Map<String, Object>> list = pudDao.queryAll();
        SimpleDateFormat sdfm = new SimpleDateFormat("yyyy-MM-dd ");
//后台处理日期格式
        for (int i = 0; i < list.size(); i++) {
            Date p_time = (Date) list.get(i).get("P_TIME");
            list.get(i).put("P_TIME", sdfm.format(p_time));
        }
        return list;
    }
    /**
     * 添加商品信息
     * @param pud
     * @return
     */
    public int add(Map<String, Object> pud) {
        return pudDao.add(pud);
    }
    /**
     * 删除
     * @param id
     */
    public int delete(String id) {
        return pudDao.delete(id);
    }
    public Map<String, Object> findOne(String id) {
        return pudDao.findOne(id);
    }
    public int upd(Map<String, Object> pud) {
        return pudDao.upd(pud);
    }
    public List<Map<String, Object>> qeuryProduct(String p_name, String p_code)
    {
        List<Map<String, Object>> list =pudDao.qeuryProduct(p_name, p_code);
        SimpleDateFormat sdfm = new SimpleDateFormat("yyyy-MM-dd ");
//后台处理日期格式
        for (int i = 0; i < list.size(); i++) {
            Date p_time = (Date) list.get(i).get("P_TIME");
            list.get(i).put("P_TIME", sdfm.format(p_time));
        }
        return list;
    }
}