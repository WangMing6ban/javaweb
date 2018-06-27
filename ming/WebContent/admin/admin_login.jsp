<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<HTML>
<HEAD>
<TITLE>ECSHOP 管理中心</TITLE>
<META http-equiv=Content-Type content="text/html; charset=UTF-8">
<LINK href="<%=request.getContextPath() %>/images/admin_images/general.css" type=text/css rel=stylesheet>
<LINK href="<%=request.getContextPath() %>/images/admin_images/main.css" type=text/css rel=stylesheet>
<STYLE type=text/css>
BODY {
	COLOR: white
}
</STYLE>

<SCRIPT src="<%=request.getContextPath() %>/images/utils.js" type=text/javascript></SCRIPT>
<SCRIPT src="<%=request.getContextPath() %>/images/validator.js" type=text/javascript></SCRIPT>

<META content="MSHTML 6.00.3790.1830" name=GENERATOR>
</HEAD>
<BODY style="BACKGROUND: rgb(39, 130, 150) 0% 50%; moz-background-clip: -moz-initial; moz-background-origin: -moz-initial; moz-background-inline-policy: -moz-initial" >
<FORM action="${pageContext.request.contextPath}/adminlogin.action" method="post" onsubmit="return validate();">
<TABLE style="MARGIN-TOP: 100px" cellSpacing=0 cellPadding=0
	align=center>
	<TBODY>
		<TR>
			<TD>WebShop</TD>
			<TD style="PADDING-LEFT: 50px">
			<TABLE>
				<TBODY>
					<TR>
						<TD>管理员姓名：</TD>
						<TD><INPUT name=username  id=username/></TD>
					</TR>
					<TR>
						<TD>管理员密码：</TD>
						<TD><INPUT type=password name=password id=password /></TD>
					</TR>
					<TR>
						<TD>验证码：</TD>
						<TD><INPUT class=capital name=captcha id=captcha /></TD>
					</TR>
					<TR>
						<TD align=right colSpan=2><img src="<%=request.getContextPath() %>/commons/image.jsp"  /></TD>
					</TR>
					<TR>
						<TD colSpan=2><LABEL><INPUT type=checkbox value=1
							name=remember>请保存我这次的登录信息。</LABEL></TD>
					</TR>
					<TR>
						<TD>&nbsp;</TD>
						<TD><INPUT class=button type=submit value=进入管理中心 /></TD>
					</TR>
					<TR>
						<TD align=right colSpan=2>» <A style="COLOR: white"
							href="./">返回首页</A> » </TD>
					</TR>
				</TBODY>
			</TABLE>
			</TD>
		</TR>
	</TBODY>
</TABLE>
<INPUT type=hidden value=signin name=act />
</FORM>

</BODY>
</HTML>
