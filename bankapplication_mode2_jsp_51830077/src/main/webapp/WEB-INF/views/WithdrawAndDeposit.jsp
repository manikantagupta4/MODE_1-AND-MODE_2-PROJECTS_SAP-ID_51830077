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
<h3>Deposit Machine</h3><br><br/>
<form:form action="deposit" method="post" modelAttribute="withdrawAndDepositBean">

Enter the account number<form:input path="accountNumber"/><br></br>
Enter the amount<form:input path="amount"/><br></br>
<input type="submit">
</form:form>
<br><br/>
<br><br/>
<h3>Withdraw Machine</h3>
<br><br/>
<form:form action="withdraw" method="post" modelAttribute="withdrawAndDepositBean">

Enter the account number<form:input path="accountNumber"/><br></br>
Enter the amount<form:input path="amount"/><br></br>
<input type="submit">
</form:form>
</body>
</html>