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
                <div id="note_list_div">
                	<div class="row">
                	<div class="col-lg-9 col-sm-9 col-xs-9">
                		<a class="btn btn-default purple" id="new_note" href="note_add.jsp?m=2-5"><i class="fa fa-plus"></i> Add</a>
                	</div>
                	<div class="col-lg-3 col-sm-3 col-xs-3">
                		<div class="input-group">
                              <span class="input-group-addon">
                              <i class="fa fa-calendar"></i>
                              </span><input type="text" name="note_starttime" class="form-control" id="reservation">
                        </div>
                	</div>
                	</div>
                	<div class="row" style="margin-top:15px">
                	<div class="col-lg-4 col-sm-4 col-xs-4">
                			<div class="form-group">
                              <span class="input-icon">
                                <input name="note_title_order" class="form-control" type="text">
                                   <i class="glyphicon glyphicon-search blue"></i>
                                     </span>
                             </div>
                	</div>
                	<div class="col-lg-5 col-sm-5 col-xs-5"></div>
                	<div class="col-lg-3 col-sm-3 col-xs-3" style="text-align: right">
	                	<div class="btn-group"  role="group" aria-label="Large button group">
						  <button type="button" disabled="disabled" class="btn btn-default"><i class="icon fa fa-edit"></i>Edit</button>
						  <button id="del_note_btn" disabled="disabled" type="button" class="btn btn-default"><i class="icon fa fa-trash-o"></i>Delete</button>
						  <button type="button" data-toggle="maximize" class="btn btn-default"><i class="icon fa fa-arrows-alt"></i>Full</button>
						</div>
                	</div>
                	</div>
					<div class="row">
                		<table id="note_list" class="table">
		          	    <thead class="flip-content bordered-palegreen"><tr>
		          	    <th class="header">标题</th>
		          	    <th class="header">类型</th>
		          	    <th class="header">时间</th>
		          	    <th class="header">Tool</th>
		          	    </tr></thead>
		      		    <tbody></tbody>
		                </table>
              			 <div id="page_div" style="width:100%;text-align: center;"></div>	
           			</div>
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
     <script type="text/javascript" src="../../js/cdp/way/note_list.js"></script>
  </body>
  
</html>