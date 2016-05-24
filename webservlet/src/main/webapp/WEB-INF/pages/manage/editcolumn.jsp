<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="cn.lidm.domain.Columns"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	String contextPath=request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑栏目</title>
</head>
<body>
	<form action="<%=contextPath %>/submitcolumn"
		method="post">
		<table>
			<tr>
				<td>标题</td>
				<td><input type="text" name="columnName"
					value="${requestScope.column.columnName }"></td>
			</tr>
			<tr>
				<td>排序</td>
				<td><input type="text" name="orderId"
					value="${requestScope.column.orderId }"></td>
			</tr>
			<tr>
				<td>首页显示</td>
				<td><input type="radio" name="indexShow" value="1">是<input
					type="radio" name="indexShow" value="0">否</td>
			</tr>
			<tr>
				<td>禁用</td>
				<td><input type="radio" name="isenable" value="1">是<input
					type="radio" name="isenable" value="0">否</td>
			</tr>
			<tr>
				<td>删除</td>
				<td><input type="radio" name="isDel" value="1">是<input
					type="radio" name="isDel" value="0">否</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="提交"></td>
			</tr>
			<tr>
				<td colspan="2">
				<input type="hidden" name="columnId" value="${requestScope.column.columnId }" />
				</td>
			</tr>
		</table>
	</form>
	<%
		Columns column = (Columns) request.getAttribute("column");
	%>
	<script type="text/javascript">
		// 绑定删除状态
		initradio("isDel",
	<%=column.getIsDel()>-1?column.getIsDel():0%>
		);

		// 绑定删除禁用状态
		initradio("isenable",
	<%=column.getIsenable()>-1?column.getIsenable():0%>
		);

		// 绑定删除首页显示状态
		initradio("indexShow",
	<%=column.getIndexShow()>-1?column.getIndexShow():0%>
		);

		function initradio(rName, rValue) {
			var rObj = document.getElementsByName(rName);

			for (var i = 0; i < rObj.length; i++) {
				if (rObj[i].value == rValue) {
					rObj[i].checked = 'checked';
				}
			}
		}
	</script>
</body>
</html>
