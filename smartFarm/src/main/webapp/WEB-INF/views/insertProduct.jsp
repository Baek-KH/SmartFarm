<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<h1>제품 등록</h1>
		<hr>
		<form action="insertProduct.do" method="post">
			<table border="1" cellpadding="0" cellspacing="0">
			
				
				<tr>
					<td bgcolor="orange">아이디</td>
					<td align="left"><input type="text" name="pro_id" size="12" /></td>
				</tr>
				<tr>
					<td bgcolor="orange">씨앗이름</td>
					<td align="left"><input type="text" name="pip_name" size="20" ></input></td>
				</tr>
				<tr>
					<td bgcolor="orange">수량</td>
					<td align="left"><input type="text" name="pro_qty" size="20" ></input></td>
				</tr>
				<tr>
					<td bgcolor="orange">가격</td>
					<td align="left"><input type="text" name="pro_price" size="20"></input></td>
				</tr>
				<tr>
					<td bgcolor="orange">내용</td>
					<td align="left"><textarea name="pro_content" cols="40" rows="10"></textarea></td>
				</tr>
				
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value=" 새글 등록 " /></td>
				</tr>
			</table>
		</form>
		<hr>
		<a href="getProductList.do">글 목록 가기</a>
	</div>
</body>
</html>