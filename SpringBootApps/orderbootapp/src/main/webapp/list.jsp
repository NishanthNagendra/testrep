<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product List</title>
</head>
<body>
	<h2>Product List</h2>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Price</th>
			<th>Category</th>
		</tr>
		<c:forEach items="${products}" var="p">
			<tr>
				<td> ${p.id} </td>
				<td> ${p.name} </td>
				<td> ${p.price} </td>
				<td> ${p.category} </td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>