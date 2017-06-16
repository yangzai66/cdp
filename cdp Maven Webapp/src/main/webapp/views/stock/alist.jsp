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
   <link href="../../assets/css/dataTables.bootstrap.css" rel="stylesheet">
    <style type="text/css">
     .stock_down_rate td{color: #1dbf60;}
.stock_up_rate td{ color: #f24957;}
     </style>
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
                	<div class="row">
                		<table id="stock_list" class="table">
		          	    <thead class="flip-content bordered-palegreen"><tr>
		          	     <th class="sorting" data-sort="STOCK_NO">代码</th>
				         <th class="sorting" data-sort="STOCK_NAME">名字</th>
				         <th class="sorting_desc" data-sort="UPS_DOWNS_RATE">涨幅</th>
				         <th class="sorting" data-sort="UPS_DOWNS_PRICE">涨幅价</th>
				         <th class="sorting" data-sort="CUR_PRICE">价格</th>
				         <th class="sorting" data-sort="HIGH_PRICE">最高</th>
				         <th class="sorting" data-sort="LOW_PRICE">最低</th>
				         <th class="sorting" data-sort="FUND_MAIN_PURE">净流入</th>
		          	    </tr></thead>
		      		    <tbody></tbody>
		                </table>
              			 <div id="page_div" style="width:100%;text-align: center;"></div>	
                	</div>
                </div>
            </div>
            
        </div>
    </div>
    <jsp:include page="../public/commjs.jsp"></jsp:include>
  </body>
      <script src="../../assets/js/datatable/jquery.dataTables.min.js"></script>
    <script src="../../assets/js/datatable/ZeroClipboard.js"></script>
    <script src="../../assets/js/datatable/dataTables.tableTools.min.js"></script>
    <script src="../../assets/js/datatable/dataTables.bootstrap.min.js"></script>
  <script type="text/javascript" src="../../js/cdp/stock/alist.js"></script>
</html>