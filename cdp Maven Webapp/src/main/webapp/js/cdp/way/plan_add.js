
$(document).ready(function(){
     $(".summernote").summernote({
       		 height: 300
     });
     $('#start_time').datepicker();
     $('#end_time').datepicker();
     $("#add_plan_button").click(function(){
			var params = new Map();
			//params.put("PLAN_DATE", $("input[name='plan_date']").val());
			params.put("STARTTIME", $("input[name='start_time']").val());
			params.put("ENDTIME", $("input[name='end_time']").val());
			params.put("PLAN_TITLE", $("input[name='plan_title']").val());
			params.put("PLAN_CONTENT", $("#plan_content").code());
			Public.ajaxPost("/plan/add", params.toParamsJSON(), function(msg) {
				if(msg.result){
					$("input[name='plan_title']").val("");
					$("#plan_content").code('');
//				load_plan_data();
				$.messenger("add plan is successfully!",0);
				}else{
					$.messenger("exception:"+msg.msg);
				}
			})
		});   	
}); 
 
