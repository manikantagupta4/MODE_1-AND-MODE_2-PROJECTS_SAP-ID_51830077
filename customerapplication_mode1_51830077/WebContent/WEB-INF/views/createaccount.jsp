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

<form:form method="post" modelAttribute="user">
Enter name<form:input path="name"/><br>
Enter email<form:input path="email"/><br>
Enter password<form:input path="password"/><br>
Enter profile<form:select path="profile" items="${profileList}"/><br>
Enter active<form:select path="active" items="${activeList}"/><br>
<input type="submit">
</form:form>
</body>
</html>