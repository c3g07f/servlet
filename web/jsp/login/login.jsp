<%--
  Created by IntelliJ IDEA.
  User: GodDustin
  Date: 2023/5/4
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <title>登录</title>
  <link rel="stylesheet" type="text/css"
        href="/css/login.css">
  <script type="text/javascript"
          src="/js/jquery.js"></script>
  <script type="text/javascript"
          src="/js/userController.js"></script>
</head>
<body>
<div class="container">
  <h1>Login</h1>
  <input type="hidden" value="/login"
         id="url">
  <div class="login-form">
    <input type="text" class="tbx" placeholder="账号" name="account"
           id="account" >
    <input type="password" class="tbx" placeholder="密码" name="password"
           id="password" >
    <button class="sub" onclick="loginCheck()">登录</button>
  </div>
  <span id="mes" style="color:#ff1500"></span>
  <a class="reg" href="${pageContext.request.contextPath }/jsp/reg/reg.jsp">没
    有账号？-->去注册</a>
</div>

</body>
</html>