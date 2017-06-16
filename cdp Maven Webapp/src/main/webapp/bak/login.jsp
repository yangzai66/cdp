<%@ page language="java" contentType="text/html; UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>登录</title>
    <link href="css/bootstrap/bootstrap.min.css" rel="stylesheet">
     <link href="css/flat-ui/flat-ui.min.css" rel="stylesheet">
  </head>
  <body>
  <div class="container" style="min-width:1366px;background-image: url(images/912147.jpg);margin:0px;">
    <div class="login" style="background-image: none;padding:8px 400px 186px;margin-bottom: 0px;">
        <div class="login-screen" style="background-color:transparent;width:940px">
          <div class="login-form" style="background:#edeff1; filter: alpha(opacity=80); opacity: 2;">
            <div class="form-group">
              <input type="text" class="form-control login-field" value="" placeholder="Enter your name" id="login-name" data-form-un="1458317260801.11">
              <label class="login-field-icon fui-user" for="login-name"></label>
            </div>

            <div class="form-group">
              <input type="password" class="form-control login-field" value="" placeholder="Password" id="login-pass" data-form-pw="1458317260801.11">
              <label class="login-field-icon fui-lock" for="login-pass"></label>
            </div>

            <a class="btn btn-primary btn-lg btn-block" href="javascript:login()">Log in</a>
            <a class="login-link" href="#">Lost your password?</a>
          </div>
        </div>
      </div>
</div>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/flat-ui/flat-ui.min.js"></script>
    <script type="text/javascript">
    	function login(){
    		$.ajax({
    			type:"post",
    			url:"/cdp/user/login",
    			data:"data={\"username\":\""+$("#login-name").val()+"\",\"password\":\""+$("#login-pass").val()+"\"}",
    			success:function(msg){
    				if(msg.result){
    					window.location.href="/cdp/views/index.jsp"
    				}else{
    				   alert(msg.result);
    				}
    			}
    		
    		});
    	
    	}
    </script>
  </body>
</html>