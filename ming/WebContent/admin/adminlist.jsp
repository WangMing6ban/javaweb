<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<center>
<br/><br/>
<table width="70%">
<tr>
<td>编号</td>
<td>名称</td>
<td>密码</td>
<td>EMAIL</td>
<td></td>
<td>操作</td>
</tr>
<c:forEach items="${adminlist}" var="user">
<tr>
<td>${user.id }</td>
<td>${user.admin_username }</td>
<td>${user.admin_passwd }</td>
<td>${user.admin_email }</td>
<td></td>
<td><a href="deleteadmin.action?id=${user.id}">删除</a></td>
|
</tr> 
</c:forEach>


</table>

<br/><br/><br/><br/>
</center>

</body>
</html>