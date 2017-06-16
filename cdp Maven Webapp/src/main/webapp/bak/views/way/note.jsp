<%@ page language="java" contentType="text/html; UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>日志记录</title>
 <jsp:include page="../comm/css.jsp"></jsp:include> 
 </head>
  <body>
   <jsp:include page="../comm/top.jsp"></jsp:include>
<div class="container" style="width:100%">
	<div class="row">
	<div class="col-sm-6 col-md-3">
      <jsp:include page="../comm/left.jsp"></jsp:include>  
	</div>
        <div class="col-md-9" id="display">
          <div id="add_note_div" style="display: none;">
          <h4>新增记录</h4>
          <form class="form" action="#">
            <div class="form-group">
              <input name="note_title" class="form-control" type="text" placeholder="Text input">
            </div>
            <div class="form-group">
           	  <div id="note_content"  class="summernote"></div>
            </div>
            <div class="form-group">
            <label style="font-weight:normal;font-size: 15px;line-height:2.3">类型</label>
           	<select name="add_note_type" class="anz aoa"></select>
            </div>
            <button id="knowledge_save" class="btn btn-default" type="button">保存</button>
            <button onclick="control_display(2)" class="btn btn-default" type="button">返回列表</button>       
          </form>
          </div>
          <div id="note_edit_div" style="display: none;">
          <h4>修改记录</h4>
          <form class="form" action="#">
            <div class="form-group">
              <input id="note_edit_title" class="form-control" type="text" placeholder="Text input">
            </div>
            
            <div class="form-group">
           	  <div id="note_edit_content"  class="summernote"></div>
            </div>
            <div class="form-group">
            <label style="font-weight:normal;font-size: 15px;line-height:2.3">类型</label>
           	<select name="note_edit_type" class="anz aoa"></select>
            </div>
            <input id="note_edit_id" type="hidden">
            <button id="note_edit_btn" class="btn btn-default" type="button">保 存</button>
            <button onclick="control_display(2)" class="btn btn-default" type="button">返回列表</button>       
          </form>
          </div>
          <div id="note_view_div" style="display: none;">
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
          <div id="note_list_div">
          <div class="apa">
  <div class="apb">
    <h6 class="apd">Know Note</h6>
    <h2 class="apc">日志记录</h2>
  </div>

  <div class="ob ape">
    <div class="tn aol" style="width:100%">
      <input type="text" name="note_starttime" onchange="load_plan_data()" value="01/01/15 - 01/08/15" class="form-control" data-provide="datepicker">
      <span style="position: absolute; top: 11px; left: 10px;color: #ccc;" class="glyphicon glyphicon-calendar"></span>
    </div>
  </div>
</div>

<div class="akg ue">
  <div class="akh aki">
    <div class="tn aol">
      <input name="note_title_order" type="text" class="form-control aqr" placeholder="Search orders">
      <span style="position: absolute; top: 11px;left: 10px;color: #ccc;" class="glyphicon glyphicon-search"></span>
    </div>
  </div>
  <div class="akh">
    <div class="nz">
       <button id="new_note" type="button" class="ce apn">
        <span class="glyphicon glyphicon-plus"></span>
      </button>
      <!-- 
      <button id="edit_note" type="button" class="ce apn">
        <span class="glyphicon glyphicon-edit"></span>
      </button>
       <button onclick="dd()" type="button" class="ce apn" >
        <span class="glyphicon glyphicon-share"></span>
      </button> -->
      <button id="del_note_btn" type="button" class="ce apn">
        <span class="glyphicon glyphicon-remove"></span>
      </button>
    </div>
  </div>
</div>
          <form class="form" action="#">
            <div class="form-group">
           	  	<table id="note_list" class="cl">
          	    <thead><tr>
          	    <th style="width:40px" class="header"><div class="en aob aof" style="margin:0px"><label style="min-height:0px; padding:0px;"><input onclick="check_all(this)" value="-1" type="checkbox"><span class="aoc"></span></label></div></th>
          	    <th class="header">标题</th>
          	    <th class="header">类型</th>
          	    <th class="header">时间</th>
          	    <th class="header">Tool</th>
          	    </tr></thead>
      		    <tbody></tbody>
                </table>
               <div id="page_div" style="width:100%;text-align: center;"></div>
            </div>
          </form>
          </div>
        </div>
      </div>
</div>
    
  </body>
     <jsp:include page="../comm/js.jsp"></jsp:include>
     <script type="text/javascript" src="../../js/cdp/way/note.js"></script>
</html>