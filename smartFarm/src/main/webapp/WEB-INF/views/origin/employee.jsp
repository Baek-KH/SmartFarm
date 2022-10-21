<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>사원정보</h1>

	<form action="/mes/updateEmployee.do" method="post">
		<input type="text" name="emp_id" value="${employeeVO.getEmp_id()}" disabled="disabled" ></input>
		<input type="text" name="emp_no" value="${employeeVO.getEmp_no()}" disabled="disabled" ></input>
		<input type="text" name="emp_name" value="${employeeVO.getEmp_name()}"></input>
		<input type="text" name="emp_email" value="${employeeVO.getEmp_email()}"></input>
		<input type="radio" name="emp_admin" value="admin">
  			<label for="html">admin</label>
		<input type="radio" name="emp_admin" value="regular">
  			<label for="html">regular</label>
		<input type="hidden" name="emp_id" value="${employeeVO.getEmp_id()}"></input>
		<input type="hidden" name="emp_no" value="${employeeVO.getEmp_no()}"></input>
		<input type="submit" value="수정하기">
	</form>
		<a href="/mes/deleteEmployee.do?emp_id=${employeeVO.getEmp_id()}">삭제하기</a>
</body>
</html>