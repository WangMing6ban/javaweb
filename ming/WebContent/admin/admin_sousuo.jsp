<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>搜索</title>

		<link href="${pageContext.request.contextPath}/style/style.css"
			rel="stylesheet" type="text/css">
	</head>
	<body>
		<h2>
			搜索订单
		</h2>
		<br />
		<br />
		<form
			action="${pageContext.request.contextPath}/order.action?caozuo=ss"
			method="post" name="class_form" id="class_form">

			用户名称:
			<input type="text" name="name" id="name" value="">
			<br />
			<br />
			<br />
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="submit"" name="addButton" id="addButton" value="搜索"
				 />

			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="button" name="return" id="return" value="返回"
				onclick="history.back();" />
		</form>
	</body>
</html>