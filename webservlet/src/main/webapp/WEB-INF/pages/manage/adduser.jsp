<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%
	String contextPath=request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加用户</title>
</head>
<body>
	<form action="<%=contextPath %>/submituser"
		method="post">
		用户名：<input type="text" name="username" value="${formbean.username }" />${formbean.errors.username }<br> 
		密码：<input type="text" name="password" value="${formbean.password }"/>${formbean.errors.password }<br>
		 启用:<input type="radio" name="isEnable" value="1" checked="checked">启用<input type="radio"
			name="isenable" value="0">禁用<br> 角色：<select name="level">
			<option value="2" selected="selected">用户</option>
			<option value="1">管理员</option>
		</select> <br> <input type="submit" value="提交">
	</form>
</body>
</html>