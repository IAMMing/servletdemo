<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isELIgnored="false" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文章列表</title>
</head>
<body>
${lst.size() }
<hr>
<table>
<tr><td>标题</td><td>内容</td></tr>
<c:forEach items="${lst }" var="item" step="1">
<tr><td>${item.title }</td><td>${item.content }</td></tr>
</c:forEach>
</table>

</body>
</html>