<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
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
	                   <c:forEach items="${slist }" var="s">
	                    <li><a href="${pageContext.request.contextPath}/type.action?type_id=${s.id}">按类别显示：${s. type_name}</a></li>
	                   </c:forEach>
	                    <li><a href="${pageContext.request.contextPath}/bookuser.action">全部商品列表</a></li>
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
	<a href="http://jigsaw.w3.org/css-validator/check/referer"><img style="border:0;width:88px;height:31px"  src="http://jigsaw.w3.org/css-validator/${pageContext.request.contextPath}/images/vcss-blue" alt="Valid CSS!" vspace="8" border="0" /></a>
				</div>
	        </div> <!-- end of content left -->
	        
	        <div id="templatemo_content_right">
	        	<div class="templatemo_product_box">
	            	<h1>Photography  <span>(by Best Author)</span></h1>
	   	      <img src="${pageContext.request.contextPath}/images/templatemo_image_01.jpg" alt="image" />
	                <div class="product_info">
	                	<p>Etiam luctus. Quisque facilisis suscipit elit. Curabitur...</p>
	                  <h3>$55</h3>
	                    <div class="buy_now_button"><a href="${pageContext.request.contextPath}/cart.action?operate=addCart&id=${book.book_id}">Buy Now</a></div>
	                    <div class="detail_button"><a href="subpage.html">Detail</a></div>
	                </div>
	                <div class="cleaner">&nbsp;</div>
	            </div>
	            
	            <div class="cleaner_with_width">&nbsp;</div>
	            
	            <div class="templatemo_product_box">
	            	<h1>Cooking  <span>(by New Author)</span></h1>
	       	    <img src="${pageContext.request.contextPath}/images/templatemo_image_02.jpg" alt="image" />
	                <div class="product_info">
	                	<p>Aliquam a dui, ac magna quis est eleifend dictum.</p>
	                    <h3>$35</h3>
	                    <div class="buy_now_button"><a href="subpage.html">Buy Now</a></div>
	                    <div class="detail_button"><a href="subpage.html">Detail</a></div>
	                </div>
	                <div class="cleaner">&nbsp;</div>
	            </div>
	            
	            <div class="cleaner_with_height">&nbsp;</div>
	            
	            <div class="templatemo_product_box">
	            	<h1>Gardening <span>(by Famous Author)</span></h1>
	   	      <img src="${pageContext.request.contextPath}/images/templatemo_image_03.jpg" alt="image" />
	                <div class="product_info">
	                	<p>Ut fringilla enim sed turpis. Sed justo dolor, convallis at.</p>
	                    <h3>$65</h3>
	                    <div class="buy_now_button"><a href="subpage.html">Buy Now</a></div>
	                    <div class="detail_button"><a href="subpage.html">Detail</a></div>
	                </div>
	                <div class="cleaner">&nbsp;</div>
	            </div>
	            
	            <div class="cleaner_with_width">&nbsp;</div>
	            
	            <div class="templatemo_product_box">
	            	<h1>Sushi Book  <span>(by Japanese Name)</span></h1>
	            	<img src="${pageContext.request.contextPath}/images/templatemo_image_04.jpg" alt="image" />
	                <div class="product_info">
	                	<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. </p>
	                    <h3>$45</h3>
	                    <div class="buy_now_button"><a href="subpage.html">Buy Now</a></div>
	                    <div class="detail_button"><a href="subpage.html">Detail</a></div>
	                </div>
	                <div class="cleaner">&nbsp;</div>
	            </div>
	            
	            <div class="cleaner_with_height">&nbsp;</div>
	            <div>
		            <a href="subpage.html"><img src="${pageContext.request.contextPath}/images/templatemo_ads.jpg" alt="ads" /></a>
		        </div> <!-- end of content right -->
	    
	    	<div class="cleaner_with_height">&nbsp;</div>
	    </div> <!-- end of content -->
    	<%@include file="footer.jsp" %>
</div> <!-- end of container -->
<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>
