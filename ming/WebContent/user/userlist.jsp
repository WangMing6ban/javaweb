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
<form action="" name="form1" id="form1" method="post">
<center>
<br/><br/>
<table width="70%">
<tr>
<td>用户编号</td>
<td>用户名称</td>
<td>用户密码</td>
<td>用户EMAIL</td>
<td>用户头像</td>
<td>操作</td>
</tr>
<c:forEach items="${userlist}" var="user">
<tr>
<td>${user.id }</td>
<td>${user.user_username }</td>
<td>${user.user_passwd }</td>
<td>${user.user_email }</td>
<td><img height="50" width="40" border="30" src="${pageContext.request.contextPath}/${user.user_imgurl}"/>
<td>&nbsp;<a href="deleteuser.action?id=${user.id}">删除</a>
	
</td>

</tr> 
</c:forEach>


</table>
<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/ttju.action?">添加用户</a></div>
<br/><br/><br/><br/>
</center>
</form>
</body>
</html>