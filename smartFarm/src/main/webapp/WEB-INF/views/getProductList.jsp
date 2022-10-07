<%@page import="java.util.List"%>
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
		<h1>글 목록</h1>
		
	<!-- 검색 -->
		<form action="getProductList.do" method="post">
			<table border="1" width="700">
				<tr>
					<td align="right">
						<select name="searchCondition">
							<c:forEach items="${productList}" var="product">
								<option value="${product.getPro_no()}"></option>
								<option value="${product.getPro_id()}"></option>
								<option value="${product.getPip_name()}"></option>	
							</c:forEach>
						
						</select>
						<input type="text" name="searchKeyword" /> <input type="submit" value="검색">
					</td>
				</tr>
			</table>
		</form>
		
		<!-- 글목록 -->
		<table border="1" width="700">
			<tr>
				<th bgcolor="orange" width="100">번호</th>
				<th bgcolor="orange" width="150">아이디</th>
				<th bgcolor="orange" width="150">작물이름</th>
				<th bgcolor="orange" width="100">작물수량</th>
				<th bgcolor="orange" width="100">가격</th>
				<th bgcolor="orange" width="200">내용</th>
				<th bgcolor="orange" width="100">시간</th>
			</tr>
			<c:forEach items="${productList}" var="product">>
				<tr>
					<td>${product.getPro_no()}</td>
					<td>${product.getPro_id()}</td>
					<td>${product.getPip_name()}</td>
					<td>${product.getPro_qty()}</td>
					<td>${product.getPro_price()}</td>
					<td>${product.getPro_content()}</td>
					<td>${product.getPro_date()}</td>
					<td><a href="deleteProduct.do?pro_id=${product.getPro_id()}">삭제하기</a></td>
				</tr>
				
			</c:forEach>
		</table>
		<br />
		<a href="/mes/insertProduct">제품 등록</a>
	</div>
</body>
</html>