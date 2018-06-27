<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户详细信息</title>
<link href="${pageContext.request.contextPath }/css/templatemo_style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="templatemo_container">
	<%@include file="header.jsp" %>
	<div id="templatemo_content">
	    	
	        <div id="templatemo_content_left">
	        	<div class="templatemo_content_left_section">
	            	<h1>Categories</h1>
	                 <ul>
	                    <li><a href="subpage.html">Donec accumsan urna</a></li>
	                    <li><a href="subpage.html">Proin vulputate justo</a></li>
	                    <li><a href="#">In sed risus ac feli</a></li>
	                    <li><a href="#">Aliquam tristique dolor</a></li>
	                    <li><a href="#">Maece nas metus</a></li>
	                    <li><a href="#">Sed pellentesque placerat</a></li>
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
	        
	        <div id="xiangxi">填写详细信息，遇见更真实的你！</div></br></br>
	       
			<div id="from">
	        <form action="${pageContext.request.contextPath}/xiangxi.action" method="post">
	        	<table>
	        	<tr>
	        		<td>用户名：${yonghu.user_username}</td>
	        		<td>头像：</td>
	        		<td><img style="border:0;width:30px;height:31px" src="${pageContext.request.contextPath }/${yonghu.user_imgurl }" alt="ads" /></td>
		        	<td>个人详细信息：兴趣爱好</td>
		        	<td>
			        	<textarea rows="3" cols="40" name="textarea" >
						
					
						</textarea>
					</td>
				</tr>
				</br></br>
				<tr>
					<td><a href="${pageContext.request.contextPath}/user/repassword.jsp">修改密码</a></td>
				</tr>
				</br></br>
				<tr>
					<td><a href="order.action?caozuo=view">查询，删除订单</a></td>
				</tr>
				<tr>
					<td><input type="submit" value="添加信息"/></td>
				</tr>
	        	</table>
	        </form>
	        </div>
	        <div id="ming">
	         	<a href="subpage.html"><img src="${pageContext.request.contextPath }/images/templatemo_ads.jpg" alt="ads" /></a>
	       	</div>
	        </div> <!-- end of content right -->
	        <%@include file="footer.jsp" %>
</div> <!-- end of container -->
<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>
