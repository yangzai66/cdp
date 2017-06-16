<%@ page language="java" contentType="text/html; UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>首页</title>
     <jsp:include page="../comm/css.jsp"></jsp:include>
    <style>
    button .note-btn{
    	padding:0px;
    }
    </style>
  </head>
  <body>
  <nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">CDP</a>
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
<div class="container" style="width:100%">
	<div class="row">
	<div class="col-sm-6 col-md-3">
         <nav class="aot">
          <div class="collapse and" id="nav-toggleable-sm">
            <ul class="nav of nav-stacked">
              <li class="tq">Dashboards</li>
              <li >
                <a href="#" onclick="control_display(1)">记单词</a>
              </li>
              <li>
                <a href="/cdp/views/way/note.jsp">知识现场</a>
              </li>
              <li>
                <a href="#" onclick="control_display(3)">画龙点睛</a>
              </li>
              <li class="active">
                <a href="/cdp/views/way/plan.jsp" "><span class="glyphicon glyphicon-flag"></span> 知行合一</a>
              </li>
            </ul>
            <hr class="rw aky">
          </div>
        </nav>
        </div>
        <div class="col-md-9" id="display">
        <div id="word_div" style="display: none;">
          <h4>Word</h4>
          <form class="form" action="#">
            <div class="form-group">
              <input name="word_name" class="form-control" type="text" placeholder="Text input">
            </div>
            <div class="form-group">
             <div id="word_meaning"  class="summernote"></div>
            </div>
            <span id="word_num" class="btn btn-link">1/10</span> <button id="word_next" class="btn btn-link" type="button">Next</button>       
          </form>
          </div>
          <div id="knowledge_div" style="display: none;">
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
          <div id="plan_div">
          <div class="apa">
  <div class="apb">
    <h6 class="apd">Plan</h6>
    <h2 class="apc">知行合一</h2>
  </div>

  <div class="ob ape">
    <div class="tn aol" style="width:100%">
      <input type="text" name="plan_starttime" onchange="load_plan_data()" value="01/01/15 - 01/08/15" class="form-control" data-provide="datepicker">
      <span style="position: absolute; top: 11px; left: 10px;color: #ccc;" class="glyphicon glyphicon-calendar"></span>
    </div>
  </div>
</div>

<div class="akg ue">
  <div class="akh aki">
    <div class="tn aol">
      <input type="text" class="form-control aqr" placeholder="Search orders">
      <span style="position: absolute; top: 11px;left: 10px;color: #ccc;" class="glyphicon glyphicon-search"></span>
    </div>
  </div>
  <div class="akh">
    <div class="nz">
       <button type="button" class="ce apn" data-toggle="modal" data-target="#new_plan">
        <span class="glyphicon glyphicon-plus"></span>
      </button>
      <button type="button" class="ce apn">
        <span class="glyphicon glyphicon-edit"></span>
      </button>
       <button onclick="dd()" type="button" class="ce apn" >
        <span class="glyphicon glyphicon-share"></span>
      </button>
      <button id="del_plan_btn" type="button" class="ce apn">
        <span class="glyphicon glyphicon-remove"></span>
      </button>
    </div>
  </div>
</div>
          <form class="form" action="#">
            <div class="form-group">
           	  	<table id="plan_list" class="cl">
          	    <thead><tr>
          	    <th style="width:40px" class="header"><div class="en aob aof" style="margin:0px"><label style="min-height:0px; padding:0px;"><input onclick="check_plan_all(this)" value="-1" type="checkbox"><span class="aoc"></span></label></div></th>
          	    <th class="header">时间</th>
          	    <th class="header">计划</th>
          	    <th class="header">状态</th>
          	    <th class="header">Tool</th>
          	    </tr></thead>
      		    <tbody></tbody>
                </table>
            </div>
          </form>
          </div>
        </div>
      </div>
</div>
<div id="new_plan" class="modal fade bs-example-modal-lg">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">new plan</h4>
      </div>
      <div class="modal-body">
         <form class="form" action="#"> 
         <div class="form-group">
         	<label style="font-weight:normal;font-size: 15px;line-height:2.3">日期</label>
           <input name="plan_date" style="width:180px" class="form-control" type="text" data-provide="datepicker">
            </div>
            <div class="form-group">
            <label style="font-weight:normal;font-size: 15px;line-height:2.3">计划</label>
           <input name="plan_title" class="form-control" type="text" placeholder="Text input">
            </div>
            <div class="form-group">
             <label style="font-weight:normal;font-size: 15px;line-height:2.3">详细</label>
           	  <div id="plan_content" style="height:150px" class="summernote"></div>
            </div>
          </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button id="add_plan_button" type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>
<div id="share_plan" class="modal fade bs-example-modal-lg">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">share plan</h4>
      </div>
      <div class="modal-body">
         <form class="form" action="#"> 
         <div class="form-group">
         	<label style="font-weight:normal;font-size: 15px;line-height:2.3">计划</label>
           	 <input name="share_plan_title" readonly="readonly" class="form-control" type="text" placeholder="Text input">	
            </div>
            <div class="form-group">
            <label style="font-weight:normal;font-size: 15px;line-height:2.3">结果</label>
           <select name="share_plan_status" class="anz aoa"> <option value="0">未开始</option><option value="1">进行中</option><option value="2">已完成</option><option value="3">挂起</option></select>
            </div>
            <div class="form-group">
             <label style="font-weight:normal;font-size: 15px;line-height:2.3">备注</label>
           	  <div id="share_plan_remarks" style="height:150px" class="summernote"></div>
            </div>
            <input type="hidden" name="share_plan_id" />
          </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button id="share_plan_btn" type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>
	
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="../../js/jquery/1.11.3/jquery.min.js"></script>
   <!-- <script src="../../js/bootstrap/bootstrap.min.js"></script> --> 
   <script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>  
   <script src="../../js/bootstrap/bootstrap-dialog.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="../../js/common.js"></script>
    <script src="../../js/map.js"></script>
    <script src="../../js/summernote/summernote.min.js"></script>
    <script src="../../js/messenger/messenger.min.js"></script>
    <script src="../../js/bootstrap-datetimepicker/bootstrap-datetimepicker.min.js"></script>
    <script  type="text/javascript" src="../../js/bootstrap-datetimepicker/locales/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
    
    <script type="text/javascript" src="../../js/cdp/way/way.js"></script>
  </body>
</html>