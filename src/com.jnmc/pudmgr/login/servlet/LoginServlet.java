package com.jnmc.pudmgr.login.servlet;

/**
 * ${description}
 *
 * @author C3g07f
 * @date 2023/5/4 16:30
 */
/***
 * 处理页面请求   (接：  接前台页面传来的请求、  调：  调用service业务层进行业务 逻辑处理、  存 ：数据持久、  转：  页面请求转发)
 */

import com.jnmc.pudmgr.login.service.LoginService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;


/**
 * 登录Servlet
 */
public class LoginServlet extends HttpServlet {
    /*
    序列化 把Java对象转换为字节序列的过程
    */
    private static final long serialVersionUID = 1L;
    /*
    手动注入LoginService
    */

    private LoginService loginService = new LoginService();

    /**
     * 重写service方法
     * @param request  请求
     * @param response 响应
     * @throws ServletException Servlet异常
     * @throws IOException IO异常 */

    @Override

    protected void service(HttpServletRequest request,
                           HttpServletResponse response) throws
            ServletException, IOException {
// 设置请求编码格式
        request.setCharacterEncoding("utf-8");
// 设置响应编码格式
        response.setCharacterEncoding("utf-8");
// 获取前端输入的用户名和密码
        String account = request.getParameter("account");
        String password = request.getParameter("password");
// 打印请求参数--实际开发中检查完用户密码输入没问题之后，建议将打印输出代码注释
        System.out.println("登陆账号：" + account + "\t 密码：" + password);
// 调用service，查询用户、密码是否正确
        Map<String, Object> user = loginService.findUser(account, password); if (null != user) {
//1、用户名密码正确--登录成功
// 1.1、设置当前登陆人--首页显示使用
// 将用户信息存储到请求中
            request.getSession().setAttribute("user", user.get("NAME"));
//1.2设置当前日期--首页显示使用
            SimpleDateFormat sdfm = new SimpleDateFormat("yyyy年MM月dd日"); String date = sdfm.format(new Date());
// 将用户信息存储到请求中
            request.getSession().setAttribute("today", date);
// 1.3、将响应输出
            PrintWriter out = response.getWriter();
            out.print("登录成功");
            out.flush();
            out.close();
        } else {
//2、用户名密码错误--登录失败
            PrintWriter out = response.getWriter();
            out.print("登录失败");
            out.flush();
            out.close();
        }

    }

}