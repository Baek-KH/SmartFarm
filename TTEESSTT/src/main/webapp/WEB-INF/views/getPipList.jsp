<%@page import="java.util.List"%>
<%@page import="com.smartFarm.mes.dao.pip.PipDAO"%>
<%@page import="com.smartFarm.mes.vo.pip.PipVO"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지</title>
</head>
<body>
	<div>
		<h1>글 목록</h1>

	<!-- 검색 -->
		<form action="getPipList.do" method="post">
			<table border="1" width="700">
				<tr>
					<td align="right">
						<select name="searchCondition">
							<c:forEach items="${pipList}" var="pip">
								<option value="${pip.getPip_no()}"></option>
								<option value="${pip.getPip_name()}"></option>	
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
				<th bgcolor="gray" width="100">작물번호</th>
				<th bgcolor="gray" width="100">작물이름</th>
				<th bgcolor="gray" width="100">작물종류</th>
				<th bgcolor="gray" width="100">생육정보</th>
			</tr>
			<c:forEach items="${pipList}" var="pip">
				<tr>
					<td>${pip.getPip_no()}</td>
					<td>${pip.getPip_name()}</td>
					<td>${pip.getPip_category()}</td>
					<td>${pip.getPip_period()}</td>
					<td><a href="deletePip.do?pip_name=${pip.getPip_name()}">삭제하기</a></td>
				</tr>
				
			</c:forEach>
		</table>
		<br />
		<a href="/mes/createPip">작물 등록</a>
		<a href="/mes/uploadPip">작물 수정</a>

	</div>
</body>
</html>