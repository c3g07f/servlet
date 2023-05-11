<%--
  Created by IntelliJ IDEA.
  User: GodDustin
  Date: 2023/5/4
  Time: 22:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> <title>产品信息</title>
  <link rel="stylesheet" type="text/css"
        href="/css/bootstrap.min.css">
  <script type="text/javascript" src="/js/productController.js"></script>
  <script type="text/javascript" src="/js/jquery.js"></script>
</head>
<body style="padding-top: 100px;">
<div class="container" >
  <div class="col-md-12 ">
    <input type="hidden" id="url" value="/pud?method=delete">
    <h3>产品列表</h3>
    <br>
    <%--查询区域--%>
    <div class="form-inline">
      <div class="form-group">
        <input class="form-control" id="P_NAME" name="P_NAME" placeholder="请输入产品名称">
      </div>
      <div class="form-group">
        <input class="form-control" id="P_CODE" name="P_CODE" placeholder="请输入产品编码">
      </div>
      <button class="btn btn-success "
              onclick="queryProduct()">查询
      </button>
    </div>
    <hr>
    <%--列表区域--%>
    <button class="btn btn-info btn-sm"
            onclick="window.location.href='/jsp/pudmgr/add.jsp'">新增
    </button>

    <table class="table">
      <thead class="text-center">
      <td>序号</td>
      <td>产品名称</td>
      <td>产品编码</td>
      <td>产品分类</td>
      <td>单价(元)</td>
      <td>数量</td>
      <td>计量单位</td>
      <td>材质</td>
      <td>生产日期</td>
      <td>产品描述</td>
      <td>操作</td>
      </thead>
      <tbody class="text-center" id="productList" >
      <c:forEach items="${pudlist }" var="pud" varStatus="s"> <tr>
        <td>${s.index+1 }</td>
        <td>${pud.P_NAME}</td>
        <td>${pud.P_CODE}</td>
        <td>${pud.P_TYPE}</td>
        <td>${pud.P_PRICE}</td>
        <td>${pud.P_COUNT}</td>
        <td>${pud.P_UNIT}</td>
        <td>${pud.P_METERIAL}</td>
        <td>${pud.P_TIME}</td>
        <td>${pud.P_DESCRIPTION}</td>
        <td>
          <a class="btn-sm btn-success"
             href="/pud?method=toUpdate&pid=${pud.ID }">修改
          </a> &nbsp
          <a class="btn-sm btn-danger" onclick="doDel(${pud.ID})">删除
          </a>
        </td>
        </c:forEach>
      </tbody>
    </table>
  </div>
</div>
</body>
</html>
