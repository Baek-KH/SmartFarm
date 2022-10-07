<%@page import="com.smartFarm.mes.dao.pip.PipDAO"%>
<%@page import="com.smartFarm.mes.vo.pip.PipVO"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	PipVO vo = (PipVO) session.getAttribute("pip");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>작물수정 페이지입니다</title>
</head>
<body>
	
		<h1>작물수정</h1>
		<hr>
		<form action="updatePip.do" method="post">
			<input name="pro_no" type="hidden" value="${pip.pip_name}" />
			<table border="1" cellpadding="0" cellspacing="0">
				<tr>
					<td bgcolor="gray">작물이름</td>
					<td align="center"><input name="pip_name" type="text" value="${pip.pip_name}" /></td>
				</tr>
				
				<tr>
					<td bgcolor="gray">작물종류</td>
					<td align="center">
					<select name="pip_category" >					   
						<option value="ghPip">구황작물</option>
					    <option value="shPip">비황장물</option>
					    <option value="spPip">특용작물</option>
					    <option value="hcPip">원예작물</option>
					</select>
					</td> 
				</tr>
				
				<tr>
					<td bgcolor="gray">생육기간</td>
					<td align="center"><textarea name="pip_name" >${pip.pip_period}</textarea></td>
				</tr>
				<tr>
					<td bgcolor="gray">최저온도</td>
					<td align="center"><textarea name="pip_name" >${pip.pip_min_temp}</textarea></td>
				</tr>
				<tr>
					<td bgcolor="gray">최고온도</td>
					<td align="center"><textarea name="pip_name" >${pip.pip_max_temp}</textarea></td>
				</tr>
				<tr>
					<td bgcolor="gray">최저습도</td>
					<td align="center"><textarea name="pip_name" >${pip.pip_min_hum}</textarea></td>
				</tr>
				<tr>
					<td bgcolor="gray">최고습도</td>
					<td align="center"><textarea name="pip_name" >${pip.pip_max_hum}</textarea></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="글 수정" /></td>
				</tr>
			</table>
		</form>
		<hr>
		
<%-- 		<a href="createPip.jsp">작물등록</a>&nbsp;&nbsp;&nbsp;
		<a href="deletePip.do?pip_no=${pip.pip_name}">작물삭제</a>&nbsp;&nbsp;&nbsp;
		<a href="getPipList.do">글 목록</a> --%>
	
</body>
</html>