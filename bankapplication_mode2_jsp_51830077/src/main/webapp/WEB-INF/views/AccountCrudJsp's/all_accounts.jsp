<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">GUPPI'S BANK</h1>
<br></br>
<br></br>
<br></br>
<table align="center" border="1">
<thead>
	<tr>
	<th>accountNumber</th>
	<th>accountBalance</th>
	<th>type</th>
	<th>blocked</th>
	<th>block</th>
	<th>customerDetails</th>
	<th>delete</th>
	</tr>
</thead>
<tbody>
<c:forEach items="${accounts}" var="account">
	<tr>
	<td>${account.accountNumber}</td>
	<td>${account.accountBalance}</td>
	<td>${account.type}</td>
	<td>${account.blocked}</td>
	
	<td><a href="block?id=${account.accountNumber}">block</a></td>
	<td><a href="customer?id=${account.accountNumber}">CustomerDetails</a></td>
	<td><a href="delete?id=${account.accountNumber}">delete</a></td>
	</tr>
</c:forEach>

</tbody>
</table>
<a href="blockedaccounts">Click here to see the blocked accounts</a>
</body>
</html>