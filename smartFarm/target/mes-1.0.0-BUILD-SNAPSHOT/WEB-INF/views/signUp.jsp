<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입</h1>

	<form action="/mes/insertEmployee.do" method="post">
		<input type="text" name="emp_id" >아이디</input>
		<input type="text" name="emp_name" >이름</input>
		<input type="password" name="emp_pw" >비밀번호</input>
		<input type="text" name="emp_email" >이메일</input>
		<input type="submit">
	</form>

</body>
</html>