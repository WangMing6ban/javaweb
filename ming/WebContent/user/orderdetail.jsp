<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单详情</title>
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
	        	<div id="xinga">
					<table>
						<tr>
								<td>订单号</td>
					            <td>书名</td>
					            <td>数量</td>
					            <td>单价</td>
						</tr>
						
					
						<c:if test="${fn:length(sessionScope.detail)>1}">
					   
					   	<c:forEach items="${detail}" var="odd">
					   	 <tr>
					            <td>${orderid}</td>
					            <td>${odd.book.book_name}</td>
					            <td>${odd.count}</td>
					            <td>${odd.book. book_price}</td>
					     </tr>       
								
					   </c:forEach>
					   
					   </c:if>
					    <c:if test="${fn:length(sessionScope.detail)==1 }">
					   
					            <tr>
					            	<td width="50px">${orderid}</td>
									<td>${detail[0].book.book_name}</td>
									<td align="center">${detail[0].count}</td>
									<td>${detail[0].book.book_price}</td>
								</tr>
					  
					   
					   </c:if>
					</table>
			</div>
			<div >
					<a href="subpage.html"><img src="${pageContext.request.contextPath}/images/templatemo_ads.jpg" alt="ads" /></a>
			 	</div>
			 </div> <!-- end of content right -->
	    	 <div class="cleaner_with_height">&nbsp;</div>
	    </div> <!-- end of content -->
		<%@include file="footer.jsp" %>
</div> <!-- end of container -->
<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>
