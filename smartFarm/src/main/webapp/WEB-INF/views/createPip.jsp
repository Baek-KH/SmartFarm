<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>작물등록 페이지입니다.</title>
</head>
<body>
	<div>
		<h1>작물등록</h1>
		<hr>
		<form action="insertPip.do" method="post">
			<table border="1" cellpadding="0" cellspacing="0">
				
				<tr>
					<td bgcolor="gray" align="center">작물이름</td>
					<td align="left"><input type="text" name="pip_name" size="20" ></input></td>
				</tr>
				
				<tr>
					<td bgcolor="gray" align="center">작물종류</td>
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
					<td bgcolor="gray" align="center">생육기간</td>
					<td align="left"><input type="text" name="pip_period" size="20"></input></td>
				</tr>
				
				<tr>
					<td bgcolor="gray" align="center">최저온도</td>
					<td align="left"><input type="text" name="pip_min_temp" size="20"></input></td>
				</tr>
				
				<tr>
					<td bgcolor="gray" align="center">최고온도</td>
					<td align="left"><input type="text" name="pip_max_temp" size="20"></input></td>
				</tr>
				
				<tr>
					<td bgcolor="gray" align="center">최저습도</td>
					<td align="left"><input type="text" name="pip_min_hum" size="20"></input></td>
				</tr>
							
				<tr>
					<td bgcolor="gray" align="center">최고습도</td>
					<td align="left"><input type="text" name="pip_max_hum" size="20" ></input></td>
				</tr>
				
				<tr>
					<td colspan="2" align="center"><input type="submit" value=" 작물 등록 " /></td>
				</tr>
			</table>
		</form>
		<hr>
		<a href="getPipList.do">글 목록</a>
	</div>
</body>
</html>