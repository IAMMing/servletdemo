<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	String contextPath=request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加文章</title>
</head>
<body>
${columns.size() }
	<form action="<%=contextPath %>/submitarticle" method="post">
	        栏目：<select name="columnId">
			 <c:forEach items="${columns }" var="item" step="1">
				<option value="${item.columnId }">${item.columnName }</option>
			 </c:forEach>
		</select> 
		${formbean.errors.columnId } <br> 
		标题：<input type="text" name="title" value="${formbean.title }">${formbean.errors.title }<br>
		内容：<textarea rows="5" cols="50"  name="content">${formbean.content }</textarea>${formbean.errors.content }
		<br>
		<input type="submit" name="提交">
	</form>
</body>
</html>