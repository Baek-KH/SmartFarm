<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<<<<<<< HEAD
<<<<<<< HEAD
=======



>>>>>>> WJH
<title>Insert title here</title>
</head>
<body>
 <h1>Welcome page</h1>
 	

	<%-- left bar --%>
	<div class="leftbar-user">


	</div>




 	
 	<div>
		<a href="/mes/signUp"> 회원 가입 </a></br>
		<a href="getEmployeeList.do">리스트 보기</a>
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
=======
<title>테스트페이지</title>
</head>
<body>
 <h1>테스트</h1>
 	
 	
 	<div>
		<a href="/mes/getPipList">작물리스트</a>
		<a href="/mes/createPip">작물등록</a>
>>>>>>> MSC
 	</div>
		
</body>



</html>