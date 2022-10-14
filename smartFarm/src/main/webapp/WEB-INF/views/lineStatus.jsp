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
                                class="fas fa-download fa-sm text-white-50"></i> ${ signIn.getEmp_admin() == 'admin' }..  </a>
                    </div>

                    <!-- Content Row -->
                   
 
                    <!-- 재배현황 변경판 -->
                    <div class="row">
                        <!-- 찾기 -->
                        
						<c:forEach items="${LineList}" var="LineVO">
						
                        <div class="col">
                            <div class="line" style = "padding: 0px 0px 10px 0px;
                                <c:if test="${  box     }">background-color:red;</c:if>
                                <c:if test="${  box     }">background-color:blue;</c:if>
                            " >
                            <h1>${LineVO.getLine_id() }</h1>
                            </div>
                            <div>
                            <ul class="gnb">
                                <li><div><a href="#" class="tip" >1번<span>1줄 여기다가 머 넣으면 될려나?머야이건 <br>
                                                                    2줄 여기다 호에엥 <br>
                                                                    3줄 메차 <br>
                                                                    4줄 쿠차    </span> </a></div></li>
                                <li><a href="#" class="tip">2번<span>여기다가 머 넣으면 될려나?</span> </a></li>
                                <li><a href="#" class="tip">3번<span>여기다가 머 넣으면 될려나?</span> </a></li>
                                <li><a href="#" class="tip">4번<span>여기다가 머 넣으면 될려나?</span> </a></li>
                                <li><a href="#" class="tip">5번<span>여기다가 머 넣으면 될려나?</span> </a></li>
                                <li><a href="#" class="tip">6번<span>여기다가 머 넣으면 될려나?</span> </a></li>
                                <li><a href="#" class="tip">7번<span>여기다가 머 넣으면 될려나?</span> </a></li>
                                <li><a href="#" class="tip">8번<span>여기다가 머 넣으면 될려나?</span> </a></li>
                            </ul>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-bordered" id="" width="100%" cellspacing="0">
                                        <thead>
                                            <tr>
                                                <th>날짜</th>
                                                <th>에러명</th>
                                                
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>라인 상태 </td>
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
                                                <td>Garrett Winters</td>
                                                <td>Accountant</td>
                                                
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
                            1라인 에러표시
                            </div>
                        </div>
                    	</c:forEach>
                    
                    
                    
                    <%-- 
                        <div class="col">
                            <div class="line" style = "padding: 0px 0px 10px 0px;
                                <c:if test="${  box     }">background-color:red;</c:if>
                                <c:if test="${  box     }">background-color:blue;</c:if>
                            " >
                            <h1>2라인</h1>
                            </div>
                            <div>
                            <ul class="gnb">
                                <li><div><a href="#" class="tip" >1번<span>1줄 여기다가 머 넣으면 될려나?머야이건 <br>
                                                                    2줄 여기다 호에엥 <br>
                                                                    3줄 메차 <br>
                                                                    4줄 쿠차    </span> </a></div></li>
                                <li><a href="#" class="tip">2번<span>여기다가 머 넣으면 될려나?</span> </a></li>
                                <li><a href="#" class="tip">3번<span>여기다가 머 넣으면 될려나?</span> </a></li>
                                <li><a href="#" class="tip">4번<span>여기다가 머 넣으면 될려나?</span> </a></li>
                                <li><a href="#" class="tip">5번<span>여기다가 머 넣으면 될려나?</span> </a></li>
                                <li><a href="#" class="tip">6번<span>여기다가 머 넣으면 될려나?</span> </a></li>
                                <li><a href="#" class="tip">7번<span>여기다가 머 넣으면 될려나?</span> </a></li>
                                <li><a href="#" class="tip">8번<span>여기다가 머 넣으면 될려나?</span> </a></li>
                            </ul>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-bordered" id="" width="100%" cellspacing="0">
                                        <thead>
                                            <tr>
                                                <th>날짜</th>
                                                <th>에러명</th>
                                                
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>Tiger Nixon</td>
                                                <td>System Architect</td>
                                                
                                            </tr>
                                            <tr>
                                                <td>Garrett Winters</td>
                                                <td>Accountant</td>
                                                
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
                            2라인 에러표시
                            </div>
                        </div>

                        <div class="col">
                            <div class="line" style = "padding: 0px 0px 10px 0px;
                                <c:if test="${  box     }">background-color:red;</c:if>
                                <c:if test="${  box     }">background-color:blue;</c:if>
                            " >
                            <h1>3라인</h1>
                            </div>
                            <div>
                            <ul class="gnb">
                                <li><div><a href="#" class="tip" >1번<span>1줄 여기다가 머 넣으면 될려나?머야이건 <br>
                                                                    2줄 여기다 호에엥 <br>
                                                                    3줄 메차 <br>
                                                                    4줄 쿠차    </span> </a></div></li>
                                <li><a href="#" class="tip">2번<span>여기다가 머 넣으면 될려나?</span> </a></li>
                                <li><a href="#" class="tip">3번<span>여기다가 머 넣으면 될려나?</span> </a></li>
                                <li><a href="#" class="tip">4번<span>여기다가 머 넣으면 될려나?</span> </a></li>
                                <li><a href="#" class="tip">5번<span>여기다가 머 넣으면 될려나?</span> </a></li>
                                <li><a href="#" class="tip">6번<span>여기다가 머 넣으면 될려나?</span> </a></li>
                                <li><a href="#" class="tip">7번<span>여기다가 머 넣으면 될려나?</span> </a></li>
                                <li><a href="#" class="tip">8번<span>여기다가 머 넣으면 될려나?</span> </a></li>
                            </ul>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-bordered" id="" width="100%" cellspacing="0">
                                        <thead>
                                            <tr>
                                                <th>날짜</th>
                                                <th>에러명</th>
                                                
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>Tiger Nixon</td>
                                                <td>System Architect</td>
                                                
                                            </tr>
                                            <tr>
                                                <td>Garrett Winters</td>
                                                <td>Accountant</td>
                                                
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
                            3라인 에러표시
                            </div>
                        </div>

                        <div class="col">
                            <div class="line" style = "padding: 0px 0px 10px 0px;
                                <c:if test="${  box     }">background-color:red;</c:if>
                                <c:if test="${  box     }">background-color:blue;</c:if>
                            " >
                            <h1>4라인</h1>
                            </div>
                            <div>
                            <ul class="gnb">
                                <li><div><a href="#" class="tip" >1번<span>1줄 여기다가 머 넣으면 될려나?머야이건 <br>
                                                                    2줄 여기다 호에엥 <br>
                                                                    3줄 메차 <br>
                                                                    4줄 쿠차    </span> </a></div></li>
                                <li><a href="#" class="tip">2번<span>여기다가 머 넣으면 될려나?</span> </a></li>
                                <li><a href="#" class="tip">3번<span>여기다가 머 넣으면 될려나?</span> </a></li>
                                <li><a href="#" class="tip">4번<span>여기다가 머 넣으면 될려나?</span> </a></li>
                                <li><a href="#" class="tip">5번<span>여기다가 머 넣으면 될려나?</span> </a></li>
                                <li><a href="#" class="tip">6번<span>여기다가 머 넣으면 될려나?</span> </a></li>
                                <li><a href="#" class="tip">7번<span>여기다가 머 넣으면 될려나?</span> </a></li>
                                <li><a href="#" class="tip">8번<span>여기다가 머 넣으면 될려나?</span> </a></li>
                            </ul>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-bordered" id="" width="100%" cellspacing="0">
                                        <thead>
                                            <tr>
                                                <th>날짜</th>
                                                <th>에러명</th>
                                                
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>Tiger Nixon</td>
                                                <td>System Architect</td>
                                                
                                            </tr>
                                            <tr>
                                                <td>Garrett Winters</td>
                                                <td>Accountant</td>
                                                
                                            </tr>
                                            
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                        <div style = "padding: 0px 0px 0px 0px; text-align: center;
                                <c:if test="${  box     }">background-color:red;</c:if>
                                <c:if test="${  box   }">background-color:blue;</c:if>
                            " >
                            4라인 에러표시
                            </div>
                        </div> --%>

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