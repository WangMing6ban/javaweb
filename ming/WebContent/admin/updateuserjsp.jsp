<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/xiugaiuser.action?id=${id}"  method="post">
						<table>
							<tr>
								<td>旧密码</td>
								<td><input type="password" name="password" placeholder="填入旧密码" onblur="mimayanzheng(this.value);"></td>
								<td><span id="spand"></span></td>
							</tr>
							
							</br>
							<tr>
								<td>新密码:</td>
								<td><input type="password" name="user_passwd"></td>
							</tr>
							</br>
							<tr>
								<td>确认新密码:</td>
								<td><input type="password" name="reuser_passwd"></td>
							</tr></br>
							<tr>
								<td><input type="submit" value="修改"/></td>
							</tr>
						</table>
						
						
					</form>
</body>
</html>