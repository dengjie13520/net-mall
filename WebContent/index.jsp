<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>one mall</title>
<script src="./js/jquery-1.4.2.min.js"></script>
<script src="./js/myjs.js"></script>
</head>
<body id="mall_all">
	<div id="mall_top">
		<div style="float:left">Welcome to the mall!</div>
		<div id="login_register" style="float:left" >
			<c:choose>
				<c:when test="${user==null}">
					<a href="javascript:;"  onclick="my_login()">[log in]</a>
					<a href="javascript:;" onclick="my_register()"  >[register]</a>
				</c:when>
				<c:otherwise>
					Welcome! ${user } &nbsp;
					<a href="javascript:;" onclick="my_logout()"  >[log out]</a>
				</c:otherwise>
			</c:choose>
	
			
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		</div>
		<div id="my_zone" align="right" >
			
			<a href="javascript:;" >购物车 </a>&nbsp;
			<a href="javascript:;"  >用户信息</a>&nbsp;
			<a href="javascript:;"  >帮助中心</a>
			
		</div>
	</div>
	
	<div id="mall_middle">
	
	</div>
	
	<div id="mall_bottom" align="center">
		关于我们 | 联系我们 | 人才招聘 | 商家入驻 | 广告服务 | 移动终端 | 友情链接 | 销售联盟 <br />
			    北京市公安局海淀分局备案编号：11010233381  京ICP证070的4523号 <br />
   					 Copyright2004-2011  三元 商城 版权所有
	</div>
</body>
</html>