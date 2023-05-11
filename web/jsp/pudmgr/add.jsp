<%--
  Created by IntelliJ IDEA.
  User: GodDustin
  Date: 2023/5/5
  Time: 11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>添加产品</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/bootstrap.min.css">
</head>
<body style="padding-top: 100px;">
<div class="container">
    <div class="col-md-12 ">
        <h3 >添加产品</h3>
        <br>
        <form action="${pageContext.request.contextPath }/pud?method=add" method="post" onsubmit="return add()">
            <div class="form-group">
                <table class = "table">
                    <tr>
                        <td  >产品名称</td>
                        <td colspan="3"><input style="width: 100%" name = "P_NAME" id="P_NAME" required></td>
                        <td>产品编码</td>
                        <td ><input id="P_CODE" name="P_CODE" required></td>
                    </tr>
                    <tr>
                        <td>产品分类</td>
                        <td><input id="P_TYPE" name = "P_TYPE" required></td>
                        <td>数量</td>
                        <td><input type="number" id="P_COUNT" name = "P_COUNT" required></td>
                        <td>计量单位</td>
                        <td><input id="P_UNIT" name = "P_UNIT" required></td>
                    </tr>
                    <tr>
                        <td>单价(元)</td>
                        <td><input  id="P_PRICE" name = "P_PRICE" required></td>
                        <td>材质</td>
                        <td><input id="P_METERIAL" name = "P_METERIAL" required></td>
                        <td>生产日期</td>
                        <td><input id="P_TIME" name = "P_TIME" placeholder="yyyy-mm-dd" required></td>
                    </tr>
                    <tr>
                        <td>产品描述</td>
                        <td colspan="6" rowspan="4"><textarea style="height: 100px;width: 100%;" id="P_DESCRIPTION" name = "P_DESCRIPTION" required></textarea></td>
                    </tr>
                </table>
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-success" >保存</button>
                <a class="btn btn-warning"	href="${pageContext.request.contextPath }/pud?method=query">取消</a>
                <br>
                <br>
                <span id="mes" style="color:red"></span>
            </div>
        </form>
    </div>
</div>
</body>
</html>