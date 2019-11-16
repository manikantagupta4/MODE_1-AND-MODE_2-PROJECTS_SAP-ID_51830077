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
<br></br>
<h3 align="center">Customer Details</h3>
<br></br>
<br></br>
<table align="center" border="1">
<thead>
<tr>
<th>id</th>
<th>name</th>
<th>phone</th>
<th>email</th>
<th>address</th>
<th>update</th>
</tr>
</thead>
<tbody>

<tr>
<td>${customer.id}</td>
<td>${customer.name}</td>
<td>${customer.phone}</td>
<td>${customer.email}</td>
<td>${customer.address}</td>
<td><a href="update?id=${customer.id}">update</a></td>
</tr>




</tbody>

</table>
</body>
</html>