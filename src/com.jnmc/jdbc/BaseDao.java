package com.jnmc.jdbc;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 此处是对jdbc操作数据库方法的封装
 *
 * @author C3g07f
 * @date 2023/5/3 17:10
 */
public class BaseDao {
    private JdbcHelper ds = new JdbcHelper();

    /**
     * 根据条件查询一条数据 *
     * @param sql
     * @param params
     * @return */
    public Map<String, Object> findOne(String sql, Object... params) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Map<String, Object> result = null;
        try {
// 获得连接
            conn = ds.getConnection();
// 绑定sql
            pstmt = conn.prepareStatement(sql);
// 给参数赋值
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    pstmt.setObject(i + 1, params[i]);
                }
            }
// 执行查询
            rs = pstmt.executeQuery();

            if (rs.next()) {
// 将该对象放入Map<String,Object> 中
                result = this.getMap(rs);

            }
        } catch (Exception e) {
            System.out.println("查询出错! ! !");
            e.printStackTrace();
        } finally {
            ds.closeConnection(conn, pstmt, rs);
        }

        return result;
    }

    /**
     * 查询一条数据 *
     * @param sql
     * @return */
    public Map<String, Object> findOne(String sql) {
        return this.findOne(sql, null);
    }

    /**
     * 执行查询语句，返回查询结果List *
     * @param sql

     * @param params
     * @return */
    public List<Map<String, Object>> query(String sql, Object... params) {
        List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = ds.getConnection();
            pstmt = conn.prepareStatement(sql);
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    pstmt.setObject(i + 1, params[i]);
                }
            }
// 执行
            rs = pstmt.executeQuery();
            while (rs.next()) {
// 将记录放入Map<String,Object> 中
                Map<String, Object> resultMap = this.getMap(rs);
                resultList.add(resultMap);
            }

        } catch (Exception e) {
            System.out.println("查询失败！！");
            e.printStackTrace();
        } finally {
            ds.closeConnection(conn, pstmt, rs);
        }
        return resultList;

    }

    /**
     * 执行查询语句，返回查询结果 *
     * @param sql
     * @return */
    public List<Map<String, Object>> query(String sql) {
        return this.query(sql, null);
    }

    /**
     * 执行DML语句 *
     * @param sql
     * @param params
     * @return
     */
    public int doDML(String sql, Object... params) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        int flag = 0;

        try {

            conn = ds.getConnection();
            pstmt = conn.prepareStatement(sql);
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    pstmt.setObject(i + 1, params[i]);
                }
            }
// 执行DML
            flag = pstmt.executeUpdate();

        } catch (Exception e) {
            System.out.println("执行DML语句失败");
            e.printStackTrace();
        } finally {
            ds.closeConnection(conn, pstmt);
        }
        return flag;
    }

    /**
     * 批处理，sql改变 *
     * @param sql
     * @param paramsList
     * @return
     */
    public int[] doBatch(String sql, List<Object[]> paramsList) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        int[] result = null;
        try {
            conn = ds.getConnection();
            pstmt = conn.prepareStatement(sql);
            if (paramsList != null) {
                for (Object[] params : paramsList) {
                    if (params != null) {
                        for (int i = 0; i < params.length; i++) {
                            pstmt.setObject(i + 1, params[i]);
                        }
                    }
                    pstmt.addBatch();
                }
            }
// 执行批处理
            result = pstmt.executeBatch();
// commit
            conn.commit();

        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            System.out.println("批处理失败！！！");
            e.printStackTrace();
        } finally {
            ds.closeConnection(conn, pstmt);

        }
        return result;

    }

    /**
     * 批处理，sql不变 *
     * @param sqlList
     * @return */
    public int[] doBatch(List<String> sqlList) {
        int[] result = null;
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = ds.getConnection();
            stmt = conn.createStatement();
            if (sqlList != null) {
                for (String sql : sqlList) {
                    stmt.addBatch(sql);
                }
// 执行
                result = stmt.executeBatch();
// 提交事务
                conn.commit();
            }

        } catch (Exception e) {
// 回滚事务
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();

            }
            System.out.println("批处理执行失败！！！");
            e.printStackTrace();

        } finally {
            ds.closeConnection(conn, stmt);
        }

        return null;

    }

    /**
     * 将查询结果放入Map<String,Object> 对象中 *
     * @param rs
     * @param rsmd
     * @return
     * @throws SQLException */
    public Map<String, Object> getMap(ResultSet rs) throws SQLException { Map<String, Object> resultMap = new HashMap<String, Object>();
// 获得ResultSetMetaData 对象
        ResultSetMetaData rsmd = rs.getMetaData(); int columnCount = rsmd.getColumnCount();  for (int i = 1; i <= columnCount; i++) {
            String columnName = rsmd.getColumnName(i); Object value = rs.getObject(columnName);  resultMap.put(columnName, value);
        }

        return resultMap;
    }


}
