<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<h1>제품 상세</h1>
		<hr>
		<form action="updateProduct.do" method="post">
			<input name="pro_no" type="hidden" value="${product.pro_no}" />
			<table border="1" cellpadding="0" cellspacing="0">
				<tr>
					<td bgcolor="orange" width="70">제품아이디</td>
					<td align="left"><input name="pro_id" type="text" value="${product.pro_id }" /></td>
				</tr>
				<tr>
					<td bgcolor="orange" width="70">제품명</td>
					<td align="left"><input name="pip_name" type="text" value="${product.pip_name }" /></td>
				</tr>
				<tr>
					<td bgcolor="orange">제품수량</td>
					<td align="left">${product.pro_qty}</td>
				</tr>
				<tr>
					<td bgcolor="orange">내용</td>
					<td align="left"><textarea name="pro_content" cols="40" rows="10">${product.pro_content }</textarea></td>
				</tr>
				<tr>
					<td bgcolor="orange">가격</td>
					<td align="left">${product.pro_price }</td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="글 수정" /></td>
				</tr>
			</table>
		</form>
		<hr>
		<a href="insertProduct.jsp">제품등록</a>&nbsp;&nbsp;&nbsp; 
		<a href="deleteProduct.do?pro_no=${product.pro_id }">글삭제</a>&nbsp;&nbsp;&nbsp;
		<a href="getProductList.do">글목록</a>
	</div>
</body>
</html>