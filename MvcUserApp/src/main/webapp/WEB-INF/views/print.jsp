<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div><h2>USER ID: ${u.getId }</h2> <hr></div>
	<div><h2>USER NAME: ${u.getName }</h2> <hr></div>
	<div><h2>USER EMAIL: ${u.getEmail }</h2> <hr></div>
	<div><h2>USER PASSWORD: ${u.getPassword }</h2> <hr></div>
	<div><h2>USER AGE: ${u.getAge }</h2> <hr></div>
	<div><h2>USER GENDER: ${u.getGender }</h2> <hr></div>
</body>
</html>