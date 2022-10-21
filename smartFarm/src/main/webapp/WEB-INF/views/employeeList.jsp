<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

 	<h1>EmployeeList 출력 </h1>
	<table border="2">
	<c:forEach items="${EmployeeList}" var="employeeVO">
	    <tr>
	      	<td>${employeeVO.getEmp_id()}</td>
	      	<td>${employeeVO.getEmp_no()}</td>
	      	<td>${employeeVO.getEmp_name()}</td>
	      	<td>${employeeVO.getEmp_email()}</td>
	      	<td>${employeeVO.getEmp_admin()}</td>
			<td><a href="getEmployee.do?emp_id=${employeeVO.getEmp_id()}">상세보기</a></td>
	     </tr>
	</c:forEach>
	</table>     
	
	
</body>
</html>