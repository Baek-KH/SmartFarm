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

<title>stockHistoryList</title>

<!-- Custom fonts for this template-->
<link href="/resources/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="/resources/css/sb-admin-2.min.css" rel="stylesheet">

<!-- icon import -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">

<!-- awesome icon -->
<script src="https://kit.fontawesome.com/03a2ebe789.js" crossorigin="anonymous"></script>



</head>

<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- Sidebar -->
		<ul
			class="navbar-nav  sidebar sidebar-dark accordion"
			style="background-color:rgba(46,139,87)"
			id="accordionSidebar">

			<!-- Sidebar - Brand -->
			<a class="sidebar-brand d-flex align-items-center justify-content-center" href="/index">
				<div class="sidebar-brand-text mx-1" style="font-size:2.0em;">SF <sup></sup></div>
            </a>

			<!-- Divider -->
			<hr class="sidebar-divider my-0">

			<!-- Nav Item - Dashboard -->
			<li class="nav-item active"><a class="nav-link" href="/index">
					<i class="fa-solid fa-house"></i> <span>Main Home</span>
			</a></li>

			<!-- Divider -->
			<hr class="sidebar-divider">

			<!-- Heading -->
			<div class="sidebar-heading"></div>

			<!-- 사원관리 -->
			<li class="nav-item"><a class="nav-link collapsed" href="#"
				data-toggle="collapse" data-target="#collapseUtilities"
				aria-expanded="true" aria-controls="collapseUtilities"> 
				<i class="fa-solid fa-person"></i> <span>사원관리</span>
			</a>
				<div id="collapseUtilities" class="collapse"
					aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
					<div class="bg-white py-2 collapse-inner rounded">
						<!-- <h6 class="collapse-header">Custom Utilities:</h6>  여기다 글 쓰면 위에 주석처럼 달림 -->
						<a class="collapse-item" href="getAttendenceList.do"><i class="fa-regular fa-id-card"></i> 마이페이지</a>
						<c:if test="${signIn.getEmp_admin() == 'admin'}">
							<a class="collapse-item" href="getEmployeeList.do"><i class="fa-solid fa-people-arrows"></i> 사원관리</a>
							<a class="collapse-item" href="getAttendenceListAdmin.do"><i class="fa-solid fa-people-roof"></i> 근태관리</a>
						</c:if>
					</div>
				</div></li>

				<!-- Nav Item - Utilities Collapse Menu -->
			<li class="nav-item"><a class="nav-link collapsed" href="#"
				data-toggle="collapse" data-target="#collapseTwo"
				aria-expanded="true" aria-controls="collapseTwo"> 
				<i class="fa-solid fa-cart-flatbed"></i><span>재고관리</span>
			</a>
				<div id="collapseTwo" class="collapse" aria-labelledby="headingTwo"
					data-parent="#accordionSidebar">
					<div class="bg-white py-2 collapse-inner rounded">
						<%-- <h6 class="collapse-header">Custom Components:</h6> 여기다 글쓰면 위에 주석처럼 달림 --%>
						<a class="collapse-item" href="getStockHistoryList.do"><i class="fa-solid fa-truck-fast"></i> 입고/출고</a><a
							class="collapse-item" href="getStockList.do"><i class="fa-solid fa-warehouse"></i> 재고</a>
					</div>
				</div></li>



			<!-- Divider -->
			<hr class="sidebar-divider">
			<!-- 재배현황 -->

			<li class="nav-item"><a class="nav-link" href="getLineList.do">
				<i class="fa-solid fa-leaf"></i> <span>재배현황</span>
			</a></li>

			<!-- Nav Item - Tables -->
			<c:if test="${signIn.getEmp_admin() == 'admin'}">
				
                
                <!-- 재배관리 사이드바 시작 -->
                <li class="nav-item">
                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilitiess"
                        aria-expanded="true" aria-controls="collapseUtilities">
                 	  <i class="fa-solid fa-seedling"></i>
                        <span>재배관리</span>
                    </a>
                    <div id="collapseUtilitiess" class="collapse" aria-labelledby="headingUtilities"
                        data-parent="#accordionSidebar">
                        <div class="bg-white py-2 collapse-inner rounded">
                            <!-- <h6 class="collapse-header">Custom Utilities:</h6>  여기다 글 쓰면 위에 주석처럼 달림 -->
                            <a class="collapse-item" href="getLineSettingList.do"><i class="fa-solid fa-gear"></i> 라인설정</a>
                            <a class="collapse-item" href="getTrayList.do"><i class="fa-solid fa-plate-wheat"></i> TRAY</a>
                            <a class="collapse-item" href="getPipList.do"><i class="fa-solid fa-mound"></i> PIP</a>
                          

                        </div>
                    </div>
                </li>
                <!-- 재배관리 사이드바 끝 -->
	    		<!-- 구매관리 사이드바 보고페이지와 재배관리 li 사이 -->
                <li class="nav-item">
                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo2"
                        aria-expanded="true" aria-controls="collapseTwo2">
                        <i class="fa-solid fa-wallet"></i>
                        <span>구매관리</span>
                    </a>
                    <div id="collapseTwo2" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                        <div class="bg-white py-2 collapse-inner rounded">
                           <a class="collapse-item" href="getBuyerList.do"><i class="fa-solid fa-money-bill-1"></i> 거래처 관리</a>
                            <a class="collapse-item" href="getOrdersList.do"><i class="fa-regular fa-money-bill-1"></i> 발주 관리</a>
                        </div>
                    </div>
                </li>
				
				
				<!-- 출하관리 공정관리 -->
				<li class="nav-item"><a class="nav-link" href="getForwardList.do">
						<i class="fa-solid fa-truck"></i> <span>출하관리</span>
				</a></li>
				
				
				
				<li class="nav-item"><a class="nav-link" href="TrayControlList.do?line_id=1">
						<i class="fa-solid fa-gears"></i> <span>공정관리</span>
				</a></li>
				<!-- 출하관리 공정관리 -->



				<li class="nav-item"><a class="nav-link" href="report.do">
						<i class="fa-solid fa-eye"></i> <span>보고페이지</span>
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
					class="navbar navbar-expand navbar-light  topbar mb-4 static-top shadow"
					style="background-color:rgba(46,139,87)"
					>
					
					<!-- Sidebar Toggle (Topbar) -->
					<button id="sidebarToggleTop"
						class="btn btn-link d-md-none rounded-circle mr-3">
						
					</button>
					<div>
						<h1 class="h3 mb-0 text-800"  style="color:white;" align="left"></h1>
					</div>

					<!-- Topbar Navbar -->
					
					
					<ul class="navbar-nav ml-auto col-5">
						
						<div class="topbar-divider d-none d-lg-block"></div>

						<!-- Log Out -->
						
						<c:if test="${ signIn.getEmp_id() != NUll }">

							<c:if test="${ attendence.getEmp_id() != NULL }">
								<small style="margin-left: 10px; color: white; text-align: center;">${attendence.getAtt_work_on()}</small>
								
								<a class="btn btn-warning btn-sm" style="margin-left: 10px; border-color:white; width: 40%; text-align: center;"
									href="/updateAttendence.do">퇴근</a>
							</c:if>
							<c:if test="${ attendence.getEmp_id() == NULL }">
								<a class="btn btn-success btn-sm " style="margin-left: 10px; border-color:white; width: 40%; text-align: center; "
									href="/insertAttendence.do">출근</a>
							</c:if>
							
							

							<a class="btn btn-success btn-sm " style="margin-left: 10px; border-color:white; width: 40%; text-align: center;  "
								href="signOut.do">Log Out</a>
						</c:if>
						<c:if test="${ signIn.getEmp_id() == NUll }">
							<a class="btn btn-success btn-sm " style="margin-left: 10px; border-color:white; width: 40%; text-align: center;"
								href="/">Log In</a>
						</c:if>
						
						
					</ul>

				</nav>
				<!-- End of Topbar -->

				<!-- Begin Page Content -->
				<div class="container-fluid">

					<!-- Page Heading -->
				


					<!-- 입출고 셋팅란 -->

					<div class="container-fluid">
						<div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">입/출고 관리</h6>
                        </div>
					
					
					
					
						<form action="insertStockHistory.do" method="post">

							<table class="table table-bordered" id="dataTable" width="50%" cellspacing="0">
								<thead>
									<tr>
										<th scope="col" style="text-align: center;">물품 아이디</th>
										<th scope="col" style="text-align: center;">입고 수량</th>
										<th scope="col" style="text-align: center;">출고 수량</th>
									</tr>
								</thead>
								<tbody>
									<tr>

										<th scope="col" style="text-align: center;"><select
											name="stock_id">
												<c:forEach items="${StockList}" var="stockVO">
													<option value="${stockVO.getStock_id()}">${stockVO.getStock_id()}</option>
												</c:forEach>
										</select></th>


										<th scope="col" style="text-align: center;"><input
											type="number" name="stock_in" size="10" value="0" /></th>
										<th scope="col" style="text-align: center;"><input
											type="number" name="stock_out" size="10" value="0" /></th>


									</tr>
									<tr>
										<td></td>
										<td></td>
										<td>
											<input type="submit" value=" 재고 등록 " class="btn "    id="btnSubmit" style="float:right; background-color:rgba(46,139,87); color:white;" />
										</td>
									
									</tr>
								</tbody>
							</table>

						</form>
					</div>
				</div>




		


					<!-- Content Second -->

					<!-- 입고정보 출고정보 큰틀 -->
					<div class="container-fluid">
						<div class="row">
						
							<!-- 입고정보 -->
							<div class="col-lg-6">
								<h6 class="m-0 font-weight-bold text-primary"></h6>
								<h1 class="h3 mb-2 text-gray-800"></h1>

								
									<div class="card shadow mb-6">
									<div class="card-header py-3">
										<div class="card-header py-3">
											<h6 class="m-0 font-weight-bold text-primary">입고 내역</h6>
										</div>
									</div>

									<div class="card-body">

											<div class="table-responsive">
												<table class="table table-bordered" id="dataTable"
													width="100%" cellspacing="0">
													<!-- 테이블 몸뚱아리 -->


													<thead>
														<tr>
															<th>작물이름</th>
															<th>작물가격</th>
															<th>작물수량</th>
															<th>작물수량</th>
															<th>출고일</th>
														</tr>
													</thead>

													<tbody>
														<c:forEach items="${StockHistoryListIn}" var="stockInVO">
															<tr>

																<td>${stockInVO.getStock_id() }</td>
																<td>${stockInVO.getStock_name() }</td>
																<td>${stockInVO.getStock_in() }</td>
																<td>${stockInVO.getStock_qty() }</td>
																<td>${stockInVO.getStock_date() }</td>

															</tr>
														</c:forEach>

													</tbody>
														
													
													
												</table>
												
											</div>
											
										</div>
									</div>
									
								
							</div>

							<!-- 출고정보 -->
								<div class="col-lg-6" >
									<h6 class="m-0 font-weight-bold text-primary"></h6>
									<h1 class="h3 mb-2 text-gray-800"></h1>
	
									
										<div class="card shadow mb-6">
											<div class="card-header py-3">
										
												<div class="card-header py-3">
													<h6 class="m-0 font-weight-bold text-primary">출고 내역</h6>
												</div>
	
	
											</div>
											<div class="card-body">
	
												<div class="table-responsive">
													<table class="table table-bordered" id="dataTable"
														width="100%" cellspacing="0">
														<!-- 테이블 몸뚱아리 -->
	
	
														<thead>
															<tr>
																<th>작물이름</th>
																<th>작물가격</th>
																<th>작물수량</th>
																<th>작물수량</th>
																<th>출고일</th>
															</tr>
														</thead>
	
														<tbody>
															<c:forEach items="${StockHistoryListOut}" var="stockOutVO">
																<tr>
	
																	<td>${stockOutVO.getStock_id() }</td>
																	<td>${stockOutVO.getStock_name() }</td>
																	<td>${stockOutVO.getStock_out() }</td>
																	<td>${stockOutVO.getStock_qty() }</td>
																	<td>${stockOutVO.getStock_date() }</td>
	
																</tr>
															</c:forEach>
	
														</tbody>
													</table>
												</div>
											</div>
										</div>
									
								</div>
							
							
							
							
							
						
						</div>
					<!-- Content Row -->
					



					</div>

				</div>
				<!-- /.container-fluid -->

			</div>
			<!-- End of Main Content -->

			<!-- Footer -->
			<footer class="sticky-footer bg-white">
				<div class="container my-auto">
					<div class="copyright text-center my-auto">
						<span>Copyright &copy; PROJECT B 2022</span>
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