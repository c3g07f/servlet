package com.jnmc.pudmgr.pud.servlet;

/**
 * @author C3g07f
 * @date 2023/5/5 11:38
 */
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.jnmc.pudmgr.pud.service.PudService;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Servlet implementation class PudServlet
 */
public class PudServlet extends HttpServlet implements Servlet {
    private static final long serialVersionUID = 1L;
    private PudService pudService = new PudService();
    @Override
    public void service(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String method = request.getParameter("method");
        System.out.println("method--->" + method);
        if ("query".equals(method)) {
            this.queryAll(request, response);
        } else if ("add".equals(method)) {
            this.add(request, response);
        } else if ("delete".equals(method)) {
            this.delete(request, response);
        } else if ("toUpdate".equals(method)) {
            this.toUpdate(request, response);
        } else if ("update".equals(method)) {
            this.update(request, response);
        } else if ("queryProduct".equals(method)) {
            this.queryProduct(request, response);
        }
    }
    /**
     * 根据条件查询
     *
     * @param request
     * @param response
     */
    private void queryProduct(ServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        String P_NAME = request.getParameter("p_name");
        String P_CODE = request.getParameter("p_code");
        System.out.println("查询条件：" + P_NAME + "-->" + P_CODE);
        List<Map<String, Object>> pudlist = pudService.qeuryProduct(P_NAME,
                P_CODE);
        System.out.println(pudlist);
        JSONArray res = JSONArray.parseArray(JSON.toJSONString(pudlist));
        PrintWriter out = response.getWriter();
        out.write(res.toJSONString());
        out.flush();
        out.close();
    }
    private void update(ServletRequest request, ServletResponse response) throws
            ServletException, IOException {
        Enumeration<String> eum = request.getParameterNames();
        Map<String, Object> pud = new HashMap<String, Object>();
        while (eum.hasMoreElements()) {
            String paramName = eum.nextElement();
            Object value = request.getParameter(paramName);
            pud.put(paramName, value);
        }
        System.out.println(pud);
// 调
        int res = pudService.upd(pud);
        this.queryAll(request, response);
    }
    private void toUpdate(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        String id = request.getParameter("pid");
        System.out.println("id---->" + id);
        Map<String, Object> pud = pudService.findOne(id);
        System.out.println(pud);
        request.setAttribute("pud", pud);
        request.getRequestDispatcher("jsp/pudmgr/update.jsp").forward(request,
                response);
    }
    /**
     * 删除
     *
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    private void delete(ServletRequest request, ServletResponse response) throws
            ServletException, IOException {
        String id = request.getParameter("pid");
        System.out.println("id---->" + id);
        int res = pudService.delete(id);
        System.out.println(res);
        if (res == 1) {
            PrintWriter out = response.getWriter();
            out.write("cg");
            out.flush();
            out.close();
        } else {
            PrintWriter out = response.getWriter();
            out.write("sb");
            out.flush();
            out.close();
        }
    }
    /**
     * 添加商品
     *
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    private void add(ServletRequest request, ServletResponse response) throws
            ServletException, IOException {
        Enumeration<String> eum = request.getParameterNames();
        Map<String, Object> pud = new HashMap<String, Object>();
        while (eum.hasMoreElements()) {
            String paramName = eum.nextElement();
            Object value = request.getParameter(paramName);
            pud.put(paramName, value);
        }
        System.out.println(pud);
// 调
        int res = pudService.add(pud);
// 转
        this.queryAll(request, response);
    }
    /**
     * 查询所有商品信息
     *
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    private void queryAll(ServletRequest request, ServletResponse response)
            throws ServletException, IOException {
        List<Map<String, Object>> pudlist = pudService.queryAll();
        System.out.println(pudlist);
        request.setAttribute("pudlist", pudlist);
        request.getRequestDispatcher("jsp/pudmgr/pudlist.jsp").forward(request,
                response);
    }
}