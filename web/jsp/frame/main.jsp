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
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> <title>主页</title>
</head>
<frameset rows="80,*" frameboder="no" border="0 ">
  <frame frameboder="no" border="1"src="${pageContext.request.contextPath }/jsp/frame/top.jsp" noresize="noresize" name="top"/>
  <frameset cols="200,*" frameboder="no" border="1">
    <frame scrolling="no" src="${pageContext.request.contextPath }/jsp/frame/left.jsp" noresize="noresize" name="left" frameboder="no" border="1"/>
    <frame scrolling="no" src="${pageContext.request.contextPath   }/jsp/frame/right.jsp" noresize="noresize" name="right" frameboder="no" border="1"/>
  </frameset>
</frameset>
</html>
