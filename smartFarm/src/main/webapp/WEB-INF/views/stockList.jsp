<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.text.SimpleDateFormat"%>





<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>SB Admin 2 - Dashboard</title>

<!-- Custom fonts for this template-->
<link href="/resources/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="/resources/css/sb-admin-2.min.css" rel="stylesheet">


</head>

<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- Sidebar -->
		<ul
			class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
			id="accordionSidebar">

			<!-- Sidebar - Brand -->
			<a
				class="sidebar-brand d-flex align-items-center justify-content-center"
				href="/index">
				<div class="sidebar-brand-text mx-1" style="font-size: 2.0em;">
					SF <sup></sup>
				</div>
			</a>

			<!-- Divider -->
			<hr class="sidebar-divider my-0">

			<!-- Nav Item - Dashboard -->
			<li class="nav-item active"><a class="nav-link" href="/index">

					<span>Main Home</span>
			</a></li>

			<!-- Divider -->
			<hr class="sidebar-divider">

			<!-- Heading -->
			<div class="sidebar-heading"></div>

			<!-- 사원관리 -->
			<li class="nav-item"><a class="nav-link collapsed" href="#"
				data-toggle="collapse" data-target="#collapseUtilities"
				aria-expanded="true" aria-controls="collapseUtilities"> <i
					class="fas fa-fw fa-wrench"></i> <span>사원관리</span>
			</a>
				<div id="collapseUtilities" class="collapse"
					aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
					<div class="bg-white py-2 collapse-inner rounded">
						<!-- <h6 class="collapse-header">Custom Utilities:</h6>  여기다 글 쓰면 위에 주석처럼 달림 -->
						<a class="collapse-item" href="getAttendenceList.do">마이페이지</a>
						<c:if test="${signIn.getEmp_admin() == 'admin'}">
							<a class="collapse-item" href="getEmployeeList.do">사원관리</a>
							<a class="collapse-item" href="getAttendenceListAdmin.do">근태관리</a>
						</c:if>
					</div>
				</div></li>

			<!-- Nav Item - Utilities Collapse Menu -->
			<li class="nav-item"><a class="nav-link collapsed" href="#"
				data-toggle="collapse" data-target="#collapseTwo"
				aria-expanded="true" aria-controls="collapseTwo"> <i
					class="fas fa-fw fa-cog"></i> <span>입/출</span>
			</a>
				<div id="collapseTwo" class="collapse" aria-labelledby="headingTwo"
					data-parent="#accordionSidebar">
					<div class="bg-white py-2 collapse-inner rounded">
						<%-- <h6 class="collapse-header">Custom Components:</h6> 여기다 글쓰면 위에 주석처럼 달림 --%>
						<a class="collapse-item" href="getStockHistoryList.do">입출/등록</a> <a
							class="collapse-item" href="getStockList.do">재고</a>
					</div>
				</div></li>



			<!-- Divider -->
			<hr class="sidebar-divider">
			<!-- 재배현황 -->

			<li class="nav-item"><a class="nav-link" href="getLineList.do">
					<i class="fas fa-fw fa-chart-area"></i> <span>재배현황</span>
			</a></li>

			<!-- Nav Item - Tables -->
			<c:if test="${signIn.getEmp_admin() == 'admin'}">
				<li class="nav-item"><a class="nav-link" href="tables.html">
						<i class="fas fa-fw fa-table"></i> <span>재배관리</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="tables.html">
						<i class="fas fa-fw fa-table"></i> <span>보고페이지</span>
				</a></li>
			</c:if>
			<!-- Divider -->
			<hr class="sidebar-divider d-none d-md-block">

			<!-- Sidebar Toggler (Sidebar) -->
			<div class="text-center d-none d-md-inline">
				<button class="rounded-circle border-0" id="sidebarToggle"></button>
			</div>

		</ul>
		<!-- End of Sidebar -->

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">

				<!-- Topbar -->
				<nav
					class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

					<!-- Sidebar Toggle (Topbar) -->
					<button id="sidebarToggleTop"
						class="btn btn-link d-md-none rounded-circle mr-3">
						<i class="fa fa-bars"></i>
					</button>


					<!-- Topbar Navbar -->
					<ul class="navbar-nav ml-auto col-3">

						<div class="topbar-divider d-none d-lg-block"></div>

						<!-- Log Out -->

						<c:if test="${ signIn.getEmp_id() != NUll }">

							<c:if test="${ attendence.getEmp_id() != NULL }">
								<small style="margin-left: 10px">${attendence.getAtt_work_on()}</small>
								</br>
								<a class="btn btn-warning btn-sm" style="margin-left: 10px"
									href="/updateAttendence.do">퇴근</a>
							</c:if>
							<c:if test="${ attendence.getEmp_id() == NULL }">
								<a class="btn btn-success btn-sm " style="margin-left: 10px"
									href="/insertAttendence.do">출근</a>
							</c:if>
							</br>

							<a class="btn btn-success btn-sm " style="margin-left: 10px"
								href="signOut.do">Log Out</a>
						</c:if>
						<c:if test="${ signIn.getEmp_id() == NUll }">
							<a class="btn btn-success btn-sm " style="margin-left: 10px"
								href="/">Log In</a>
						</c:if>
					</ul>

				</nav>
				<!-- End of Topbar -->

				<!-- Begin Page Content -->
				<div class="container-fluid">

					<!-- Page Heading -->
					<div
						class="d-sm-flex align-items-center justify-content-between mb-4">
						<h1 class="h3 mb-0 text-gray-800">Dashboard</h1>
						<a href="#"
							class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
							class="fas fa-download fa-sm text-white-50"></i> Generate Report</a>
					</div>


					<!-- 입출고 셋팅란 -->

					<div class="container-fluid">


						<form action="insertStock.do" method="post">

							<table class="table table-bordered" id="dataTable" width="50%"
								cellspacing="0">
								<thead>
									<tr>
										<th scope="col" style="text-align: center;">재고아이디</th>
										<th scope="col" style="text-align: center;">재고종류</th>
										<th scope="col" style="text-align: center;">재고이름</th>
									</tr>
								</thead>
								<tbody>
									<tr>

										<th scope="col" style="text-align: center;">
											<input type="text" name="stock_id" size="10" />
										</th>

										<th scope="col" style="text-align: center;">
											<input type="text" name="stock_category" size="10" />
										</th>

										<th scope="col" style="text-align: center;">
											<input type="text" name="stock_name" size="10" />
										</th>

									</tr>
								</tbody>
							</table>
						<div>
							<tr>
								<td colspan="2"><input type="submit" value=" 재고 등록 "
									class="btn btn-primary" id="btnSubmit" style="float: right;" />
								</td>
							</tr>



						</div>
						</form>

					</div>

					<!-- Content Second -->

					<!-- 입고정보 출고정보 큰틀 -->
					<div class="row">


						<div class="card shadow mb-4">
							<div class="card-header py-3">
								<h6 class="m-0 font-weight-bold text-primary">맨아래요아래 관련</h6>
							</div>

							<div class="card-body">

								<div class="table-responsive">
									<form action="deleteStock.do">
									<table class="table table-bordered" id="dataTable" width="100%"
										cellspacing="0">
										<!-- 테이블 몸뚱아리 -->


										<thead>
											<tr>
												<th>재고 아이디</th>
												<th>재고 분류</th>
												<th>재고 이름</th>
												<th>재고 수량</th>
												<th>비고</th>
												
											</tr>
										</thead>

										<tbody>
										<c:forEach items="${StockList}" var="stockVO">
											<tr>

												<td>
													<input type="text" name="stock_id" value="${stockVO.getStock_id() }" disabled="disabled">
													<input type="hidden" name="stock_id" value="${stockVO.getStock_id() }" >
												</td>
												
												<td>
													<input type="text" name="stock_category" value="${stockVO.getStock_category() }" >
												</td>
												<td>
													<input type="text" name="stock_name" value="${stockVO.getStock_name() }" >
												</td>
												<td>
													
													<input type="text" name="stock_qty" value="${stockVO.getStock_qty() }"  disabled="disabled">
													<input type="hidden" name="stock_qty" value="${stockVO.getStock_qty() }" >
												</td>
												<td>
	                                                	<a class="btn btn-success" href="deleteStock.do?stock_id=${stockVO.getStock_id()}">삭제</a>
	                                                	<input type="submit" class="btn btn-danger" value="수정">
												</td>

											</tr>
										</c:forEach>
											


											<!-- 페이지번호 미구현 라인 -->






											<!-- 페이지번호 미구현 -->



										</tbody>
									</table>
	                               </form>
								</div>
							</div>
						</div>
					</div>
					<!-- Content Row -->





				</div>
				<!-- /.container-fluid -->

			</div>
			<!-- End of Main Content -->

			<!-- Footer -->
			<footer class="sticky-footer bg-white">
				<div class="container my-auto">
					<div class="copyright text-center my-auto">
						<span>Copyright &copy; B팀 근데 팀명이 머였죠? 2022</span>
					</div>
				</div>
			</footer>
			<!-- End of Footer -->

		</div>
		<!-- End of Content Wrapper -->

	</div>
	<!-- End of Page Wrapper -->

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>


	<!-- Bootstrap core JavaScript-->
	<script src="/resources/vendor/jquery/jquery.min.js"></script>
	<script src="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="/resources/vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="/resources/js/sb-admin-2.min.js"></script>

	<!-- Page level plugins -->
	<script src="/resources/vendor/chart.js/Chart.min.js"></script>

	<!-- Page level custom scripts -->
	<script src="/resources/js/demo/chart-area-demo.js"></script>
	<script src="/resources/js/demo/chart-pie-demo.js"></script>

</body>

<!-- <script>
	function reload(){  
	    location.reload();
	}
	function 함수이름(){  
	      setTimeout(reload(),10000); 
	}
</script>
 -->
</html>