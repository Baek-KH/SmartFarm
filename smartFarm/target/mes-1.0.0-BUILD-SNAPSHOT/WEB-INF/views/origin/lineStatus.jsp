<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>


    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
	<meta http-equiv="Refresh" content="3">	
	
    <title>SB Admin 2 - Dashboard</title>

    <!-- Custom fonts for this template-->
    <link href="/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="/resources/css/sb-admin-2.min.css" rel="stylesheet">

   <style>
		a.tip {
		    text-align: center;
		    text-decoration: none;
		}
		a.tip:hover{
		    
		    position: relative;
		}
		a.tip span{
		    display: inline-flex;
		    width: 100%;
		}
		a.tip:hover span{
		    border : #000000 2px ;
		    padding: 5px 5px 5px 5px;
		    display: block;
		    z-index: 100;
		    background: blanchedalmond;
		    left: 0px;
		    margin: 10px;
		    width: 250px;    
		    position: absolute;
		    top: 10px;
		    text-decoration: none;
		}
		.gnb li {list-style-type: none; 
			display: inline-block;
			padding: 20px;
			border: 1px solid black;
			word-wrap: break-word;					
			background-color:rgb(78, 115, 223);
			width: 100px;
			height: 30px;
			color: white;
			text-align: center;
			border-radius: 10px 10px 10px 10px;
		    margin-left: 20px;
		    
		}
						
		.gnb li:hover{background-color: gray;
		
		}
				
		.gnb li:active{background-color: red;	
		
		}
				
		a:visited {color: white;
		    
		}		
		
		div.line{
		    margin: auto;
		    text-align: center;
		}


</style>



</head>

