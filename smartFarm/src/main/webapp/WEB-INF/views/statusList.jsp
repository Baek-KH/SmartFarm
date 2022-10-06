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

 	<h1>status 검색 및 출력 </h1>
 	<div>
 		<form action="getStatusListSearch.do" method="get">statusSearch 추가
 			<label>line_id</label>
			<input type="text" name="field" value="field"/>  
			<input type="text" name="query" value="query"/>  
			<input type="submit" value="제출"> 
 		</form>
 	</div>
 	
	<table border="1">
	<c:forEach items="${StatusList}" var="statusVO">
	    <tr>
	      	<td>${statusVO.getStatus_id()}</td>
	      	<td>${statusVO.getStatus_line_id()}</td>
	      	<td>${statusVO.getStatus_temp()}</td>
	      	<td>${statusVO.getStatus_line_temp()}</td>
	      	<td>${statusVO.getStatus_hum()}</td>
	      	<td>${statusVO.getStatus_line_hum()}</td>
	      	<td>${statusVO.getStatus_time()}</td>
			
	     </tr>
	</c:forEach>
	</table>     
	
	
</body>
</html>