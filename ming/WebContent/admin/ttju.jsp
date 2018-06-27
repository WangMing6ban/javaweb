<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="tju.action" method="post" enctype="multipart/form-data" onsubmit="return shenhe();">
						<table>
							<tr>
							<td>用户名：</td>
							<td><input type="text" name="username" id="username" onblur="yanzheng(this.value)"/></td>
							<td><span id="spanid"></span></td>
							</tr>
							<br/>  
							</br>
							<tr>
							<td>密码：</td>
							<td><input type="password" name="password" id="password" /></td>
							<td><span id="write">密码不能小于6位,数字字母下滑线</span></td>
							</tr>
							<br/>
							<tr>
							<td>确认密码：</td>
							<td><input type="password" name="repassword" id="repassword"/></td>
							</tr>
							</br>
							<tr>
							<td>注册邮箱：</td>
							<td><input type="text" name="email" id="email" /></td>
							<td><span id="write">注意邮箱的格式要写正确哟</span></td>
							</tr>
							<br/>
							<tr>
							<td>头像：</td>
							<td><input type="file" name="img"/></td>
							</tr>
							<br/>
							<tr>
							<td>角色：</td>
							<td>
								<input type="radio" name="juese" value="user"/>user
								<input type="radio" name="juese" value="admin" />admin
							</td>
							</tr>
							</br>
							<tr>
							<td><input type="submit" value="提交" /></td>
							<td><input type="reset" value="重置"/></td>
							</tr>
						</table>
				</form>
</body>
</html>