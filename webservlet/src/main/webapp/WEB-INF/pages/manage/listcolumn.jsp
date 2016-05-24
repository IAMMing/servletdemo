<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String contextPath = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>栏目列表</title>
</head>
<body>${lst.size() }<hr>

	<table>
		<tr>
			<td>编号</td>
			<td>分类名称</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${lst }" var="item" step="1">
			<tr>
				<td>${item.columnId }</td>
				<td>${item.columnName }</td>
				<td><a
					href="<%=contextPath %>/editcolumn?columnId=${item.columnId }">编辑</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>