package com.jnmc.jdbc;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 * 此处是对jdbc连接数据库代码的封装
 *
 * @author C3g07f
 * @date 2023/5/3 17:06
 */

public class JdbcHelper {
    private static String driver;
    private static String url = null;
    private static String user;
    private static String password;
    private static int size = 0;
    // 声明一个容器存放connection对象(充当连接池)
    private static List<Connection> pool = new LinkedList<Connection>();

    static {
        ResourceBundle rb =
                PropertyResourceBundle.getBundle("com/jnmc/jdbc/datasource");
        driver = rb.getString("datasource.driver");
        url = rb.getString("datasource.url");
        user = rb.getString("datasource.user");
        password = rb.getString("datasource.password");
        size = Integer.parseInt(rb.getString("datasource.size"));
// 加载驱动(连接哪种数据库，就加载哪个数据库驱动)
        try {
            Class.forName(driver);
        } catch (Exception e) {
            System.out.println("数据库驱动加载失败！！！");
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接
     *
     * @return
     * @throws SQLException
     */
    public Connection getConnection() throws SQLException {
        Connection conn = null;
// 根据 url user password 获得与目标数据库的连接
// 先判断数pool中是否有数
        if (pool.size() > 0) {
            conn = pool.remove(0);
        } else {
            conn = DriverManager.getConnection(url, user, password);
        }
        return conn;
    }

    /**
     * 关闭连接，释放资源
     *
     * @param conn
     * @param stmt
     * @param rs
     */
    public void closeConnection(Connection conn, Statement stmt, ResultSet rs) {
        try {
// 先用后关
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
// 如果数据库连接池还有地方就将Connection对象放入连接池中
                if (pool.size() < size) {
                    pool.add(conn);
                } else {
                    conn.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭非查询语句的连接
     *
     * @param conn
     * @param stmt
     */
    public void closeConnection(Connection conn, Statement stmt) {
        this.closeConnection(conn, stmt, null);
    }

    /**
     * @param conn
     */
    public void closeConnection(Connection conn) {
        this.closeConnection(conn, null, null);
    }
}


