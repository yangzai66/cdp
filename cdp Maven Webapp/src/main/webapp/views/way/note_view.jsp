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
           			<div id="note_view_div">
          <h2 id="note_view_title"></h2>
          <form class="form" action="#">
            <div class="form-group" style="text-align: right;">
            <label style="font-weight:normal;font-size: 12px;line-height:2.3">类型:</label>
           	<span style="font-size:12px" id="note_view_type"></span>&nbsp;&nbsp;&nbsp;&nbsp;
           	<label style="font-weight:normal;font-size: 12px;line-height:2.3">创建时间:</label>
           	<span id="note_view_createtime"></span>
            </div>
              <div class="form-group">
           	  <div id="note_view_content"></div>
            </div>
            <button onclick="control_display(2)" class="btn btn-info" type="button">返回列表</button>      
          </form>
          </div>
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
     <script type="text/javascript" src="../../js/cdp/way/note_view.js"></script>
  </body>
  
</html>