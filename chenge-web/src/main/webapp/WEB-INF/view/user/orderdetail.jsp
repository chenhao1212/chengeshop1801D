<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<tr class="orderDetailTr">
	<td>详情</td>
	<Td colspan="5">
		<table>
			<tr>
				<th>名称</th>
				<th>价格</th>
				<th>数量</th>
			</tr>
			<c:forEach items="${orderDetails}" var="d">
				<tr>
					<td>${d.skuName}</td>
					<td>${d.total}</td>
					<td>${f.pnum}</td>
				</tr>
			</c:forEach>
			
		</table>
	</Td>
</tr>