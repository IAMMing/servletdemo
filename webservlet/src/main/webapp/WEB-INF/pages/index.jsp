<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page isELIgnored="false"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
 <%
 String contextPath=request.getContextPath();
 String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+contextPath+"/";
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%-- <base href="<%=basePath%>"></base> --%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎来到我的个人主页</title>
<link href="<%=contextPath %>/plugin/bootstrap-3.3.5-dist/css/bootstrap.min.css" rel="stylesheet" >

<link href="plugin/bootstrap-3.3.5-dist/css/bootstrap.min.css" rel="stylesheet" >
<!-- <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css"> -->
</head>
<body>
<div class="container-fluid">
	<div class="row">
		<div class="col-xs-4">1</div>
		<div class="col-xs-4">2</div>
		<div class="col-xs-4">3</div>
	</div>
</div>
<ul>
<c:forEach step="1" items="${requestScope.columns }" var="item">
<li>${item.columnName }</li>
</c:forEach>
</ul>
<h1>这是我的第一个页面</h1>
${requestScope.ldm}
<hr>
${param.ldm }
<hr>
${ldm }
<hr>
<%= request.getAttribute("ldm") %>
<hr>
aaa

<hr>
${a.id }
${a.title}
<div style=" background-image: ;text-align: center;"></div>
</body>
</html>