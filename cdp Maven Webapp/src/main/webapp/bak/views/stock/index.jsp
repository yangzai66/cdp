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
    <style>
    button .note-btn{
    	padding:0px;
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
<div class="container" style="width:100%;margin-top:80px;">
	<div class="row">
	<div class="col-sm-6 col-md-3">
         <nav class="aot">
          <div class="collapse and" id="nav-toggleable-sm">
            <ul class="nav of nav-stacked">
              <li class="tq">Dashboards</li>
              <li class="active">
                <a href="#" onclick="control_display(1)">行业板块</a>
              </li>
              <li>
                <a href="#" onclick="control_display(2)">概念板块</a>
              </li>
              <li>
                <a href="#" onclick="control_display(3)">画龙点睛</a>
              </li>
              <li>
                <a href="#" onclick="control_display(4)">More</a>
              </li>
            </ul>
            <hr class="rw aky">
          </div>
        </nav>
        </div>
        <div class="col-md-9" id="display">
        <div id="market_div" class="fu apt" >
		</div>
        <div id="word_div">
          <table class="cl">
          	 <thead>
        <tr>
         <th class="header" data-sort="PLATE_NO">代码</th>
         <th class="header" data-sort="PLATE_NAME">名字</th>
         <th class="header headerSortUp" data-sort="UPS_DOWNS_RATE">涨跌幅</th>
         <th class="header" data-sort="UPS_DOWNS_PRICE">涨跌价格</th>
         <th class="header" data-sort="AVG_PRICE">平均价格</th>
         <th class="header" data-sort="TRADE_NUM">成交量</th>
         <th class="header" data-sort="TRADE_MONEY">成交金额</th>
        </tr>
      </thead>
      <tbody>
      
      </tbody>
          </table>
          </div>
          <div id="knowledge_div">
          <h4>Knowledge</h4>
          <form class="form" action="#">
            <div class="form-group">
              <input name="note_title" class="form-control" type="text" placeholder="Text input">
            </div>
            <div class="form-group">
           	  <div id="note_content"  class="summernote"></div>
            </div>
            <button id="knowledge_save" class="btn btn-success" type="button">Save</button>       
          </form>
          </div>
        </div>
      </div>
</div>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="../../js/jquery/1.11.3/jquery.min.js"></script>
    <script src="../../js/bootstrap/bootstrap.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="../../js/common.js"></script>
    <script src="../../js/map.js"></script>
    <script src="../../js/summernote/summernote.min.js"></script>
    <script src="../../js/messenger/messenger.min.js"></script>
    <script type="text/javascript">
    	$(document).ready(function(){
    	control_display(1);
    		load_market();
    		load_industry_plate();
    	});
    	var load_market = function(){
    		Public.ajaxPost("/market/list", {}, function(msg) {
    		$.each(msg, function(i,model){
    			var rate_css = "bz pd";
    			if(model.UPS_DOWNS_RATE>0){
    				rate_css = "bz pg";
    			}
    			$("#market_div").append('<div class="gq gf ala" ><div class="apu"><div class="alz" style="padding:0px !important;"><span class="anj">'+model.STOCK_NAME+'</span><h2 class="ani">'+model.CUR_PRICE+'<small class="'+rate_css+'" style="margin-left:8px">'+model.UPS_DOWNS_RATE+'%</small></h2></div></div></div>');
    		});
    		});
    	}
    	var load_industry_plate = function(){
    	var params = new Map();
    	params.put("order", order());
    		Public.ajaxPost("/plate/list", params.toParamsJSON(), function(msg) {
    			var content = "";
		  		$.each(msg.data,function(i,stock){
					if(stock.UPS_DOWNS_RATE<0){
  			content+="<tr class='stock_down_rate'>";
  		}else{
  			content+="<tr class='stock_up_rate'>";
  		}
  		content+="<td><a href='/st/view/plate/stocklist.jsp?plate_no="+stock.PLATE_NO+"'>"+stock.PLATE_NO+"</a></td><td>"+stock.PLATE_NAME+"</td><td>"+stock.UPS_DOWNS_RATE+"</td><td>"+stock.UPS_DOWNS_PRICE+"</td><td>"+stock.AVG_PRICE+"</td><td>"+stock.TRADE_NUM+"</td><td>"+stock.TRADE_MONEY+"</td></tr>";
  		
		  		});
		  		$(".cl tbody").html(content);
    		});
    	}
    	function order(){
		  	var query_order="order by ";
		  	var headers=$("th[class*=header]");
			 for(var i=0;i<headers.length;i++){
			 var bb= headers.get(i);
				if(headers.get(i).className.indexOf('headerSortDown')>0){
				query_order+=headers.get(i).dataset.sort+" asc";
					 break;
				}
				if(headers.get(i).className.indexOf('headerSortUp')>0){
				query_order+=headers.get(i).dataset.sort+" desc";
					 break;
				}
			 }
			 return query_order;
  	}
    	var control_display = function(v){
    		$("div#display > div").hide();
    		$("#market_div").show();
    		switch(v){
    			case 1:
    			$("#word_div").show()
    			break;
    			case 2:
    			$("#knowledge_div").show()
    			break;
    			}
    	}
    </script>
  </body>
</html>