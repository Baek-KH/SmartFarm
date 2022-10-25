<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>


<body>
	<div align="center">
		<form action="signin.do" method="post">
			<label>id 입력</label>
			<input type="text" name="emp_id" />  
			<label>pw 입력</label>
			<input type="password" name="emp_pw" />
			<input type="submit" value="로그인"> 
		</form>
	</div>
</body>
</html>