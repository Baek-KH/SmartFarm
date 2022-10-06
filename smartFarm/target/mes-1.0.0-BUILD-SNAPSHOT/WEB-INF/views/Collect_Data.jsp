<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <div>
        <table border="1" width="700">
			<tr>
				<th bgcolor="orange" width="100">작물수량</th>
				<th bgcolor="orange" width="100">가격</th>
				
			</tr>
			<c:forEach items="${collect_dataList}" var="collect_data">>
				<tr>
					<td>${collect_data.getPro_qty()}</td>
					<td>${collect_data.getPro_price()}</td>
					
				</tr>
				
			</c:forEach>
		</table>
    </div> 
<h1>흠 실패인가</h1>


</body>
</html>