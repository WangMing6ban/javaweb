<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购物车列表</title>
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
	                    <li><a href="${pageContext.request.contextPath}/kan.action">全部商品列表</a></li>
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
		         <div id="gouwuche">
					<form action="order.action?caozuo=create" method="post" name="productForm" id="productForm">
					<script type="text/javascript">
					
					function changeNum(){
						console.log("123");
						var names = document.getElementsByName("count");
						var flag=true;
						for(var i=0;i<names.length;i++){
							if(names[i].value==0){
								flag=false;
							}
							console.log("123");
						}
						console.log("123");
						if(flag){
							 document.productForm.action="setProductCart.action?";
								
								
							document.productForm.submit();
						}else{
							alert("数量不能为0，如不想购买可删除");
						}
					}
					
					</script>
					
					
					
					<table border="0" cellspacing="0" cellpadding="0" >
						<tr>
							<td height="35px">商品名称</td>
							<td>商品单价</td>
							<td>购买数量</td>
							<td width="40px">操作</td>
						</tr>
						<c:forEach items="${productCart}" var="productUnit">
						<tr>
							<td height="35px" align="center">${productUnit.product.book_name}</td>
							<td align="center">${productUnit.product.book_price}</td>
							<td><input type="hidden" name="productid"
									value="${productUnit.product.id}" /><input type="text" name="count" id="count" value="${productUnit.count}" onblur="changeNum(this.value)"/></td>
							<td><a href="${pageContext.request.contextPath }/cart.action?operate=delete&id=${productUnit.product.id}">删除</a></td>	
						</tr>
						</c:forEach>
						<tr colspan="4">		
								<td height="35px"><a href="${pageContext.request.contextPath }/user/index.jsp">继续购物</a> &nbsp;</td>
								<td><input type="submit" value="生成订单"/> &nbsp;</td>
								<td><a href="${pageContext.request.contextPath }/cart.action?operate=clear">清空购物车</a>	</td>		
						</tr>
						<tr colspan="4" align="center">
							<td>
								 总价:￥ ${totalcost} 
							</td>
						</tr>
					
					</table>
						
					</form>
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