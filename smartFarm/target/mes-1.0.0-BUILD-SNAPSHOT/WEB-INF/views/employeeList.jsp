<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

 	<h1>EmployeeList 출력 </h1>
	<c:forEach items="${EmployeeList}" var="employeeVO">
	<table>
	    <tr>
	      	<td>${employeeVO.getEmp_id()}</td>
	      	<td>${employeeVO.getEmp_no()}</td>
	      	<td>${employeeVO.getEmp_name()}</td>
	      	<td>${employeeVO.getEmp_email()}</td>
	      	<td>${employeeVO.getEmp_admin()}</td>
	      	<td>a<a href="getEmployee.do">getEmployee.do</a></td>
	     </tr>
	</table>     
	</c:forEach>
	
</body>
</html>