<%@ page language="java" contentType="text/html; UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>首页</title>
    
   
  	<link href="../css/messenger/messenger.css" rel="stylesheet">
  	<link href="../css/messenger/messenger-theme-future.css" rel="stylesheet">
  	 <link href="../css/bootstrap/bootstrap.min.css" rel="stylesheet">
    <link href="../js/summernote/summernote.css" rel="stylesheet">
    <link href="../js/summernote/font-awesome.min.css" rel="stylesheet">
      <link href="../css/toolkit-inverse/toolkit-inverse.css" rel="stylesheet">
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
              <li class="active">
                <a href="#" onclick="control_display(1)">记单词</a>
              </li>
              <li>
                <a href="#" onclick="control_display(2)">知识现场</a>
              </li>
              <li>
                <a href="#" onclick="control_display(3)">画龙点睛</a>
              </li>
              <li>
                <a href="#" onclick="control_display(4)">知行合一</a>
              </li>
            </ul>
            <hr class="rw aky">
          </div>
        </nav>
        </div>
        <div class="col-md-9" id="display">
        <div id="word_div">
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
          <div id="plan_div">
          <h4>Plan</h4>
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
    <script src="../js/jquery/1.11.3/jquery.min.js"></script>
    <script src="../js/bootstrap/bootstrap.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="../js/common.js"></script>
    <script src="../js/map.js"></script>
    <script src="../js/summernote/summernote.min.js"></script>
    <script src="../js/messenger/messenger.min.js"></script>
    <script type="text/javascript" src="../js/cdp/way/way.js"></script>
  </body>
</html>