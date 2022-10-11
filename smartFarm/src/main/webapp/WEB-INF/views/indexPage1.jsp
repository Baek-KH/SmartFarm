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
		<a href="getProductList.do">제품 목록 바로가기</a>
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
 		<h1>status insert test</h1>
 		<form action="insertStatus.do" method="post">lineStatus 추가
 			<label>line_id</label>
			<input type="text" name="status_line_id" value="line_id"/>  
			<input type="text" name="status_temp" value="set temp"/>  
			<input type="text" name="status_hum" value="set hum"/>  
			<input type="submit" value="제출"> 
 		</form>
 		<a href="getStatus.do?line_id=1">getStatus test</a> <br>
 		<a href="/mes/statusList">status list test</a>
 		<a href="getLineList.do">lineStatusList</a>	 	
 	</div>
 	

 		
	<div>
		<h1>로그인 관련 기능 확인</h1>
	
	
		<c:if test="${singIn.getEmp_id()!=null }">
			<h1>로그인 되었습니다.</h1>
			<a href="signOut.do">로그아웃</a>
		</c:if>
		<c:if test="${singIn.getEmp_id()==null }">
			<h1>로그인이 필요합니다.</h1>
		</c:if>
		<c:if test="${singIn.getEmp_admin() == 'admin' }">
			<h1 style="coloe:red">관리자로 로그인 하셨습니다. </h1>
		</c:if>
	
	</div>		
		
		
</body>



</html>