<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>品牌管理</title>
</head>
<body>
	<table class="table">
		<Tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		</Tr>
		<c:forEach items="${info.list}" var="brand">
			<Tr>
				<td>${brand.id}</td>
				<td>${brand.name}</td>
				<td>${brand.firstChar}</td>
				<td>${brand.deletedFlag}</td>
			</Tr>
		</c:forEach>
	</table>
</body>
</html>