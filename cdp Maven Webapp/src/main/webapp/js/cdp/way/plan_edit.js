$(document).ready(function(){
	$(".summernote").summernote({
  		 height: 300
	});
	 $('#start_time').datepicker();
     $('#end_time').datepicker();
	Public.ajaxGet("/plan/view/"+$.getUrlParam("id"), {}, function(msg) {
		if(msg.result){
			$("input[name='plan_title']").val(msg.data.PLAN_TITLE);
			$("input[name='start_time']").val($.getDateUtil(msg.data.STARTTIME,"yyyy-mm-dd"));
			$("input[name='end_time']").val($.getDateUtil(msg.data.ENDTIME,"yyyy-mm-dd"));
			$("#plan_content").code(msg.data.PLAN_CONTENT);
			$("input[name='plan_id']").val(msg.data.PLAN_ID);
		}else{
			
		}
	});
	$("#save_plan").click(function(){
		var params = new Map();
		params.put("STARTTIME", $("input[name='start_time']").val());
		params.put("ENDTIME", $("input[name='end_time']").val());
		params.put("PLAN_TITLE", $("input[name='plan_title']").val());
		params.put("PLAN_CONTENT", $("#plan_content").code());
		params.put("PLAN_ID", $("input[name='plan_id']").val());
		Public.ajaxPost("/plan/update", params.toParamsJSON(), function(msg) {
			if(msg.result){
				$.messenger("Edit Plan Is Successfully!", 0);
			}
		});
	});
});