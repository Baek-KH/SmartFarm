<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	 <h1>line_Status 출력 </h1>
	<table border="2">
	    <tr>
	      	<td>${statusVO.getStatus_id()}</td>
	      	<td>${statusVO.getStatus_line_id()}</td>
	      	<td>${statusVO.getStatus_temp()}</td>
	      	<td>${statusVO.getStatus_line_temp()}</td>
	      	<td>${statusVO.getStatus_hum()}</td>
	      	<td>${statusVO.getStatus_line_hum()}</td>
	      	<td>${statusVO.getStatus_time()}</td>
	      	
			<td><a href="getEmployee.do?emp_id=${employeeVO.getEmp_id()}">상세보기</a></td>
	     </tr>
	</table>  
</body>
</html>