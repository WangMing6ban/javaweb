<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="/commons/page-taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/style/style.css"
	rel="stylesheet" type="text/css">
</head>
<body>
<center>
<table border="1" width="80%" cellpadding="0" cellspacing="0"><tr>
		<td height="27px" style="border-color: #F6F6F6;">图书ID</td>
		<td style="border-color: #F6F6F6;">图书名称</td>
		
		<td style="border-color: #F6F6F6;">图书热度</td>
		<td style="border-color: #F6F6F6;">图书价格</td>
		<td style="border-color: #F6F6F6;">图书描述</td>
		<td style="border-color: #F6F6F6;">图书图片</td>
		<td style="border-color: #F6F6F6;">图书类别</td>
		<td style="border-color: #F6F6F6;">操作</td>
	</tr>
	<c:forEach items="${booklist}" var="book">
		<tr>
			<td height="27px" style="border-color: #F6F6F6;">
			${book.id}&nbsp;</td>
			<td height="27px" style="border-color: #F6F6F6;">
			${book.book_name}&nbsp;</td>
			
			<td height="27px" style="border-color: #F6F6F6;">${book.book_state}&nbsp;</td>
			<td height="27px" style="border-color: #F6F6F6;">${book.book_price}&nbsp;</td>
			<td height="27px" style="border-color: #F6F6F6;">
			${book.book_description}&nbsp;</td>
			<td height="27px" style="border-color: #F6F6F6;">
				<img height="50" width="40" border="30" src="${pageContext.request.contextPath}/${book.book_imgurl}"/>
			&nbsp;</td>
			<td height="27px" style="border-color: #F6F6F6;">
			${book.type.type_name}&nbsp;</td>
			<td height="27px" style="border-color: #F6F6F6;">|
			<a
				href="${pageContext.request.contextPath}/delete.action?id=${book.id }">删除</a>|
			<a
				href="${pageContext.request.contextPath}/update.action?id=${book.id }">修改</a>|
			
			</td>
		</tr>
	</c:forEach>

</table>

<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

<div id="lqy_product_showpage">
共${pageCount.recordCount}条记录&nbsp;&nbsp;共 ${pageCount.count} <c:if
	test="${pageCount.isFirst}">
  &nbsp;首页&nbsp;&nbsp;上一页&nbsp;
</c:if> <c:if test="${!(pageCount.isFirst)}">
  &nbsp;<a href='book.action?pageNum=1'>首页</a>&nbsp;
  &nbsp;<a
		href='book.action?pageNum=${pageCount.showPage-1}'>上一页</a>&nbsp;
</c:if> <c:if test="${pageCount.isLast}">
  &nbsp;尾页&nbsp;&nbsp;下一页&nbsp;
</c:if> <c:if test="${!(pageCount.isLast)}">
  &nbsp;<a
		href='book.action?pageNum=${pageCount.showPage+1}'>下一页</a>&nbsp;
  &nbsp;<a
		href='book.action?pageNum=${pageCount.count}'>尾页</a>&nbsp;
</c:if> &nbsp;当前页为第 ${pageCount.showPage} 页</div>

<a href="${pageContext.request.contextPath}/admin/admin_addClass.jsp">增加类别</a></center>
</body>
</html>