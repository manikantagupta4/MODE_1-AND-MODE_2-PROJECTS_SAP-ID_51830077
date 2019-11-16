<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form:form action="create" method="post" modelAttribute="user">
<table>
<tr><td>Enter userName</td><td><form:input path="name"/></td></tr>
<tr><td>Enter password</td><td><form:input path="password"/></td></tr>
<tr><td>Enter email</td><td><form:input path="email"/></td></tr>
<tr><td>Enter status</td><td><form:input path="active"/></td></tr>
<tr>
<td>Enter roles</td>
<td>Admin<form:checkbox path="roles" value="ROLE_ADMIN"/></td>
<td>Clerk<form:checkbox path="roles" value="ROLE_CLERK"/></td>
<td>Manager<form:checkbox path="roles" value="ROLE_MGR"/></td>
</tr>
<tr><td><input type="submit"></td></tr>
</table>

</form:form>
</body>
</html>