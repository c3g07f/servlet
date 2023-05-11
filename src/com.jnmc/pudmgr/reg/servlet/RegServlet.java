package com.jnmc.pudmgr.reg.servlet; /**
 * ${description}
 *
 * @author C3g07f
 * @date 2023/5/4 17:07
 */

import com.jnmc.pudmgr.reg.service.RegService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;


/**
 * Servlet implementation class Reg
 * 处理页面请求   (接：  接前台页面传来的请求、  调：  调用service业务层进行业务逻 辑处理、  存 ：数据持久、  转：  页面请求转发)
 */
public class RegServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private RegService regService = new RegService();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String method = request.getParameter("method");
        System.out.println("method---->"+method);
        if("checkUser".equals(method)){
            this.checkUser(request,response);
        }else if("addUser".equals(method)){
            this.addUser(request,response);
        }
    }

    /**
     * 注册用户
     * @param request
     * @param response
     * @throws IOException */
    private void addUser(HttpServletRequest request,
                         HttpServletResponse response) throws IOException {
        Enumeration<String> eum = request.getParameterNames();
        Map<String,Object> data = new HashMap<String,Object>();

        while(eum.hasMoreElements()){
            String param = eum.nextElement();
            data.put(param, request.getParameter(param));
        }
        System.out.println("添加用户参数："+data);
        int result = regService.addUser(data);
        if(result!=0){
            PrintWriter out = response.getWriter();
            out.write("cg");
            out.flush();
            out.close();
        }else{
            PrintWriter out = response.getWriter();
            out.write("sb");
            out.flush();
            out.close();
        }
    }

    /**
     * 检查用户是否存在
     * @param request
     * @param response
     * @throws IOException */
    private void checkUser(HttpServletRequest request,
                           HttpServletResponse response) throws IOException {

        String account = request.getParameter("account");
        System.out.println(account);
        Map<String,Object> user = regService.checkUser(account);
        System.out.println(user);
        if(null != user){
            PrintWriter out = response.getWriter();
            out.write("cf");
            out.flush();
            out.close();
        }else{
            PrintWriter out = response.getWriter();
            out.write("tg");
            out.flush();
            out.close();
        }

    }
}