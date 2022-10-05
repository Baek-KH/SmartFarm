<%@page import="java.util.List"%>
<%@page import="com.smartFarm.mes.dao.process.BoardDAO"%>
<%@page import="com.smartFarm.mes.vo.process.BoardVO"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지</title>
</head>
<body>
	<center>
		<h1>글 목록</h1>
		<h3>
			관리자님 환영합니다!!~ <a href="logout.do">Log-out</a>
		</h3>

		<!-- 글목록 -->
		<table border="1" width="700">
			<tr>
				<th bgcolor="orange" width="100">번호</th>
				<th bgcolor="orange" width="200">제목</th>
				<th bgcolor="orange" width="150">작성자</th>
				<th bgcolor="orange" width="150">등록일</th>
				<th bgcolor="orange" width="100">조회수</th>
			</tr>
			<c:forEach items="${boardList}" var="board">
				<tr>
					<td>${board.seq}</td>
					<td align="left"><a href="getBoard.do?seq=${board.seq}">${board.getTitle()}</a></td>
					<td>${board.getWriter()}</td>
					<td>${board.getRegDate()}</td>
					<td>${board.getCnt()}</td>
				</tr>
			</c:forEach>
		</table>
		<br />
		<a href="insertBoard.jsp">새글 등록</a>
	</center>
</body>
</html>