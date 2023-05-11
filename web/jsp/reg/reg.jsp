<%--
  Created by IntelliJ IDEA.
  User: GodDustin
  Date: 2023/5/4
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme() + "://"
          + request.getServerName() + ":" + request.getServerPort()
          + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <base href="<%=basePath%>">

  <title>用户注册</title>

  <meta http-equiv="pragma" content="no-cache">
  <meta http-equiv="cache-control" content="no-cache">
  <meta http-equiv="expires" content="0">
  <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
  <meta http-equiv="description" content="This is my page">


  <link rel="stylesheet" type="text/css"href="${pageContext.request.contextPath }/css/reg.css" />
  <script type="text/javascript"
          src="${pageContext.request.contextPath }/js/jquery.js"></script>
  <script type="text/javascript"
          src="${pageContext.request.contextPath }/js/userController.js"></script>
</head>
<body >
<div class="container">
  <h1>Register</h1>
  <form method="post" id="regForm" action="${pageContext.request.contextPath }/reg?method=addUser">
    <input type="hidden" value="${pageContext.request.contextPath }/reg?method=checkUser" id="url">
    <input class="tbx" name="name" id="name" placeholder="请输入姓名">
    <input class="tbx" name="account" id="account" placeholder="请输入账号">
    <input class="tbx" name="password" id="password" type="password" placeholder="请输入密码">
    <input class="tbx" name="qrmm" id="qrmm" type="password" placeholder="请确认密码">
    <div class="tbx sex">
      <label class="radio-inline"><input type="radio" name="sex" id="male" value=1>男</label>
      <label class="radio-inline"><input type="radio" name="sex" id="female" value=0>女</label>
      <label class="radio-inline"><input type="radio" name="sex" id="mid" value=2>其他</label>
    </div>
    <select class="tbx" name="xl" id="xl">
      <option value="">---请选择学历---</option>
      <option value="小学">小学</option>
      <option value="初中">初中</option>
      <option value="高中">高中</option>
      <option value="本科">本科</option>
      <option value="硕士">硕士</option>
    </select>
    <textarea style="height: 60px;width: 250px;" class="tbx" name="gzll" placeholder="请输入工作履历"></textarea>
    <input type="button" class="sub" onclick="reg()" value="提交">&nbsp;&nbsp;
  </form>
  <span id="mesg" class="mesg"></span>
  <a class="toLogin" href="${pageContext.request.contextPath }"><-- 返回登录</a>
</div>
</body>
</html>
