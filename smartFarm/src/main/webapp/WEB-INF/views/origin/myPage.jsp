<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin 2 - Dashboard</title>

    <!-- Custom fonts for this template-->
    <link href="/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
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
        <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

            <!-- Sidebar - Brand -->
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.html">
                <div class="sidebar-brand-text mx-1" style="font-size:2.0em;">SF <sup></sup></div>
            </a>

            <!-- Divider -->
            <hr class="sidebar-divider my-0">

            <!-- Nav Item - Dashboard -->
            <li class="nav-item active">
                <a class="nav-link" href="index.html">
                    
                    <span>Main Home</span></a>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider">

            <!-- Heading -->
            <div class="sidebar-heading">
            
            </div>

           <!-- 사원관리 -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities"
                    aria-expanded="true" aria-controls="collapseUtilities">
                    <i class="fas fa-fw fa-wrench"></i>
                    <span>사원관리</span>
                </a>
                <div id="collapseUtilities" class="collapse" aria-labelledby="headingUtilities"
                    data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                   <!-- <h6 class="collapse-header">Custom Utilities:</h6>  여기다 글 쓰면 위에 주석처럼 달림 -->
                        <a class="collapse-item" href="getAttendenceList.do">마이페이지</a>
                        <c:if test="${signIn.getEmp_admin() == 'admin'}">
                        	<a class="collapse-item" href="getEmployeeList.do">사원관리</a>
                        	<a class="collapse-item" href="getAttendenceListAdmin.do">근태관리</a>
						</c:if>
                    </div>
                </div>
            </li>

            <!-- Nav Item - Utilities Collapse Menu -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo"
                    aria-expanded="true" aria-controls="collapseTwo">
                    <i class="fas fa-fw fa-cog"></i>
                    <span>입/출</span>
                </a>
                <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <a class="collapse-item" href="buttons.html">입출/등록</a>
                        <a class="collapse-item" href="cards.html">재고</a>
                    </div>
                </div>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider">
            <!-- 재배현황 -->
            
            <li class="nav-item">
                <a class="nav-link" href="charts.html">
                    <i class="fas fa-fw fa-chart-area"></i>
                    <span>재배현황</span></a>
            </li>

           <!-- Nav Item - Tables -->
			<c:if test="${signIn.getEmp_admin() == 'admin'}">
				
                
                <!-- 재배관리 사이드바 시작 -->
                <li class="nav-item">
                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilitiess"
                        aria-expanded="true" aria-controls="collapseUtilities">
                        <i class="fas fa-fw fa-wrench"></i>
                        <span>재배관리</span>
                    </a>
                    <div id="collapseUtilitiess" class="collapse" aria-labelledby="headingUtilities"
                        data-parent="#accordionSidebar">
                        <div class="bg-white py-2 collapse-inner rounded">
                            <!-- <h6 class="collapse-header">Custom Utilities:</h6>  여기다 글 쓰면 위에 주석처럼 달림 -->
                            <a class="collapse-item" href="getLineSettingList.do">라인설정</a>
                            <a class="collapse-item" href="utilities-border.html">tray</a>
                            <a class="collapse-item" href="utilities-border.html">pip</a>

                        </div>
                    </div>
                </li>
                <!-- 재배관리 사이드바 끝 -->



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
                <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                    <!-- Sidebar Toggle (Topbar) -->
                    <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                        <i class="fa fa-bars"></i>
                    </button>


                    <!-- Topbar Navbar -->
                    <ul class="navbar-nav ml-auto col-3">
	
                        <div class="topbar-divider d-none d-lg-block"></div>

                        <!-- Log Out -->
                        
                        <c:if test="${ signIn.getEmp_id() != NUll }">
                        
                        	<c:if test="${ attendence.getEmp_id() != NULL }">
                        		<small style="margin-left: 10px">${attendence.getAtt_work_on()}</small></br>
                        		<a class="btn btn-warning btn-sm" style="margin-left: 10px" href="/updateAttendence.do">퇴근</a>
                        	</c:if>
                        	<c:if test="${ attendence.getEmp_id() == NULL }">                        		
                        		<a class="btn btn-success btn-sm " style="margin-left: 10px" href="/insertAttendence.do">출근</a>
                        	</c:if>
                        	</br>
                        	
                        	<a class="btn btn-success btn-sm "  style="margin-left: 10px" href="signOut.do">Log Out</a>
                        </c:if>
						<c:if test="${ signIn.getEmp_id() == NUll }">
                        	<a class="btn btn-success btn-sm " style="margin-left: 10px"  href="/">Log In</a>					
						</c:if>
                    </ul>

                </nav>
                <!-- End of Topbar -->

                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <div class="d-sm-flex align-items-center justify-content-between mb-4">
                        <h1 class="h3 mb-0 text-gray-800">Dashboard</h1>
                        <a href="#" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
                                class="fas fa-download fa-sm text-white-50"></i> Generate Report</a>
                    </div>

                    <!-- Content Row -->
                    <div class="container-fluid">

                        <!-- Page Heading -->
                        <h1 class="h3 mb-2 text-gray-800">사원 마이페이지</h1>
    
                        <!-- DataTales Example -->
                        <div class="card shadow mb-4">
                            <div class="card-header py-3">
                                <h6 class="m-0 font-weight-bold text-primary">사원 정보</h6>
                            </div>
                            <div class="card-body">
                            <div class="table-responsive">
                            	<form action="" method="">
                                <table class="table table-bordered" id="dataTable4" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th class="col-3">아이디</th>
                                            <th class="col-3">사원번호</th>
                                            <th class="col-3">이름</th>
                                            <th class="col-3">이메일</th>
                                        </tr>
                                    </thead>

                                    <tbody>
                                        <tr>
                                            
                                            <td>
                                            	<input class="" type="text" name="emp_id" placeholder="${signIn.getEmp_id()}" disabled="disabled">
                                            	<input class="" type="hidden" name="emp_id" value="${signIn.getEmp_id()}">
                                            </td>
                                            <td>
                                            	<input class="" type="text" name="emp_no" placeholder="${signIn.getEmp_no()}"  disabled="disabled">
                                            	<input class="" type="hidden" name="emp_no" value="${signIn.getEmp_no()}"  >
                                            </td>
                                            <td>
                                            	<input class="" type="text" name="emp_name" placeholder="${signIn.getEmp_name()}"  disabled="disabled">
                                            	<input class="" type="hidden" name="emp_name" value="${signIn.getEmp_name()}"  >
                                            </td>
                                            <td>
                                            	<input type="text" name="emp_email" placeholder="${signIn.getEmp_email()}" disabled="disabled">
                                            </td>
                                            
                                        </tr>
                                        
                                    </tbody>

                                    <thead>
                                        <tr>
                                            <th class="">패스워드</th>
                                            <th class="">권한</th>
                                            <th class=""></th>
                                            <th class=""></th>
                                        </tr>
                                    </thead>

                                    <tbody>
                                        <tr>
                                        	<td>
                                            <input class="" type="text" name="emp_pw" placeholder="${signIn.getEmp_pw()}" disabled="disabled" >
                                        	</td>
                                            <td>
                                            <input class="" type="text" name="emp_admin()" placeholder="${signIn.getEmp_name()}"  disabled="disabled">
                                            <input class="" type="hidden" name="emp_admin()" value="${signIn.getEmp_name()}"  >
                                            </td>
                                            
                                        </tr>  
                                        
                                    </tbody>

                                </table>
                               		<small class="float-right">사원 정보 수정은 관리자에게 문의하세요</small>
                            	</form>
                            </div>
                        </div>
                        <!-- 사원 정보 -->
                            
                            
                            
                            
                            
                            
                            
                            <div class="card-header py-3">
                                <h6 class="m-0 font-weight-bold text-primary">근태 기록</h6>
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                        <thead>
                                            <tr>
                                                <th>이름</th>
                                                <th>출근</th>
                                                <th>퇴근</th>
                                                <th>비고</th>
                                                
                                            </tr>
                                        </thead>
                                        
		                                 <tbody>
                                        <c:forEach items="${AttendenceList}" var="attendence">
                                            <tr>
                                                <td>${attendence.getEmp_name()}</td>
                                                <td>${attendence.getAtt_work_on()}</td>
                                                <td>${attendence.getAtt_work_off()}</td>
                                                <td>${attendence.getAtt_dayoff()}</td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                       
                                    </table>
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
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

    <!-- Logout Modal-->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
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