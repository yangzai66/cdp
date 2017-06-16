<%@ page language="java" contentType="text/html; UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta name="description" content="Dashboard" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>首页</title>
   <jsp:include page="../public/commcss.jsp"></jsp:include>
  </head>
  <body>
  <jsp:include page="../public/top.jsp"></jsp:include>
    <!-- Main Container -->
    <div class="main-container container-fluid">
     <!-- Page Container -->
        <div class="page-container">
        	 <!-- Page Sidebar -->
            <div class="page-sidebar" id="sidebar">
            	 <jsp:include page="../public/left.jsp"></jsp:include>
            </div>
            <div class="page-content">
            	<div class="page-breadcrumbs">
                    <ul class="breadcrumb">
                        <li>
                            <i class="fa fa-home"></i>
                            <a href="#">Home</a>
                        </li>
                        <li class="active">Dashboard</li>
                    </ul>
                </div>
                <div class="page-header position-relative">
                    <div class="header-title">
                        <h1>
                            Dashboard
                        </h1>
                    </div>
                    <!--Header Buttons-->
                    <div class="header-buttons">
                        <a class="sidebar-toggler" href="#">
                            <i class="fa fa-arrows-h"></i>
                        </a>
                        <a class="refresh" id="refresh-toggler" href="">
                            <i class="glyphicon glyphicon-refresh"></i>
                        </a>
                        <a class="fullscreen" id="fullscreen-toggler" href="#">
                            <i class="glyphicon glyphicon-fullscreen"></i>
                        </a>
                    </div>
                    <!--Header Buttons End-->
                </div>
                <div class="page-body">
           <form class="form" action="#">
           <div class="form-title">Add Plan</div>
           <div class="form-group">
            <label style="font-weight:normal;font-size: 15px;line-height:2.3">Title</label>
           <input name="plan_title" class="form-control" type="text" placeholder="Title">
            </div>
           <div class="row">
           	<div class="col-sm-6">
           		<div class="form-group">
                   <label for="exampleInputEmail2">Start Time</label>
                   <span class="input-icon icon-right">
                   <input type="text" class="form-control" data-date-format="yyyy-mm-dd" name="start_time" id="start_time" placeholder="Start Time">
                    <i class="fa fa-calendar"></i>
                   </span>
                </div>
           	</div>
           	<div class="col-sm-6">
           		<div class="form-group">
                   <label for="exampleInputEmail2">End Time</label>
                   <span class="input-icon icon-right">
                   <input type="text" class="form-control" data-date-format="yyyy-mm-dd" name="end_time" id="end_time" placeholder="End Time">
                    <i class="fa fa-calendar"></i>
                   </span>
                </div>
           	</div>
           </div>
            <div class="form-group">
             <label style="font-weight:normal;font-size: 15px;line-height:2.3">View</label>
           	  <div id="plan_content" style="height:150px" class="summernote"></div>
            </div>
              <button id="add_plan_button" class="btn btn-default" type="button">Save</button>
            <button onclick="control_display(2)" class="btn btn-default" type="button">Return</button> 
          </form>
          </div>
    </div>
    <jsp:include page="../public/commjs.jsp"></jsp:include>
   
    <!--Bootstrap Date Picker-->
    <script src="../../assets/js/datetime/bootstrap-datepicker.js"></script>

    <!--Bootstrap Time Picker-->
    <script src="../../assets/js/datetime/bootstrap-timepicker.js"></script>

    <!--Bootstrap Date Range Picker-->
    <script src="../../assets/js/datetime/moment.js"></script>
    <script src="../../assets/js/datetime/daterangepicker.js"></script>
     <script src="../../assets/js/editors/summernote/summernote.js"></script>
     <script type="text/javascript" src="../../js/cdp/way/plan_add.js"></script>
  </body>
  
</html>