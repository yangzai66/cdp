<%@ page language="java" contentType="text/html; UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>首页</title>
  	 <link href="../../css/messenger/messenger.css" rel="stylesheet">
  	 <link href="../../css/messenger/messenger-theme-future.css" rel="stylesheet">
  	 <link href="../../css/bootstrap/bootstrap.min.css" rel="stylesheet">
     <link href="../../js/summernote/summernote.css" rel="stylesheet">
     <link href="../../js/summernote/font-awesome.min.css" rel="stylesheet">
     <link href="../../css/toolkit-inverse/toolkit-inverse.css" rel="stylesheet">
     <style type="text/css">
     .stock_down_rate td{color:green;}
.stock_up_rate td{color:red;}
     </style>
   </head>
  <body>
  <nav class="ci ou g">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#"><span class="glyphicon glyphicon-leaf"></span></a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">主页</a></li>
        <li><a href="#">股票</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">问道 <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">每日功课</a></li>
            <li><a href="#">Another action</a></li>
            <li><a href="#">Something else here</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">Separated link</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">One more separated link</a></li>
          </ul>
        </li>
      </ul>
      <form class="navbar-form navbar-left" role="search">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
      </form>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#">Main</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Action</a></li>
            <li><a href="#">Another action</a></li>
            <li><a href="#">Something else here</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">Separated link</a></li>
          </ul>
        </li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
<div class="container" style="width:100%;margin-top:80px;">
	<div class="row">
	<div class="col-sm-6 col-md-2">
         <nav class="aot">
          <div class="collapse and" id="nav-toggleable-sm">
            <ul class="nav of nav-stacked">
              <li class="tq">Dashboards</li>
              <li class="active">
                <a href="#" onclick="spi_where('SPI_LXFL_3')">连续放量</a>
              </li>
              <li>
                <a href="#" onclick="spi_where('SPI_LXJLR_2')">净流入</a>
              </li>
              <li>
                <a href="#" onclick="spi_where('SPI_LXJLC_2')">净流出</a>
              </li>
              <li>
                <a href="#" onclick="spi_where('SPI_LXDD_2')">大单频现</a>
              </li>
              <li>
                <a href="#" onclick="spi_where('SPI_LXSZ_2')">连续上涨</a>
              </li>
              <li>
                <a href="#" onclick="spi_where('SPI_LXXD_2')">连续下跌</a>
              </li>
            </ul>
            <hr class="rw aky">
          </div>
        </nav>
        </div>
        <div class="col-md-10" id="display">
        <div id="market_div" class="fu apt" >
		</div>
          <table class="cl">
          	 <thead>
        <tr>
         <th class="header" data-sort="STOCK_NO">代码</th>
         <th class="header" data-sort="STOCK_NAME">名字</th>
         <th class="header" data-sort="SPI_RATE_3">累计涨幅</th>
         <th class="header" data-sort="SPI_AVG_AMPLITUDE_3">平均振幅</th>
         <th class="header" data-sort="SPI_AVG_TURNOVER_3">平均换手</th>
         <th class="header" data-sort="SPI_HIGH_PRICE_3">最高价</th>
         <th class="header" data-sort="SPI_LOW_PRICE_3">最低价</th>
         <th class="header headerSortUp" data-sort="UPS_DOWNS_RATE">new</th>
          <th class="header" data-sort="CUR_PRICE">tags</th>
        </tr>
      </thead>
      <tbody>
      </tbody>
          </table>
          </div>
      </div>
</div>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="../../js/jquery/1.11.3/jquery.min.js"></script>
    <script src="../../js/bootstrap/bootstrap.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="../../js/common.js"></script>
    <script src="../../js/map.js"></script>
    <script src="../../js/tablesorter.min.js"></script>
    <script src="../../js/summernote/summernote.min.js"></script>
    <script src="../../js/messenger/messenger.min.js"></script>
     <script src="../../js/cdp/stock/spi.js"></script>
  </body>
</html>