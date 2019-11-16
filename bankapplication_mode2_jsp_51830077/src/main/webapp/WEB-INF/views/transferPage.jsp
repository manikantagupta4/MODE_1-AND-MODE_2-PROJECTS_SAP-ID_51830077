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
<h3>Amount Transfer machine</h3><br><br/>
<form:form action="transfer" method="post" modelAttribute="transferBean">

Enter the From account number<form:input path="fromaccount"/><br></br>
Enter the To account number<form:input path="toaccount"/><br></br>
Enter the amount<form:input path="amount"/><br></br>
<input type="submit">
</form:form>
</body>
</html>