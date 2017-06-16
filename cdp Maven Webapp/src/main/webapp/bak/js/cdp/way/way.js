
    	var control_display = function(v){
    		$("div#display > div").hide();
    		switch(v){
    			case 1:
    			$("#word_div").show()
    			break;
    			case 2:
    			$("#knowledge_div").show()
    			break;
    			case 4:
        			$("#plan_div").show()
        			break;
    			}
    	}
    	var load_plan_data = function(){
    		$("#plan_list tbody").html("");
    		var params = new Map();
    		params.put("starttime", $("input[name='plan_starttime']").val());
    		Public.ajaxPost("/plan/list", params.toParamsJSON(), function(msg) {
    			$.each(msg.data,function(i,model){
    				var obj =model;
    				$("#plan_list tbody").append("<tr><td><div class=\"en aob aof\" style=\"margin:0px\"><label style=\"min-height:0px; padding:0px;\"><input type=\"checkbox\" value="+model.PLAN_ID+"><span class=\"aoc\"></span></label></div></td><td>"+$.getDateUtil(model.PLAN_DATE,"yyyy-mm-dd")+"</td><td><span class=\"glyphicon glyphicon-flag\"></span>"+model.PLAN_TITLE+"</td>" +
    						"<td>"+plan_status(model.PLAN_STATUS)+"</td><td><a href='#' onclick=\"share_plan("+model.PLAN_ID+",'"+model.PLAN_TITLE+"','"+model.PLAN_REMARKS+"')\"><span class=\"glyphicon glyphicon-share\"></span></a></td></tr>");
    			});
    		})
    	}
    	var delete_plan = function(){
    		
    		
    	}
    	function check_plan_all(obj){
    		 $("#plan_div input[type='checkbox']").prop('checked', $(obj).prop('checked'));
    	}
    	var plan_status_select = function(v){
    		var temp = "<select class=\"anz\"> <option>Default</option><option>First option</option></select>";
    	}
       	function share_plan(id,title,remarks){
//    		alert(remarks);
    		$("input[name='share_plan_title']").val(title);
    		$("input[name='share_plan_id']").val(id);
    		$("input[name='share_plan_remarks']").val(remarks);
//    		alert(JSON.stringify(p));
    		$("#share_plan").modal('show');
//    		alert(123);
//    		data-toggle="modal" data-target="#share_plan"
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
    	$(document).ready(function(){
        	control_display(4);
        	load_plan_data();
        	$("input[data-provide='datepicker']").val($.getCurrentDate("yyyy-mm-dd"));
        	$("input[data-provide='datepicker']").datetimepicker({
        	  format:'yyyy-mm-dd',
        	  minView: "month",
        	  autoclose:true
        	});
        	$(".summernote").summernote({
        		 height: 180
        	});
        		var word_index=1;
        		Public.ajaxGet("/word/find/today", {}, function(msg) {
        			if(msg.data.length>0){
        				word_index = msg.data.length;
        				$("#word_num").html(word_index+"/10");
        			}
        		});
        		$("#word_next").click(function(){
    	    		if(word_index==10){
    	    		$("#word_next").html("Done");
    	    			return;
    	    		}
    	    		var params = new Map();
    	    		params.put("WORD_NAME",$("input[name='word_name']").val());
    	    		params.put("WORD_MEANING",$("#word_meaning").summernote('code'));
    	    		var callback = function(msg){
    	    			if(msg.result){
    	    			$("input[name='word_name']").val("");
    	    			$("#word_meaning").summernote('code','')
    	    				word_index+=1;
    	    				$("#word_num").html(word_index+"/10");
    	    			}
    	    		}
    	    		Public.ajaxPost("/word/add", params.toParamsJSON(),callback);
        		});
        		
        		$("#knowledge_save").click(function(){
        			var params = new Map();
    	    		params.put("NOTE_TITLE",$("input[name='note_title']").val());
    	    		params.put("NOTE_CONTENT",$("#note_content").summernote('code'));
        			Public.ajaxPost("/note/add", params.toParamsJSON(), function(msg) {
        				if(msg.result)
        				$.messenger("保存成功");
        				else
        				$.messenger("操作失败了");
        			})
        		});
        		$("#add_plan_button").click(function(){
        			var params = new Map();
        			params.put("PLAN_DATE", $("input[name='plan_date']").val());
        			params.put("PLAN_TITLE", $("input[name='plan_title']").val());
        			params.put("PLAN_CONTENT", $("#plan_content").summernote('code'));
        			Public.ajaxPost("/plan/add", params.toParamsJSON(), function(msg) {
        				if(msg.result){
        					$("input[name='plan_title']").val("");
        					$("#plan_content").summernote("");
        				load_plan_data();
        				$.messenger("add plan is successfully!");
        				}else{
        					$.messenger("exception:"+msg.msg);
        				}
        			})
        		});
        		$("#del_plan_btn").click(function(){
        			var arr=$("#plan_div input[type='checkbox']:checked");
        			if(arr.length==0){$.messenger("请选择所需要删除的计划！"); return;}
        			var plan_id = "";
            		$(arr).each(function(){
            			if(this.value!=-1){
            				plan_id+=this.value+",";
            			}
            		});
            		if(confirm("确认知行删除计划操作？")){
            		var params = new Map();
            		params.put("plan_id", plan_id);
            		Public.ajaxPost("/plan/delete", params.toParamsJSON(), function(msg) {
            			load_plan_data();
            		})
            		}
        		});
        		$("#share_plan_btn").click(function(){
        			var params = new Map();
        			params.put("PLAN_ID", $("input[name='share_plan_id']").val());
        			params.put("PLAN_STATUS", $("select[name='share_plan_status']").val());
        			params.put("PLAN_REMARKS", $("#share_plan_remarks").summernote('code'));
        			Public.ajaxPost("/plan/update", params.toParamsJSON(), function(msg) {
        				if(msg.result){
        					$("#share_plan").modal('hide');
        					load_plan_data();
        				}else{
        					$.messager(msg.msg);
        				}
        			})
        		});
        		
        		
        		
        	}); 
 
