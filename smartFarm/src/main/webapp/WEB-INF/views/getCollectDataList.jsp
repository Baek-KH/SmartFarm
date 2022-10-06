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

 	<h1>collectDataVO 출력 </h1>
	<c:forEach items="${collectDataList}" var="collectDataVO">
	<table>
	    <tr>
	      	<td>${collectDataVO.getPro_qty()}</td>
	      	<td>${collectDataVO.getPro_price()}</td>
	      	<td>${collectDataVO.getPro_date()}</td>
			<td>${collectDataVO.getTitle()}</td>
			<td>${collectDataVO.getWriter()}</td>


	      	
	     </tr>
	</table>     
	</c:forEach>
</body>
</html>