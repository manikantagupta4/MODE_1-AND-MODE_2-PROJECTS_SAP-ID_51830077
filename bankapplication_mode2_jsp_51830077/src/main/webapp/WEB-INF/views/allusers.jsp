<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table align="center" border="1">
<thead>
	<tr>
	<th>id</th>
	<th>name</th>
	<th>email</th>
	<th>roles</th>
	<th>active</th>
	<th>phoneNumber</th>
	</tr>
</thead>
<tbody>
<c:forEach items="${users}" var="user">
	<tr>
	<td>${user.id}</td>
	<td>${user.name}</td>
	<td>${user.email}</td>
	<td>
	<c:forEach items="${user.roles}" var="roles">
	<c:out value="${roles}"></c:out>
	</c:forEach>
	</td>
	<td>${user.active}</td>
	<td>${user.phoneNumber}</td>
	<%-- <td><a href="customer?id=${account.accountNumber}">CustomerDetails</a></td>
	<td><a href="delete?id=${account.accountNumber}">delete</a></td> --%>
	</tr>
</c:forEach>

</tbody>
</table>
</body>
</html>