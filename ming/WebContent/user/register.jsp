<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  
    String path = request.getContextPath();  
    String basePath = request.getScheme() + "://"  
            + request.getServerName() + ":" + request.getServerPort()  
            + path + "/";  
%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册页面</title>
<link href="${pageContext.request.contextPath}/css/templatemo_style.css" rel="stylesheet" type="text/css" />
<script>
//在开发者工具中，console中查看错误，f12     加断点
//用户名的验证
function yanzheng(username){
	//将username传递到服务器,然后判断用户名是否已经存在  
    //<1>创建xmlHttpRequest对象:js发送请求到服务器  
  
    if(document.getElementById("spanid")!=null){
    	document.getElementById("spanid").innerHTML="";
    }
    
    var xmlhttp; 
	if(username==""){
		document.getElementById("spanid").innerHTML="";
	}else{
	    if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari  
	        xmlhttp = new XMLHttpRequest();  
	    } else {// code for IE6, IE5  
	        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");  
	    }  
	   
	    xmlhttp.open("POST", "registerr.action", true);  
	  
	    xmlhttp.setRequestHeader("Content-type",  
	            "application/x-www-form-urlencoded");  
	    xmlhttp.send("username=" +username);  
	    console.log("123");
	    xmlhttp.onreadystatechange = function() {  
	        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {    
	            var response = xmlhttp.responseText;     
	            response = JSON.parse(response);    
	            if (response.flag) {  
	                document.getElementById("spanid").innerHTML = response.content;  
	            }
	            if(!response.flag){
	            	document.getElementById("spanid").innerHTML = response.content; 
	            }  
	        }  
	    };  
	}
}
//验证用户名密码邮箱 的格式
function shenhe(){
	var password=document.getElementById("password");
	var repassword=document.getElementById("repassword");
	var email=document.getElementById("email");
	var password_=/^[a-zA-Z_0-9]{6,20}$/;
	var email_ = /\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*/;  
	if(password==null||password.value==null){
		alert("密码不能为空");
		return false;
	}else if(password.value.match(password_)==null){
		 alert("您输入的密码与规定类型不匹配");
	     return false;
	}else if(password.value!=repassword.value){
		 alert("您输入的密码不一致");
		  return false;
	}else if(email==null||email.value==null){
		console.log("12567");
		alert("邮箱不能为空");
		return false;
	}else if(email.value.match(email_)==null){
		alert("邮箱的格式不正确");
		return false;
		
	}
	return true;
}

	

</script>
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
	        	<div id="ling">读万卷书，行万里路,fighting!!!</div>
				<div id="from">
				<form action="register.action" method="post" enctype="multipart/form-data" onsubmit="return shenhe();">
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
				</div>
				<div >
					<a href="subpage.html"><img src="./images/templatemo_ads.jpg" alt="ads" /></a>
			 	</div>
			 </div> <!-- end of content right -->
	    	 <div class="cleaner_with_height">&nbsp;</div>
	    </div> <!-- end of content -->
    	<%@include file="footer.jsp" %>
</div> <!-- end of container -->
<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>
	    	