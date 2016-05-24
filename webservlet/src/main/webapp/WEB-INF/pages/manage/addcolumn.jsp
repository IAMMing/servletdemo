<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isELIgnored="false" %>
    <%
	String contextPath=request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加栏目</title>
</head>
<body>
<form action="<%=contextPath %>/submitcolumn" method="post">
栏目名称：<input type="text" name="columnName" value="${formbean.columnName }"/>${formbean.errors.columnName }<br>
<input type="submit" value="提交">
</form>
</body>
</html>