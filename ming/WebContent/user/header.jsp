<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<div id="templatemo_menu">
    	<ul>
            <li><a href="${pageContext.request.contextPath }/user/index.jsp" class="current">Home</a></li>
            <li><a href="${pageContext.request.contextPath }/cart.action?operate=view">bookCart</a></li>
            <li><a href="${pageContext.request.contextPath }/order.action?caozuo=view">orders</a></li>            
            <li><a href="${pageContext.request.contextPath }/userdetail.action">user detail</a></li>  
            <li><a href="${pageContext.request.contextPath }/user/register.jsp">register</a></li> 
            <li><a href="${pageContext.request.contextPath }/user/login.jsp">login</a></li>
            <li><a href="${pageContext.request.contextPath }/admin/admin_login.jsp">adminlogin</a></li>
    	</ul>
    </div> <!-- end of menu -->
    
    <div id="templatemo_header">
    	<div id="templatemo_special_offers">
        	<p>
                <span>热门商品</span> 
        点击readmore进入热门商品
        	</p>
			<a href="subpage.html" style="margin-left: 50px;">Read more...</a>
        </div>
        
        
        <div id="templatemo_new_books">
        	<ul>
                <li>最新商品点击readmore</li>
                <li>Maece nas metus</li>
                <li>In sed risus ac feli</li>
            </ul>
            <a href="subpage.html" style="margin-left: 50px;">Read more...</a>
        </div>
    </div> <!-- end of header -->