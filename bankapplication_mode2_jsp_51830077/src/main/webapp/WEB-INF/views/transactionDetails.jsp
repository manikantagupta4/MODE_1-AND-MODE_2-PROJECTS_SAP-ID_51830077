<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h4 align="center">Transaction details</h4><br><br/>
<table align="center" border="1">
<thead>
<tr>
<th>id</th>
<th>amount</th>
<th>type</th>
</tr>
</thead>
<tbody>
<c:forEach items="${transactions}" var="transaction">
<tr>
<td>${transaction.id }</td>
<td>${transaction.amount }</td>
<td>${transaction.type }</td>
</tr>


</c:forEach>

</tbody>

</table>
</body>
</html>