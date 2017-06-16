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
     <link href="../../css/toolkit-inverse/toolkit-light.css" rel="stylesheet">
     
     <style type="text/css">
     	.stock-info {
    font-family: DIN,"Microsoft YaHei",Arial,sans-serif;
    position: relative;
    padding: 10px 20px;
    font-size:12px;
        background-color: #f7faff;
}
.stock-info .bets-content dd {
    font-size: 14px;
    font-weight: 700;
}
.stock-info .stock-bets h1 a {
    margin-right: 15px;
    font-size: 18px;
}
.stock-info .stock-bets .state {
    color: #92a0ac;
    font-size: 12px;
    font-weight: 400;
}
.s-down {
    color: #1dbf60;
}
.s-up {
    color: #f24957;
}
.stock-info .bets-content {
    margin-top: 7px;
    border-top: #e9edf0 solid 1px;
    padding: 14px 0;
}
.stock-info .bets-content .line2 {
    margin-top: 10px;
    clear: left;
}
.clear {
    clear: both;
}
.stock-info .bets-content dl {
    float: left;
    width: 9.09%;
    line-height: 18px;
    margin-bottom:0px;
}
.stock-info .stock-bets .price strong {
    font-size: 54px;
    line-height: 56px;
    margin-right: 20px;
}
.stock-info .stock-bets .price span {
    font-size: 18px;
    margin-right: 10px;
    font-weight: 700;
}
.stock-info .bets-content dt {
    color: #92a0ac;
}

.stock-info .stock-add {
    position: absolute;
    top: 70px;
    right: 20px;
    width: 150px;
    text-align: center;
    width: 142px;
}
.stock-info .stock-add button {
    width: 100%;
    height: 40px;
    line-height: 40px;
    background-color: #2e85ff;
    border: 0;
    padding: 0;
    -webkit-border-radius: 4px;
    border-radius: 4px;
    font-size: 16px;
    color: #FFF;
    cursor: pointer;
}
.stock-info .stock-add .hint {
    margin-top: 3px;
    color: #707f8b;
}
ul, li {
    list-style: none;
    padding: 0;
    margin: 0;
}
.f10-menu {
    background-position: 0px 5px;
    height: 34px;
    line-height: 34px;
    text-align: center;
    padding-left: 60px;
    margin-top: 24px;
    margin-bottom: 5px;
    background-repeat: no-repeat;
}
.f10-menu a {
    margin: 0 9px;
    font-size: 14px;
    color: #478acc;
}
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
<div class="container" style="width:100%;margin-top:30px;">
	<div class="row">
        	<div class="stock-info" data-spm="2">
    <div class="stock-bets">
        <h1>
            <a class="bets-name" href="/stock/sh600895.html">
            张江高科 (<span>600895</span>)
            </a>
            <span class="state f-up">已收盘 2016-04-20 &nbsp;15:01:27
            </span>
        </h1>
        <div class="price s-down ">
                        <strong class="_close">22.60</strong>
            <span>-0.01</span>
            <span>-0.04%</span>
                    </div>
        <div class="bets-content">
            
                                            <div class="line1">
                    <dl><dt>今开</dt><dd class="s-down">22.42</dd></dl>
                    <dl><dt>成交量</dt><dd>98.20万手</dd></dl>
                    <dl><dt>最高</dt><dd class="s-up">23.17</dd></dl>
                    <dl><dt>涨停</dt><dd class="s-up">24.87</dd></dl>
                    <dl><dt>内盘</dt><dd>47.57万手</dd></dl>
                    <dl><dt>成交额</dt><dd>21.99亿</dd></dl>
                    <dl><dt>委比</dt><dd>-43.53%</dd></dl>
                    <dl><dt>流通市值</dt><dd>350.00亿</dd></dl>
                    <dl><dt class="mt-1">市盈率<sup>MRQ</sup></dt><dd>72.67</dd></dl>
                    <dl><dt>每股收益</dt><dd>0.31</dd></dl>
                    <dl><dt>总股本</dt><dd>15.49亿</dd></dl>
                    <div class="clear"></div>
                </div>
                <div class="line2">
                    <dl><dt>昨收</dt><dd>22.61</dd></dl>
                    <dl><dt>换手率</dt><dd>6.34%</dd></dl>
                    <dl><dt>最低</dt><dd class="s-down">21.20</dd>
                    </dl>
                    <dl><dt>跌停</dt><dd class="s-down">
                        20.35</dd></dl>
                    <dl><dt>外盘</dt><dd>50.63万手</dd></dl>
                    <dl><dt>振幅</dt><dd>8.71%</dd></dl>
                    <dl><dt>量比</dt><dd>2.75</dd></dl>
                    <dl><dt>总市值</dt><dd>350.00亿</dd></dl>
                    <dl><dt>市净率</dt><dd>4.63</dd></dl>
                    <dl><dt>每股净资产</dt><dd>4.88</dd></dl>
                    <dl><dt>流通股本</dt><dd>15.49亿</dd></dl>
                </div>
                                        <div class="clear"></div>
        </div>
    </div>
    <ul class="stock-add">
        <li><button class="">+ 加自选</button></li>
    </ul>
    </div>
      </div>
     
      <div class="row" style="overflow:hidden;border:0px;">
      	<div class="col-sm-6 col-md-7" style="margin-top:-370px;width:742px;">
      	<iFrame src="http://gupiao.baidu.com/stock/sh600000.html" width="742px" height="780px" scrolling="no" style="border:none;">
             </iFrame>
      	</div>
      	<div class="col-sm-6 col-md-5">
      	<canvas id="canvas"></canvas>
      	
      	</div>
      </div>
      
       <div class="row">
      <div class="col-sm-6 col-md-1" style="height:34px;font-weight: 700;font-size:14px;color:#000">
      	SPI指标:
      </div>
      <div class="col-sm-6 col-md-11">
      	<small class="bz pg" style="margin-left:8px">LXFL_3</small><small class="bz pg" style="margin-left:8px">LXSZ_4</small><small class="bz pg" style="margin-left:8px">SPI_LXJLR_3</small><small class="bz pg" style="margin-left:8px">SPI_LXJLC_2</small>
      </div>
      </div>
      
</div>
    <script src="../../js/jquery/1.11.3/jquery.min.js"></script>
    <script src="../../js/bootstrap/bootstrap.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="../../js/common.js"></script>
    <script src="../../js/map.js"></script>
    <script src="../../js/tablesorter.min.js"></script>
    <script src="../../js/summernote/summernote.min.js"></script>
    <script src="../../js/messenger/messenger.min.js"></script>
    <script src="../../js/chart/Chart.bundle.min.js"></script>
     <script src="../../js/cdp/stock/details.js"></script>
  </body>
</html>