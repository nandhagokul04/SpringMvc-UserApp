<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>F
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
     <form:form modelAttribute="u" action="register" method="post">
	
	<form:label path="name">Name</form:label>
	<form:input path="name"/>
	<br>
	<form:label path="phone">Phone number</form:label>
	<form:input path="phone"/>
	<br>
	<form:label path="gender">Gender</form:label>
	<form:radiobutton path="gender" value="male"/>Male
	<form:radiobutton path="gender" value="female"/>Female
	<br>
	<form:label path="age">Age</form:label>
	<form:input path="age"/>
	<br>
	<form:label path="email">Email</form:label>
	<form:input path="email"/>
	<br>
	<form:label path="password">Password</form:label>
	<form:input path="password"/>
	<br>
	<form:button>REGISTER</form:button>
	</form:form>
</body>
</html>