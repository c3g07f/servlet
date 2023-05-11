package com.jnmc.pudmgr.login.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 测试
 *
 * @author C3g07f
 * @date 2023/5/5 9:16
 */
public class demoServlet extends HttpServlet {
    protected  void doGet(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h1>hello world</h1>");
        System.out.println( "请求到来了");
    }
}
