<%--
  Created by IntelliJ IDEA.
  User: GodDustin
  Date: 2023/5/4
  Time: 22:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Insert title here</title>
  <link rel="stylesheet" type="text/css"
        href="/css/mylayout.css">
</head>

<body style="margin: 0;padding: 0">
<div class="menu-div">
  <ul>
    <li>
      <a href="${pageContext.request.contextPath }/pud?method=query" target="right">产品管理</a>
    </li>
    <li>
      <a href="${pageContext.request.contextPath }/pud?method=query" target="right">仓库管理</a>
    </li>
    <li>
      <a href="${pageContext.request.contextPath }/pud?method=query" target="right">出入库管理</a>
    </li>
  </ul>
</div>
</body>
</html>