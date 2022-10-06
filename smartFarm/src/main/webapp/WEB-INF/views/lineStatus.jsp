<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>

<% response.setHeader("Refresh", "5"); %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>

	<table border="1">
		<tr>
			<th>line_id</th>
			<th>line_Status</th>
		</tr>
	<c:forEach items="${LineList}" var="lineVO">
		 <tr>
	      	<td>${lineVO.getLine_id()}</td>
	      	<td>${lineVO.getLine_status()}</td>
	     </tr>
	</c:forEach>
	</table>
	
</body>

<!-- <script>
	function reload(){  
	    location.reload();
	}
	function 함수이름(){  
	      setTimeout(reload(),10000); 
	}
</script>
 -->
</html>