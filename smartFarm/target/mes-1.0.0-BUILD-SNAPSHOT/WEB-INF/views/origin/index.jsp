<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%-- ${productRateVO.getStock_in_sum}
${productRateVO.getStock_out_sum} --%>


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

<style>
* {
	padding: 0;
	margin: 0
}

body {
	background-color: #181726
}

.skill_list li {
	list-style: none;
	float: left;
	display: table;
	width: 200px;
	height: 200px;
	margin: 10px;
	font-family: "Lato", sans-serif;
	background-color: rgba(237, 96, 98, 0.15);
	border-top: 1px solid #ed6062;
	border-bottom: 1px solid #ed6062
}

.skill_list div {
	display: table-cell;
	vertical-align: middle
}

.skill {
	display: block;
	margin-bottom: 20px;
	font-size: 20px;
	font-weight: 400;
	color: #ed6062;
	text-align: center
}

.skill_num {
	display: block;
	font-size: 50px;
	font-weight: 900;
	color: rgb(241, 14, 14);
	text-align: center;
	vertical-align: middle
}

.skill_num span {
	display: inline-block
}

.skill_num .num {
	text-align: right;
	width: 53%;
	padding-right: 2%;
}

.skill_num .per {
	width: 45%;
	text-align: center
}

.holdin {
	position: absolute;
	width: 100%;
	height: 100%;
}
</style>


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
				<div class="sidebar-brand-icon rotate-n-15">
					<i class="fas fa-laugh-wink"></i>
				</div>
				<div class="sidebar-brand-text mx-3">
					SF <sup></sup>
				</div>
			</a>

			<!-- Divider -->
			<hr class="sidebar-divider my-0">

			<!-- Nav Item - Dashboard -->
			<li class="nav-item active"><a class="nav-link" href="/index">
					<i class="fas fa-fw fa-tachometer-alt"></i> <span>Main Home</span>
			</a></li>

			<!-- Divider -->
			<hr class="sidebar-divider">

			<!-- Heading -->
			<div class="sidebar-heading"></div>

			<!-- ???????????? -->
			<li class="nav-item"><a class="nav-link collapsed" href="#"
				data-toggle="collapse" data-target="#collapseUtilities"
				aria-expanded="true" aria-controls="collapseUtilities"> <i
					class="fas fa-fw fa-wrench"></i> <span>????????????</span>
			</a>
				<div id="collapseUtilities" class="collapse"
					aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
					<div class="bg-white py-2 collapse-inner rounded">
						<!-- <h6 class="collapse-header">Custom Utilities:</h6>  ????????? ??? ?????? ?????? ???????????? ?????? -->
						<a class="collapse-item" href="getAttendenceList.do">???????????????</a>
						<c:if test="${signIn.getEmp_admin() == 'admin'}">
							<a class="collapse-item" href="getEmployeeList.do">????????????</a>
							<a class="collapse-item" href="getAttendenceListAdmin.do">????????????</a>
						</c:if>
					</div>
				</div></li>

			<!-- Nav Item - Utilities Collapse Menu -->
			<li class="nav-item"><a class="nav-link collapsed" href="#"
				data-toggle="collapse" data-target="#collapseTwo"
				aria-expanded="true" aria-controls="collapseTwo"> <i
					class="fas fa-fw fa-cog"></i> <span>???/???</span>
			</a>
				<div id="collapseTwo" class="collapse" aria-labelledby="headingTwo"
					data-parent="#accordionSidebar">
					<div class="bg-white py-2 collapse-inner rounded">
						<%-- <h6 class="collapse-header">Custom Components:</h6> ????????? ????????? ?????? ???????????? ?????? --%>
						<a class="collapse-item" href="getStockHistoryList.do">??????/??????</a> <a
							class="collapse-item" href="getStockList.do">??????</a>
					</div>
				</div></li>



			<!-- Divider -->
			<hr class="sidebar-divider">
			<!-- ???????????? -->

			<li class="nav-item"><a class="nav-link" href="getLineList.do">
					<i class="fas fa-fw fa-chart-area"></i> <span>????????????</span>
			</a></li>

			<!-- Nav Item - Tables -->
			<c:if test="${signIn.getEmp_admin() == 'admin'}">
				
                
                <!-- ???????????? ???????????? ?????? -->
                <li class="nav-item">
                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilitiess"
                        aria-expanded="true" aria-controls="collapseUtilities">
                        <i class="fas fa-fw fa-wrench"></i>
                        <span>????????????</span>
                    </a>
                    <div id="collapseUtilitiess" class="collapse" aria-labelledby="headingUtilities"
                        data-parent="#accordionSidebar">
                        <div class="bg-white py-2 collapse-inner rounded">
                            <!-- <h6 class="collapse-header">Custom Utilities:</h6>  ????????? ??? ?????? ?????? ???????????? ?????? -->
                            <a class="collapse-item" href="getLineSettingList.do">????????????</a>
                            <a class="collapse-item" href="getTrayList.do">TRAY</a>
                            <a class="collapse-item" href="getPipList.do">PIP</a>
                            <a class="collapse-item" href="getOrdersList.do">TEST</a>

                        </div>
                    </div>
                </li>
                <!-- ???????????? ???????????? ??? -->
	    		<!-- ???????????? ???????????? ?????????????????? ???????????? li ?????? -->
                <li class="nav-item">
                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo2"
                        aria-expanded="true" aria-controls="collapseTwo2">
                        <i class="fas fa-fw fa-cog"></i>
                        <span>????????????</span>
                    </a>
                    <div id="collapseTwo2" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                        <div class="bg-white py-2 collapse-inner rounded">
                            <a class="collapse-item" href="getBuyerList.do">Buyer</a>
                            <a class="collapse-item" href="getOrdersList.do">Orders</a>
                        </div>
                    </div>
                </li>


				<li class="nav-item"><a class="nav-link" href="tables.html">
						<i class="fas fa-fw fa-table"></i> <span>???????????????</span>
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
									href="/updateAttendence.do">??????</a>
							</c:if>
							<c:if test="${ attendence.getEmp_id() == NULL }">
								<a class="btn btn-success btn-sm " style="margin-left: 10px"
									href="/insertAttendence.do">??????</a>
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
							class="fas fa-download fa-sm text-white-50"></i> ${ signIn.getEmp_admin() == 'admin' }..
						</a>
					</div>

					<!-- Content Row -->
					<div class="row">

						<!-- ????????? -->
						<div class="col-xl-3 col-md-6 mb-4">
							<div class="card border-left-info shadow h-100 py-2">
								<div class="card-body">
									<div class="row no-gutters align-items-center">
										<div class="col mr-2">
											<div
												class="text-xs font-weight-bold text-info text-uppercase mb-1">?????????
											</div>
											<div class="row no-gutters align-items-center">
												<div class="col-auto">
													<div class="h5 mb-0 mr-3 font-weight-bold text-gray-800">${productRateVO.getStock_rate()}%</div>
												</div>
												<div class="col">
													<div class="progress progress-sm mr-2">
														<div class="progress-bar bg-info" role="progressbar"
															style="width: ${productRateVO.getStock_rate()}%"
															aria-valuenow="50" aria-valuemin="0" aria-valuemax="200"></div>
													</div>
												</div>
											</div>
										</div>
										<div class="col-auto">
											<i class="fas fa-clipboard-list fa-2x text-gray-300"></i>
										</div>
									</div>
								</div>
							</div>
						</div>

						<!-- ?????? -->
						<div class="col-xl-3 col-md-6 mb-4">
							<div class="card border-left-warning shadow h-100 py-2">
								<div class="card-body">
									<div class="row no-gutters align-items-center">
										<div class="col mr-2">
											<div
												class="text-xs font-weight-bold text-warning text-uppercase mb-1">
												?????? ??????</div>
											<div class="h5 mb-0 font-weight-bold text-gray-800">??????</div>
										</div>
										<div class="col-auto">
											<i class="fas fa-comments fa-2x text-gray-300"></i>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>

					<!-- Content Row -->

					<div class="row">

						<!-- Area Chart -->
						<div class="col-xl-8 col-lg-7">
							<div class="card shadow mb-4">
								<!-- Card Header - Dropdown -->
								<div
									class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
									<h6 class="m-0 font-weight-bold text-primary">Earnings
										Overview</h6>

								</div>
								<!-- Card Body -->
								<div class="card-body">
									<div class="chart-area">
										<canvas class="holdin" id="myChart"></canvas>
									</div>

									<div></div>
								</div>
							</div>
						</div>

						<!-- Pie Chart -->
                        <div class="col-xl-4 col-lg-5">
                            <div class="card shadow mb-4">
                                <!-- Card Header - Dropdown -->
                                <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                                    <h6 class="m-0 font-weight-bold text-primary">Revenue Sources</h6>
                                </div>
                                    <!-- Card Body -->
                                    <div class="card-body">
                                        <div class="chart-pie pt-4 pb-2">
                                            <div class="holdin">
                                            <!-- ???????????? ????????? -->
                                            <canvas id="myPichart"></canvas>
                                            </div>
                                        </div>

                                        <div class="mt-4 text-center small">
                                            <span class="mr-2">
                                                <i class="fas fa-circle" style="color:rgba(232, 81, 197)"></i> ${StockList[0].getStock_id()}
                                            </span>
                                            <span class="mr-2">
                                                <i class="fas fa-circle" style="color:rgba(78, 115, 223)"></i> ${StockList[1].getStock_id()}
                                            </span>
                                            <span class="mr-2">
                                                <i class="fas fa-circle" style="color:rgba(54, 185, 204)"></i> ${StockList[2].getStock_id()}
                                            </span>
                                            <span class="mr-2">
                                                <i class="fas fa-circle" style="color:rgba(162, 70, 224)"></i> ${StockList[3].getStock_id()}
                                            </span>
                                        
                                        </div>
                                    </div>
                            </div>
                        </div>
                        <div>
                        </div>


					</div>

					<!-- Content Row -->
					<div class="row">

						<!-- Content Column -->
						<div class="col-lg-6 mb-4"></div>

						<div class="col-lg-6 mb-4"></div>
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

	<!-- Logout Modal-->
	<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
					<button class="close" type="button" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">????</span>
					</button>
				</div>
				<div class="modal-body">Select "Logout" below if you are ready
					to end your current session.</div>
				<div class="modal-footer">
					<button class="btn btn-secondary" type="button"
						data-dismiss="modal">Cancel</button>
					<a class="btn btn-primary" href="login.html">Logout</a>
				</div>
			</div>
		</div>
	</div>

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

	<!-- ???????????? ???????????? -->
	<script>
		var ctx = document.getElementById("myChart");

		const myChart = new Chart(
				ctx,
				{
					type : 'line',
					data : {
						labels : [ // Date Objects
						"${productRateList[0].getStock_date()}",
								'${productRateList[1].getStock_date()}',
								'${productRateList[2].getStock_date()}',
								'${productRateList[3].getStock_date()}',
								'${productRateList[4].getStock_date()}',
								'${productRateList[5].getStock_date()}',
								'${productRateList[6].getStock_date()}' ],
						datasets : [
								{
									label : 'My First dataset',
									backgroundColor : 'rgba(75, 192, 192, 1)',
									borderColor : 'rgba(75, 192, 192, 1)',
									fill : false,
									data : [
											"${productRateList[0].getStock_in_sum()}",
											"${productRateList[1].getStock_in_sum()}",
											"${productRateList[2].getStock_in_sum()}",
											"${productRateList[3].getStock_in_sum()}",
											"${productRateList[4].getStock_in_sum()}",
											"${productRateList[5].getStock_in_sum()}",
											"${productRateList[6].getStock_in_sum()}"

									],
								},
								{
									label : 'My Second dataset',
									backgroundColor : 'rgba(255, 99, 132, 1)',
									borderColor : 'rgba(255, 99, 132, 1)',
									fill : false,
									data : [
											"${productRateList[0].getStock_out_sum()}",
											"${productRateList[1].getStock_out_sum()}",
											"${productRateList[2].getStock_out_sum()}",
											"${productRateList[3].getStock_out_sum()}",
											"${productRateList[4].getStock_out_sum()}",
											"${productRateList[5].getStock_out_sum()}",
											"${productRateList[6].getStock_out_sum()}" ],
								} ]
					},
					options : {
						responsive : false,
						scales : {
							yAxes : [ {
								ticks : {
									beginAtZero : true
								}
							} ]
						}
					}
				});
	</script>

	<!-- ???????????? ???????????? -->
    <script>
    var ctx = document.getElementById("myPichart");
    var myPieChart = new Chart(ctx, {
    type: 'doughnut',
    data: {
    labels: ["${StockList[0].getStock_id()}","${StockList[1].getStock_id()}","${StockList[2].getStock_id()}","${StockList[3].getStock_id()}"],
    datasets: [{
        data: ["${StockList[0].getStock_qty()}","${StockList[1].getStock_qty()}","${StockList[2].getStock_qty()}","${StockList[3].getStock_qty()}"],
        backgroundColor: ['rgba(232, 81, 197)', 'rgba(78, 115, 223)', 'rgba(54, 185, 204)', 'rgba(162, 70, 224)'],
        hoverBackgroundColor: ['rgba(207, 39, 169)', 'rgba(51, 97, 232)', 'rgba(27, 162, 181)', 'rgba(137, 46, 217)'],
        hoverBorderColor: "rgba(234, 236, 244, 1)",
    }],
    },
    options: {
        maintainAspectRatio: false,
        tooltips: {
        backgroundColor: "rgb(255,255,255)",
        bodyFontColor: "#858796",
        borderColor: '#dddfeb',
        borderWidth: 1,
        xPadding: 15,
        yPadding: 15,
        displayColors: false,
        caretPadding: 10,
        },
        legend: {
        display: false
        },
        cutoutPercentage: 80,
    },
    });
</script>
</body>

</html>