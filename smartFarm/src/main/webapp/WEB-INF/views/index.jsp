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
 <h1>Welcome page</h1>
 	
 	
 	<div>
		<a href="/mes/signUp"> 회원 가입 </a></br>
		<a href="getEmployeeList.do">리스트 보기</a></br>
		<a href="/mes/signIn">로그인</a></br>
 	</div>
 	
 	<div>
		<form action="getEmployeeListSearch.do">리스트 검색 field, query parameter
			
			<select name="field" >
			  <option value="emp_id">아이디</option>
			  <option value="emp_name">이름</option>
			</select>
			
			<input type="text" name="query" value="검색"></input>
			<input type="submit">
		</form>
		
		
		
		
 	</div>
	<div>
		<c:if test="${singIn.getEmp_id()!=null }">
			<h1>로그인 되었습니다.</h1>
			<a href="signOut.do">로그아웃</a>
		</c:if>
		<c:if test="${singIn.getEmp_id()==null }">
			<h1>로그인이 필요합니다.</h1>
		</c:if>
		<c:if test="${singIn.getEmp_admin()==admin }">
			<h1 style="coloe:red">관리자로 로그인 하셨습니다. </h1>
		</c:if>
	
	</div>		
		
		
</body>



</html>