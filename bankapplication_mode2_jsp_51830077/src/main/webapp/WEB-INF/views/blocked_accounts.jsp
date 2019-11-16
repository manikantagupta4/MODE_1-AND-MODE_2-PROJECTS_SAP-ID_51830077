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

<h3 align="center">List of blocked accounts</h3>
<br></br>
<br></br>
<table align="center" border="1">
<thead>
	<tr>
	<th>accountNumber</th>
	<th>accountBalance</th>
	<th>type</th>
	<th>blocked</th>
	<th>unblock</th>
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
	
	<td><a href="unblock?id=${account.accountNumber}">unblock</a></td>
	
	<td><a href="customer?id=${account.accountNumber}">customerDetails</a></td>
	<td><a href="delete?id=${account.accountNumber}">delete</a></td>
	</tr>
</c:forEach>

</tbody>
</table>
<a href="allaccounts">Click here to see the accounts</a>
</body>
</html>