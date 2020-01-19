<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Product Form</h3>
	<form:form action="addproduct.do" modelAttribute="product">
		Name <form:input path= "name" /> <br />
		Price <form:input path= "price" /> <br />
		Category <form:input path= "category" /> <br />
		Quantity <form:input path= "qty" /> <br />
		<button type="submit">Add Product</button>
	</form:form>
</body>
</html>