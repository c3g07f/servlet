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
  <link rel="stylesheet" type="text/css" href="/css/mylayout.css" />
  <title>Insert title here</title>
</head>
<body >
<div class="top-div-left">
  <p>产品管理信息系统</p>
</div>
<div class="top-div-right">
  <p>
    ${today} 您好:${user}
    <a href="${pageContext.request.contextPath }/" target="_parent">退出
    </a>
  </p>
</div>
</body>
</html>