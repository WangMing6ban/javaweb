<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@include file="/commons/page-taglibs.jsp"%>
<html>
<head>
<base href="<%=basePath%>">

<title>'admin_OrderList.jsp'</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="${pageContext.request.contextPath }/style/style.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath }/style/lqy_style.css"
	rel="stylesheet" type="text/css" />
</head>

<body>
<br>
<table align="center" border="1" width="80%" cellpadding="0"
	cellspacing="0">
	<tr>
		<td colspan="6" align="center">订单列表</td>
	</tr>
	<tr>
		<td height="27px" style="border-color: #F6F6F6;">订单ID</td>
		<td style="border-color: #F6F6F6;">客户ID</td>
		
		<td style="border-color: #F6F6F6;">订单状态</td>
		<td style="border-color: #F6F6F6;">操作&nbsp;</td>
	</tr>
	<c:forEach items="${order}" var="order">
		<tr>
			<td height="27px" style="border-color: #F6F6F6;">
			${order.id}</td>
			<td style="border-color: #F6F6F6;">${order.user.user_username}</td>
			
			<td style="border-color: #F6F6F6;">${order.order_state}</td>
			<td style="border-color: #F6F6F6;"><a
				href="${pageContext.request.contextPath}/order.action?caozuo=xiangqingadmin&id=${order.id}">详细</a>|
			<c:if test="${order.order_state=='已取消'}">
				<a
					href="${pageContext.request.contextPath}/order.action?caozuo=deleteadmin&id=${order.id}">删除</a>|
						</c:if> <c:if test="${order.order_state=='已确认'}">
				<a
					href="${pageContext.request.contextPath}/order.action?caozuo=fahuo&id=${order.id}">发货</a>|
						</c:if><c:if test="${order.order_state=='已发货'}"></c:if></td>
		</tr>
	</c:forEach>
	<div align="center">
						共${pageCount.recordCount}条记录&nbsp;&nbsp;共 ${pageCount.count}
						<c:if test="${pageCount.isFirst}">
  &nbsp;首页&nbsp;&nbsp;上一页&nbsp;
</c:if>
						<c:if test="${!(pageCount.isFirst)}">
  &nbsp;<a href='order.action?caozuo=listAll&pageNum=1'>首页</a>&nbsp;
  &nbsp;<a
								href='order.action?caozuo=listAll&pageNum=${pageCount.showPage-1}'>上一页</a>&nbsp;
</c:if>
						<c:if test="${pageCount.isLast}">
  &nbsp;尾页&nbsp;&nbsp;下一页&nbsp;
</c:if>
						<c:if test="${!(pageCount.isLast)}">
  &nbsp;<a
								href='order.action?caozuo=listAll&pageNum=${pageCount.showPage+1}'>下一页</a>&nbsp;
  &nbsp;<a href='order.action?caozuo=listAll&pageNum=${pageCount.count}'>尾页</a>&nbsp;
</c:if>
						&nbsp;当前页为第 ${pageCount.showPage} 页
					</div> 
</table>
</body>
</html>
