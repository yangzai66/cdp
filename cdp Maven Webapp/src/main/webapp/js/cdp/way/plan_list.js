$(document).ready(function(){
	 $('#reservation').daterangepicker({startDate:"2013-08-01",endDate:"2013-08-01"},function(start, end){
         $('#reservation input').val(start.toString('yyyy-MM-dd') + '~' + end.toString('yyyy-MM-dd'));
	 });
//	 $('#reservation').val($.getCurrentDate()+" - "+$.getDateUtil(new Date(), "yyyy-mm-dd"));
	$(".summernote").summernote({
  		 height: 200
});
	load_plan_data();
});
function share_plan(id){
	Public.ajaxGet("/plan/view/"+id, {
	}, function(msg) {
		$("#share_plan_id").val(msg.data.PLAN_ID);
		if(msg.result){
			bootbox.dialog({
		        message: "	 <div id=\"share_plan_div\">" +
		        "    	<form class=\"form\" action=\"#\"> " +
		        "         <div class=\"form-group\">" +
		        "         	<label style=\"font-weight:normal;font-size: 15px;line-height:2.3\">计划</label>" +
		        "           	 <input name=\"share_plan_title\" readonly=\"readonly\" class=\"form-control\" type=\"text\" value=\""+msg.data.PLAN_TITLE+"\" placeholder=\"Text input\">	" +
		        "            </div>" +
		        "            <div class=\"form-group\">" +
		        "            <label style=\"font-weight:normal;font-size: 15px;line-height:2.3\">结果</label>" +
		        "           <select name=\"share_plan_status\" class=\"anz aoa\"> <option value=\"0\">未开始</option><option value=\"1\">进行中</option><option value=\"2\">已完成</option><option value=\"3\">挂起</option></select>" +
		        "            </div>" +
		        "            <div class=\"form-group\">" +
		        "             <label style=\"font-weight:normal;font-size: 15px;line-height:2.3\">备注</label>" +
		        "			<textarea id=\"share_plan_remarks\" value=\""+msg.data.PLAN_REMARKS+"\" rows=\"10\" cols=\"75\"></textarea>" +				
		        "            </div>" +
		        "            <input type=\"hidden\" name=\"share_plan_id\" />" +
		        "          </form>" +
		        "    </div>",
		        title: "Share Plan",
		        className: "modal-darkorange",
		        buttons: {
		            success: {
		                label: "Save",
		                className: "btn-blue",
		                callback: function () { 
//		                	alert($("input[name='share_plan_id']").val());
//		                	alert($("#share_plan_remarks").val());
		                	var params = new Map();
		        			params.put("PLAN_ID", $("input[name='share_plan_id']").val());
		        			params.put("PLAN_STATUS", $("select[name='share_plan_status']").val());
		        			params.put("PLAN_REMARKS", $("#share_plan_remarks").summernote());
		        			Public.ajaxPost("/plan/update", params.toParamsJSON(), function(msg) {
		        				if(msg.result){
		        					$.messenger('Share Successfully!',0);
		        					load_plan_data();
		        				}else{
		        					$.messenger(msg.msg,1);
		        				}
		        			})
		                }
		            },
		            "Cancel": {
		                className: "btn",
		                callback: function () { }
		            }
		        }
		    });
		}else{
			$.messenger(msg.msg, 1);
		}
	});
	
}
function plan_status(v){
       		switch(v){
       		case "0":
       			return "未开始";
       		case "1":
       			return "进行中";
       		case "2":
       			return "已完成";
       		case "3":
       			return "挂起";
       		default:
       			return "--";
       		}
}
function plan_status_tr(v){
	switch(v){
		case "0":
			return "active";
		case "1":
			return "info";
		case "2":
			return "success";
		case "3":
			return "warning";
		case "4":
			return "danger";
		default:
			return "--";
		}
}
var load_plan_data = function(){
	$("#plan_list tbody").html("");
	var params = new Map();
	params.put("starttime", $("input[name='plan_starttime']").val());
	Public.ajaxPost("/plan/list", params.toParamsJSON(), function(msg) {
		$.each(msg.data,function(i,model){
			var obj =model;
			$("#plan_list tbody").append("<tr class="+plan_status_tr(model.PLAN_STATUS)+"><td><span class=\"glyphicon glyphicon-flag\"></span>"+model.PLAN_TITLE+"</td><td>"+$.getDateUtil(model.PLAN_DATE,"yyyy-mm-dd")+"</td><td>"+$.getDateUtil(model.STARTTIME,"yyyy-mm-dd")+" --- "+$.getDateUtil(model.ENDTIME,"yyyy-mm-dd")+"</td>" +
					"<td>"+plan_status(model.PLAN_STATUS)+"</td><td><a href=\"#\" onclick=\"share_plan("+model.PLAN_ID+")\" class=\"btn btn-success btn-xs edit\"><i class=\"glyphicon glyphicon-share\"></i> Share</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href=\"plan_edit.jsp?m="+$.getUrlParam("m")+"&id="+model.PLAN_ID+"\" class=\"btn btn-info btn-xs edit\"><i class=\"fa fa-edit\"></i> Edit</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href=\"#\" onclick=\"delete_plan("+model.PLAN_ID+")\" class=\"btn btn-danger btn-xs delete\"><i class=\"fa fa-trash-o\"></i> Delete</a></td></tr>");
		});
	})
}
function delete_plan(id){
	bootbox.confirm("是否确认要删除该计划？",function(result){
		if(result){
			Public.ajaxGet("/plan/delete/"+id, {}, function(msg) {
				if(msg.result){
					$.messenger("Delete Plan is Successfully!", 0);
					load_plan_data();
				}
			})
		}
	});
}