<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
        <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

            <!-- Sidebar - Brand -->
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="/index">
                <div class="sidebar-brand-icon rotate-n-15">
                    <i class="fas fa-laugh-wink"></i>
                </div>
                <div class="sidebar-brand-text mx-3">SF <sup></sup></div>
            </a>

            <!-- Divider -->
            <hr class="sidebar-divider my-0">

            <!-- Nav Item - Dashboard -->
            <li class="nav-item active">
                <a class="nav-link" href="/index">
                    <i class="fas fa-fw fa-tachometer-alt"></i>
                    <span>Main Home</span></a>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider">

            <!-- Heading -->
            <div class="sidebar-heading">
            
            </div>

            <!-- ???????????? -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities"
                    aria-expanded="true" aria-controls="collapseUtilities">
                    <i class="fas fa-fw fa-wrench"></i>
                    <span>????????????</span>
                </a>
                <div id="collapseUtilities" class="collapse" aria-labelledby="headingUtilities"
                    data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                   <!-- <h6 class="collapse-header">Custom Utilities:</h6>  ????????? ??? ?????? ?????? ???????????? ?????? -->
                        <a class="collapse-item" href="getAttendenceList.do">???????????????</a>
                        <c:if test="${signIn.getEmp_admin() == 'admin'}">
                        	<a class="collapse-item" href="getEmployeeList.do">????????????</a>
                        	<a class="collapse-item" href="getAttendenceListAdmin.do">????????????</a>
						</c:if>
                    </div>
                </div>
            </li>

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
                            <a class="collapse-item" href="utilities-border.html">tray</a>
                            <a class="collapse-item" href="utilities-border.html">pip</a>

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
                        		<a class="btn btn-warning btn-sm" style="margin-left: 10px" href="/updateAttendence.do">??????</a>
                        	</c:if>
                        	<c:if test="${ attendence.getEmp_id() == NULL }">                        		
                        		<a class="btn btn-success btn-sm " style="margin-left: 10px" href="/insertAttendence.do">??????</a>
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
                        <h1 class="h3 mb-0 text-gray-800">?????? ??????</h1>
                    
                    </div>

                    <!-- Content Row -->
                   
 
                    <!-- ???????????? ????????? -->
                    <div class="row">
                        <!-- ?????? -->
                        
						<c:forEach items="${LineList}" var="LineVO">
						
                        <div class="col">
                            <div class="line" style = "padding: 0px 0px 10px 0px;
                                <c:if test="${  box     }">background-color:red;</c:if>
                                <c:if test="${  box     }">background-color:blue;</c:if>
                            " >
                            <h1>${LineVO.getLine_id() }??? ??????</h1>
                            </div>
                            <div>
                            <ul class="gnb">
                                <li><div><a href="#" class="tip" >1???<span>1??? ???????????? ??? ????????? ?????????????????????? <br>
                                                                    2??? ????????? ????????? <br>
                                                                    3??? ?????? <br>
                                                                    4??? ??????    </span> </a></div></li>
                                <li><a href="#" class="tip">2???<span>???????????? ??? ????????? ??????????</span> </a></li>
                                <li><a href="#" class="tip">3???<span>???????????? ??? ????????? ??????????</span> </a></li>
                                <li><a href="#" class="tip">4???<span>???????????? ??? ????????? ??????????</span> </a></li>
                                <li><a href="#" class="tip">5???<span>???????????? ??? ????????? ??????????</span> </a></li>
                                <li><a href="#" class="tip">6???<span>???????????? ??? ????????? ??????????</span> </a></li>
                                <li><a href="#" class="tip">7???<span>???????????? ??? ????????? ??????????</span> </a></li>
                                <li><a href="#" class="tip">8???<span>???????????? ??? ????????? ??????????</span> </a></li>
                            </ul>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-bordered" id="" width="100%" cellspacing="0">
                                        <thead>
                                            <tr>
                                                <th>??????</th>
                                                <th>?????????</th>
                                                
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>?????? ?????? </td>
                                                <td style="
                                                
                                                
	                                           
	                                            <c:if test="${LineVO.getLine_status().length()>5}"
	                                            >background-color:red;</c:if>
	                                            <c:if test="${LineVO.getLine_status().length()<5 && LineVO.getLine_status().length()>1 }"
	                                            >background-color:yellow;</c:if>
                                               
                                                <c:if test="${LineVO.getLine_status().length()==0}"
                                                >background-color:green;</c:if>
                                                
                                                
                                                ">
                                                ${LineVO.getLine_status()}</td>
                                                
                                            </tr>
                                            <tr>
                                                <td>?????? ?????? ??????</td>
                                                <td>                                                	
	                                                <c:if test="${LineVO.getLine_status().length()>5}"
		                                            >??????</c:if>
		                                            <c:if test="${LineVO.getLine_status().length()<5 && LineVO.getLine_status().length()>1 }"
		                                            >?????? ???</c:if>
	                                                <c:if test="${LineVO.getLine_status().length()==0}"
	                                                >??????</c:if>
                                                </td>
                                                
                                            </tr>
                                            <tr>
                                                <td>?????? ?????? ??????</td>
                                                <td>
                                                	 <c:if test="${LineVO.getLine_status().length()>5}"
		                                            >?????? ???</c:if>
		                                            <c:if test="${LineVO.getLine_status().length()<5 && LineVO.getLine_status().length()>1 }"
		                                            >??????</c:if>
	                                                <c:if test="${LineVO.getLine_status().length()==0}"
	                                                >??????</c:if>
                                                </td>
                                                
                                            </tr>
                                            
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                        <div style = "padding: 0px 0px 0px 0px; text-align: center;
                                <c:if test="${  box     }">background-color:red;</c:if>
                                <c:if test="${  box     }">background-color:blue;</c:if>
                            " >
                          
                            </div>
                        </div>
                    	</c:forEach>
                    
                    
                    
                    

                    <!-- Content Row -->
                    <div class="row">

                        <!-- Content Column -->
                        <div class="col-lg-6 mb-4">

                            

                        </div>

                        <div class="col-lg-6 mb-4">


                        </div>
                    </div>

                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->
			</div>
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
	function reloadTime(){  
	      setTimeout(reload(),10000); 
	}
</script> -->

</html>