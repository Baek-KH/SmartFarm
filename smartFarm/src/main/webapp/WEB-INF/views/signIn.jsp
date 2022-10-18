<%@page language="java" contentType="text/html; charset=UTF-8"
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

    <title>signIn</title>

   <!-- Custom fonts for this template-->
    <link href="/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
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
					<i class="fa-solid fa-crown"></i> <span>Main Home</span>
			</a></li>

			

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
					
					
					

				</nav>
				<!-- End of Topbar -->

                <!-- Begin Page Content -->
                <div class="container-fluid">
                    <div class="row justify-content-center">

                        <div class="col-xl-10 col-lg-12 col-md-9">
            
                            <div class="card o-hidden border-0 shadow-lg my-5">
                                
                                <div class="card-body p-1" >
                                    <!-- Nested Row within Card Body -->
                                    
                                        
                                        <div class="col-lg-12">
                                            <div class="p-5">
                                                <div class="text-center">
                                                    <h1 class="h4 text-gray-900 mb-4">Welcome Smart Farm!</h1>
                                                </div>
                                                <form action="signin.do" class="user" method="post">
                                                    <div class="form-group">
                                                        <input type="test" class="form-control form-control-user" name="emp_id"
                                                            id="exampleInputEmail" aria-describedby="emailHelp"
                                                            placeholder="Enter Id...">
                                                    </div>
                                                    <div class="form-group">
                                                        <input type="password" class="form-control form-control-user" name="emp_pw"
                                                            id="exampleInputPassword" placeholder="Password">
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="custom-control custom-checkbox small">
                                                            <input type="checkbox" class="custom-control-input" id="customCheck">
                                                            <label class="custom-control-label" for="customCheck">Remember
                                                                Me</label>
                                                        </div>
                                                    </div>
                                                    <input type="submit" value="SignIn" class="btn btn-user btn-block" style="background-color:rgba(46,139,87); color:white;">
                                             
                                                    <hr>
                                                    
                                                </form>
                                                <hr>
                                                
                                            </div>
                                        </div>
                                    
                                </div>
                            </div>
            
                        </div>
            
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

</html>