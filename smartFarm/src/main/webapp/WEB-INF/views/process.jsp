<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<style>
.myProgress {
  position: relative;
  width: 100%;
  height: 30px;
  background-color: #ddd;
}

.myBar {
  position: absolute;
  min-width:20%;
  max-width:100%;
  height: 100%;
  background-color: #4CAF50;
}

.label {
  text-align: center;
  line-height: 30px;
  color: white;
}
</style>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>process</title>

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
					<i class="fa-solid fa-house"></i> <span>Main Home</span>
			</a></li>

			<!-- Divider -->
			<hr class="sidebar-divider">

			<!-- Heading -->
			<div class="sidebar-heading"></div>

			<!-- ???????????? -->
			<li class="nav-item"><a class="nav-link collapsed" href="#"
				data-toggle="collapse" data-target="#collapseUtilities"
				aria-expanded="true" aria-controls="collapseUtilities"> 
				<i class="fa-solid fa-person"></i> <span>????????????</span>
			</a>
				<div id="collapseUtilities" class="collapse"
					aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
					<div class="bg-white py-2 collapse-inner rounded">
						<!-- <h6 class="collapse-header">Custom Utilities:</h6>  ????????? ??? ?????? ?????? ???????????? ?????? -->
						<a class="collapse-item" href="getAttendenceList.do"><i class="fa-regular fa-id-card"></i> ???????????????</a>
						<c:if test="${signIn.getEmp_admin() == 'admin'}">
							<a class="collapse-item" href="getEmployeeList.do"><i class="fa-solid fa-people-arrows"></i> ????????????</a>
							<a class="collapse-item" href="getAttendenceListAdmin.do"><i class="fa-solid fa-people-roof"></i> ????????????</a>
						</c:if>
					</div>
				</div></li>

				<!-- Nav Item - Utilities Collapse Menu -->
			<li class="nav-item"><a class="nav-link collapsed" href="#"
				data-toggle="collapse" data-target="#collapseTwo"
				aria-expanded="true" aria-controls="collapseTwo"> 
				<i class="fa-solid fa-cart-flatbed"></i><span>????????????</span>
			</a>
				<div id="collapseTwo" class="collapse" aria-labelledby="headingTwo"
					data-parent="#accordionSidebar">
					<div class="bg-white py-2 collapse-inner rounded">
						<%-- <h6 class="collapse-header">Custom Components:</h6> ????????? ????????? ?????? ???????????? ?????? --%>
						<a class="collapse-item" href="getStockHistoryList.do"><i class="fa-solid fa-truck-fast"></i> ??????/??????</a><a
							class="collapse-item" href="getStockList.do"><i class="fa-solid fa-warehouse"></i> ??????</a>
					</div>
				</div></li>



			<!-- Divider -->
			<hr class="sidebar-divider">
			<!-- ???????????? -->

			<li class="nav-item"><a class="nav-link" href="getLineList.do">
				<i class="fa-solid fa-leaf"></i> <span>????????????</span>
			</a></li>

			<!-- Nav Item - Tables -->
			<c:if test="${signIn.getEmp_admin() == 'admin'}">
				
                
                <!-- ???????????? ???????????? ?????? -->
                <li class="nav-item">
                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilitiess"
                        aria-expanded="true" aria-controls="collapseUtilities">
                 	  <i class="fa-solid fa-seedling"></i>
                        <span>????????????</span>
                    </a>
                    <div id="collapseUtilitiess" class="collapse" aria-labelledby="headingUtilities"
                        data-parent="#accordionSidebar">
                        <div class="bg-white py-2 collapse-inner rounded">
                            <!-- <h6 class="collapse-header">Custom Utilities:</h6>  ????????? ??? ?????? ?????? ???????????? ?????? -->
                            <a class="collapse-item" href="getLineSettingList.do"><i class="fa-solid fa-gear"></i> ????????????</a>
                            <a class="collapse-item" href="getTrayList.do"><i class="fa-solid fa-plate-wheat"></i> TRAY</a>
                            <a class="collapse-item" href="getPipList.do"><i class="fa-solid fa-mound"></i> PIP</a>
                          

                        </div>
                    </div>
                </li>
                <!-- ???????????? ???????????? ??? -->
	    		<!-- ???????????? ???????????? ?????????????????? ???????????? li ?????? -->
                <li class="nav-item">
                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo2"
                        aria-expanded="true" aria-controls="collapseTwo2">
                        <i class="fa-solid fa-wallet"></i>
                        <span>????????????</span>
                    </a>
                    <div id="collapseTwo2" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                        <div class="bg-white py-2 collapse-inner rounded">
                            <a class="collapse-item" href="getBuyerList.do"><i class="fa-solid fa-money-bill-1"></i> ????????? ??????</a>
                            <a class="collapse-item" href="getOrdersList.do"><i class="fa-regular fa-money-bill-1"></i> ?????? ??????</a>
                        </div>
                    </div>
                </li>

			<!-- ???????????? ???????????? -->
				<li class="nav-item"><a class="nav-link" href="getForwardList.do">
						<i class="fa-solid fa-truck"></i> <span>????????????</span>
				</a></li>
				
				
				
				<li class="nav-item"><a class="nav-link" href="TrayControlList.do?line_id=1">
						<i class="fa-solid fa-gears"></i> <span>????????????</span>
				</a></li>
				<!-- ???????????? ???????????? -->



				<li class="nav-item"><a class="nav-link" href="report.do">
						<i class="fa-solid fa-eye"></i> <span>???????????????</span>
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
									href="/updateAttendence.do">??????</a>
							</c:if>
							<c:if test="${ attendence.getEmp_id() == NULL }">
								<a class="btn btn-success btn-sm " style="margin-left: 10px; border-color:white; width: 40%; text-align: center; "
									href="/insertAttendence.do">??????</a>
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
                    <!-- <div class="d-sm-flex align-items-center justify-content-between mb-4">
                        <h1 class="h3 mb-0 text-gray-800">Dashboard</h1>
                    
                    </div> -->

                    <!-- Content Row -->
                    

                    <!-- Content Row -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">????????????</h6>
                        </div>

					<div>
                        <div>
                        <div class="card-body">
                            <div class="table-responsive">

                                    <!-- ????????? ??? ???????????? ???????????? -->
                                    <script>
                                                
                                        var change = function(obj){
                                            document.getElementById('form').submit();
                                        
                                        }
                                        
                                        </script>


                                        <!-- ????????? ????????? -->
                                    <div class="">
                                        <form action="TrayControlList.do" id="form">
                                        	<div >
	                                        <div style="float:left;">
	                                            <select name="line_id" id="selBox" onchange="change(this)" class=""  >
	                                            	<option value="" selected="selected" disabled="disabled">LINE</option>
	                                                <option value="1">1</option>
	                                                <option value="2">2</option>
	                                                <option value="3">3</option>
	                                                <option value="4">4</option>
	                                            </select>
	                                             </div>
	                                            
	                                             <div align="center">  <h2>  ${line_id }  ??? ?????? ?????????</h2></div>
	                                            
	                                         </div> 
                                           
                                        </form>
                                </div>
                                <table class="table table-bordered" id="dataTable4" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            
                                            <th colspan="3"><center>1??????</center></th>
                                            <th colspan="3"><center>2??????</center></th>
                                            
                                        </tr>
                                    </thead>



								<!-- tray table start  -->
                                    <thead>
                                        <tr>
                                            <th>??????</th>
                                            <th colspan="2">1??? ????????? ??????</th>
                                            <th>??????</th>
                                            <th colspan="2">5??? ????????? ??????</th>
                                            
                                        </tr>
                                    </thead>

                                    <tbody>
                                    
                                        <tr>
                                            <td class="col-1">1</td>
                                            <td class="col-3">
                                            	<div class="myProgress" >
                                            	
												  <div class="myBar" style="width:${TrayList[0].getTray_growthPer()/15*100}%; ">
												    <div class="label" > 
														 <fmt:formatNumber value="${TrayList[0].getTray_growthPer()/15*100}"  maxFractionDigits="2"/>%  	
                                                	</div>
												  </div>
												</div>
                                            	<h5>
                                                ????????? : ${TrayList[0].getTray_end_date()}<br>
                                                ???????????? : ${TrayList[0].getTray_growth()}
                                                &nbsp&nbsp&nbsp&nbsp&nbsp?????? : ${TrayList[0].getPip_qty()}
                                            	</h5>
                                                <p class="tet" style="color:red;"></p>
                                            </td>
                                            <td class="col-2" align="center">
                                                <input style="background-color:rgba(46,139,87); color:white;" class="btn  " type="submit" value="????????? ??????">
                                               
                                                
                                            </td>

                                            <td class="col-sm-1">5</td>
                                           <td class="col-3">
                                            	<div class="myProgress" >
												  <div class="myBar" style="width:${TrayList[4].getTray_growthPer()/15*100}%;">
												    <div class="label" > 
														 <fmt:formatNumber value="${TrayList[4].getTray_growthPer()/15*100}"  maxFractionDigits="2"/>%  	
                                                	</div>
												  </div>
												</div>
                                            	<h5>
                                                ????????? : ${TrayList[4].getTray_end_date()}<br>
                                                ???????????? : ${TrayList[4].getTray_growth()}
                                                &nbsp&nbsp&nbsp&nbsp&nbsp?????? : ${TrayList[4].getPip_qty()}
                                            	</h5>
                                                <p class="tet" style="color:red;"></p>
                                            </td>
                                            <td class="col-2" align="center">
                                                 <input style="background-color:rgba(46,139,87); color:white;" class="btn  " type="submit" value="????????? ??????">
                                            </td>
                                        </tr>
                                    </tbody>

                              
                               <!-- tray table end  -->
								<!-- tray table start2  -->
                                    <thead>
                                        <tr>
                                            <th>??????</th>
                                            <th colspan="2">2??? ????????? ??????</th>
                                            <th>??????</th>
                                            <th colspan="2">6??? ????????? ??????</th>
                                            
                                        </tr>
                                    </thead>

                                    <tbody>
                                    
                                        <tr>
                                            <td class="col-1">2</td>
                                            <td class="col-3">
                                            	<div class="myProgress" >
												  <div class="myBar" style="width:${TrayList[1].getTray_growthPer()/15*100}%;">
												    <div class="label" > 
														 <fmt:formatNumber value="${TrayList[1].getTray_growthPer()/15*100}"  maxFractionDigits="2"/>%  	
                                                	</div>
												  </div>
												</div>
                                            	<h5>
                                                ????????? : ${TrayList[1].getTray_end_date()}<br>
                                                ???????????? : ${TrayList[1].getTray_growth()}
                                                &nbsp&nbsp&nbsp&nbsp&nbsp?????? : ${TrayList[1].getPip_qty()}
                                            	</h5>
                                                <p class="tet" style="color:red;"></p>
                                            </td>
                                            <td class="col-2" align="center">
                                                <input style="background-color:rgba(46,139,87); color:white;" class="btn  " type="submit" value="????????? ??????">
                                                
                                            </td>

                                            <td class="col-sm-1">6</td>
                                            <td class="col-3">
                                            	<div class="myProgress" >
												  <div class="myBar" style="width:${TrayList[5].getTray_growthPer()/15*100}%;">
												    <div class="label" > 
														 <fmt:formatNumber value="${TrayList[5].getTray_growthPer()/15*100}"  maxFractionDigits="2"/>%  	
                                                	</div>
												  </div>
												</div>
                                            	<h5>
                                                ????????? : ${TrayList[5].getTray_end_date()}<br>
                                                ???????????? : ${TrayList[5].getTray_growth()}
                                                &nbsp&nbsp&nbsp&nbsp&nbsp?????? : ${TrayList[5].getPip_qty()}
                                            	</h5>
                                                <p class="tet" style="color:red;"></p>
                                            </td>
                                            <td class="col-2" align="center">
                                                 <input style="background-color:rgba(46,139,87); color:white;" class="btn  " type="submit" value="????????? ??????">
                                            </td>
                                        </tr>
                                    </tbody>

                             
                               <!-- tray table end2  -->
                               <!-- tray table start3  -->
                                    <thead>
                                        <tr>
                                            <th>??????</th>
                                            <th colspan="2">3??? ????????? ??????</th>
                                            <th>??????</th>
                                            <th colspan="2">7??? ????????? ??????</th>
                                            
                                        </tr>
                                    </thead>

                                    <tbody>
                                    
                                        <tr>
                                            <td class="col-1">3</td>
                                            <td class="col-3">
                                            	<div class="myProgress" >
												  <div class="myBar" style="width:${TrayList[2].getTray_growthPer()/15*100}%;">
												    <div class="label" > 
														 <fmt:formatNumber value="${TrayList[2].getTray_growthPer()/15*100}"  maxFractionDigits="2"/>%  	
                                                	</div>
												  </div>
												</div>
                                            	<h5>
                                                ????????? : ${TrayList[2].getTray_end_date()}<br>
                                                ???????????? : ${TrayList[2].getTray_growth()}
                                                &nbsp&nbsp&nbsp&nbsp&nbsp?????? : ${TrayList[2].getPip_qty()}
                                            	</h5>
                                                <p class="tet" style="color:red;"></p>
                                            </td>
                                            <td class="col-2" align="center">
                                                 <input style="background-color:rgba(46,139,87); color:white;" class="btn  " type="submit" value="????????? ??????">
                                                
                                            </td>

                                            <td class="col-sm-1">7</td>
                                            <td class="col-3">
                                            	<div class="myProgress" >
												  <div class="myBar" style="width:${TrayList[6].getTray_growthPer()/15*100}%;">
												    <div class="label" > 
														 <fmt:formatNumber value="${TrayList[6].getTray_growthPer()/15*100}"  maxFractionDigits="2"/>%  	
                                                	</div>
												  </div>
												</div>
                                            	<h5>
                                            	????????? : ${TrayList[6].getTray_end_date()}<br>
                                                ???????????? : ${TrayList[6].getTray_growth()}
                                                &nbsp&nbsp&nbsp&nbsp&nbsp?????? : ${TrayList[6].getPip_qty()}
                                            	</h5>
                                                <p class="tet" style="color:red;"></p>
                                            </td>
                                            <td class="col-2" align="center">
                                                 <input style="background-color:rgba(46,139,87); color:white;" class="btn  " type="submit" value="????????? ??????">
                                            </td>
                                        </tr>
                                    </tbody>

                               
                               <!-- tray table end3  -->
                               <!-- tray table start4  -->
                                    <thead>
                                        <tr>
                                            <th>??????</th>
                                            <th colspan="2">4??? ????????? ??????</th>
                                            <th>??????</th>
                                            <th colspan="2">8??? ????????? ??????</th>
                                            
                                        </tr>
                                    </thead>

                                    <tbody>
                                    
                                        <tr>
                                            <td class="col-1">4</td>
                                            <td class="col-3">
                                            	<div class="myProgress" >
												  <div class="myBar" style="width:${TrayList[3].getTray_growthPer()/15*100}%;">
												    <div class="label" > 
														 <fmt:formatNumber value="${TrayList[3].getTray_growthPer()/15*100}"  maxFractionDigits="2"/>%  	
                                                	</div>
												  </div>
												</div>
                                            	<h5>
                                                ????????? : ${TrayList[3].getTray_end_date()}<br>
                                                ???????????? : ${TrayList[3].getTray_growth()}
                                                &nbsp&nbsp&nbsp&nbsp&nbsp?????? : ${TrayList[3].getPip_qty()}
                                            	</h5>
                                                <p class="tet" style="color:red;"></p>
                                            </td>
                                            <td class="col-2" align="center">
                                                 <input style="background-color:rgba(46,139,87); color:white;" class="btn  " type="submit" value="????????? ??????">
                                                
                                            </td>

                                            <td class="col-sm-1">8</td>
                                            <td class="col-3">
                                            	<div class="myProgress" >
												  <div class="myBar" style="width:${TrayList[7].getTray_growthPer()/15*100}%;">
												    <div class="label" > 
														 <fmt:formatNumber value="${TrayList[7].getTray_growthPer()/15*100}"  maxFractionDigits="2"/>%  	
                                                	</div>
												  </div>
												</div>
                                            	<h5>
                                                ????????? : ${TrayList[7].getTray_end_date()}<br>
                                                ???????????? : ${TrayList[7].getTray_growth()}
                                                &nbsp&nbsp&nbsp&nbsp&nbsp?????? : ${TrayList[7].getPip_qty()}
                                            	</h5>
                                                <p class="tet" style="color:red;"></p>
                                            </td>
                                            <td class="col-2" align="center">
                                                 <input style="background-color:rgba(46,139,87); color:white;" class="btn  " type="submit" value="????????? ??????">
                                            </td>
                                        </tr>
                                    </tbody>

                                </table>
                               <!-- tray table end4  -->
                                    

                                <table class="table table-bordered" id="" width="100%" cellspacing="0">
                                    <!-- ?????? ?????? ????????? ???????????? -->
                                    <thead>
                                        <tr >
                                            <td rowspan="2" class="col-1" style="border-left: hidden;border-top: hidden; border-bottom: hidden;"></td>
                                            <td class="col-3" align="center"><h4>1?????? ?????? ?????? : 15 cm</h4> </td>
                                            <td class="col-2" style="border-top: hidden; border-bottom: hidden;"></td>
                                            <td  class="col-3" align="center"><h4>???????????? : 37cm</h4> </td>
                                            <td class="col-1" style="border-top: hidden; border-bottom: hidden;"></td>
                                            
                                        </tr>
                                        <tr>
                                            <td align="center" ><h4>????????? : <fmt:formatNumber value="${100-TrayList[3].getTray_growthPer()/15*100}" maxFractionDigits="2"/>%</h4></td>
                                            <td style="border-top: hidden; border-bottom: hidden;"></td>
                                            <td align="center" ><h4>????????? : <fmt:formatNumber value="${100-TrayList[7].getTray_growthPer()/15*100}" maxFractionDigits="2"/>%</h4></td>
                                            <td style="border-top: hidden; border-bottom: hidden;"></td>
                                            
                                        </tr>
                                    </thead>
                                    
                                    
                                </table>
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
	function ????????????(){  
	      setTimeout(reload(),10000); 
	}
</script>
 -->
 
<script>





</script>
 
 
 
 
</html>