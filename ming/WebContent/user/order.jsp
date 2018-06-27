<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单列表</title>
<link href="${pageContext.request.contextPath}/css/templatemo_style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="templatemo_container">
	<%@include file="header.jsp" %>
	<div id="templatemo_content">
	    	
	        <div id="templatemo_content_left">
	        	<div class="templatemo_content_left_section">
	            	<h1>Categories</h1>
	                 <ul>
	                    <li><a href="${pageContext.request.contextPath}/hotProduct.action?book_state=hotproduct">热门商品</a></li>
	                    <li><a href="${pageContext.request.contextPath}/newProduct.action?book_state=newproduct">最新商品</a></li>
	                    <li><a href="${pageContext.request.contextPath}/type.action?type_id=2">按类别显示：数学</a></li>
	                    <li><a href="${pageContext.request.contextPath}/type.action?type_id=1">按类别显示：软件</a></li>
	                    <li><a href="${pageContext.request.contextPath}/type.action?type_id=3">按类别显示：英语</a></li>
	                    <li><a href="#">全部商品列表</a></li>
	                    <li><a href="#">Suspen disse</a></li>
	                    <li><a href="#">Maece nas metus</a></li>
	                    <li><a href="#">In sed risus ac feli</a></li>
	            	</ul>
	            </div>
				<div class="templatemo_content_left_section">
	            	<h1>Bestsellers</h1>
	                <ul>
	                    <li><a href="#">Vestibulum ullamcorper</a></li>
	                    <li><a href="#">Maece nas metus</a></li>
	                    <li><a href="#">In sed risus ac feli</a></li>
	                    <li><a href="#">Praesent mattis varius</a></li>
	                    <li><a href="#">Maece nas metus</a></li>
	                    <li><a href="#">In sed risus ac feli</a></li>
	                    <li><a href="http://sc.chinaz.com/" target="_parent">Flash Templates</a></li>
	                    <li><a href="http://sc.chinaz.com/" target="_parent">CSS Templates</a></li>
	                    <li><a href="http://sc.chinaz.com/" target="_parent">Web Design</a></li>
	                    <li><a href="http://sc.chinaz.com/" target="_parent">Free Photos</a></li>
	            	</ul>
	            </div>
	            
	            <div class="templatemo_content_left_section">                
	                <a href="http://validator.w3.org/check?uri=referer"><img style="border:0;width:88px;height:31px" src="http://www.w3.org/Icons/valid-xhtml10" alt="Valid XHTML 1.0 Transitional" width="88" height="31" vspace="8" border="0" /></a>
	<a href="http://jigsaw.w3.org/css-validator/check/referer"><img style="border:0;width:88px;height:31px"  src="http://jigsaw.w3.org/css-validator/../images/vcss-blue" alt="Valid CSS!" vspace="8" border="0" /></a>
				</div>
	        </div> <!-- end of content left -->
	        <div id="templatemo_content_right">
				<div id="dingdan">
					<form method="post" action="order.action?caozuo=quren">
					   选择收货地址：</br></br></br>
					   <c:if test="${addresss==null }">
					   	还没有添加收货地址，前去添加收获地址！<a href="${pageContext.request.contextPath }/user/addaddress.jsp"> 添加地址</a>
					   </c:if>
					   </br>
					   <c:if test="${sessionScope.addresss!=null}">
					   		收获地址：${addresss }
					   
					   </c:if>
					   
					      
					  </br>
						<table>
							<tr>
								<!--  <td ><input type="hidden" name="address" value="${addresss }"/>-->
								<td align="center">订单号</td>
								<td align="center">用户名</td>
								<td align="center">订单状态</td>
								<td align="center">操作</td>
							</tr>
							<c:forEach items="${orders}" var="order">
							<tr>
								<td>${order.id }</td>
								<td>${user_username}</td>
								<td>${order.order_state}</td>
								<td align="center">
									<a href="order.action?caozuo=quxiao&order_id=${order.id}">取消订单</a>
									<a href="order.action?caozuo=xiangqing&order_id=${order.id}">订单详情</a>
									
								</td>
							</tr>
							</c:forEach>
							<tr><td align="center"> <a href="order.action?caozuo=delete">删除订单</a></td></tr>
							</br>
							<tr><td><a href="order.action?caozuo=queren&order_id=${order.id}&address=${addresss}">确认订单</a></td></tr>
							
						</table>
					
					</form>
				</div>
				 <div>
	           		 <a href="subpage.html"><img src="${pageContext.request.contextPath}/images/templatemo_ads.jpg" alt="ads" /></a>
	       		 </div> <!-- end of content right -->
				</div> <!-- end of content right -->
	    	 <div class="cleaner_with_height">&nbsp;</div>
	    </div> <!-- end of content -->
		<%@include file="footer.jsp" %>
</div> <!-- end of container -->
<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>