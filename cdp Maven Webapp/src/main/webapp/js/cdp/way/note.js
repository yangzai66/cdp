var load_note_data = function(page_no){
	if(page_no==null || page_no=='undefined' || page_no==""){
		page_no=1;
	}
	var params = new Map();
	params.put("note_title", $("input[name='note_title_order']").val());
	params.put("starttime", $("input[name='note_starttime']").val());
	params.put("page_no", page_no);
	params.put("page_size", 30);
	$("#note_list tbody").html("");
	Public.ajaxPost("/note/list", params.toParamsJSON(), function(msg) {
		$.getJSON("/cdp/dictionary/list",function(dic){
		$.each(msg.data,function(i,model){
			$("#note_list tbody").append("<tr><td><div class=\"en aob aof\" style=\"margin:0px\"><label style=\"min-height:0px; padding:0px;\"><input type=\"checkbox\" value="+model.NOTE_ID+"><span class=\"aoc\"></span></label></div></td><td><a href=\"#\" onclick=\"view_note("+model.NOTE_ID+")\">"+model.NOTE_TITLE+"</a></td><td>"+dic.note_type[model.NOTE_TYPE]+"</td><td>"+$.getDateUtil(model.CREATETIME, "yyyy-mm-dd hh:mi:ss")+"</td><td><a href='#' onclick=\"edit_note("+model.NOTE_ID+")\" ><span class=\"glyphicon glyphicon-edit\"></span></a></td></tr>");
			
		});
		})
		var options = {
				currentPage: msg.page_no,
				totalPages: msg.count,
				numberOfPages:5,
				onPageClicked:function(event,originalEvent,type,page){
					load_note_data(page);
//					alert(page);
				}
		}
		$('#page_div').bootstrapPaginator(options);
		
	});
	
}
function check_all(obj){
	 $("#note_list_div input[type='checkbox']").prop('checked', $(obj).prop('checked'));
}
$("#del_note_btn").click(function(){
	var arr=$("#note_list_div input[type='checkbox']:checked");
	if(arr.length==0){$.messenger("请选择所需要删除的日志！"); return;}
	var note_id = "";
	$(arr).each(function(){
		if(this.value!=-1){
			note_id+=this.value+",";
		}
	});
	if(confirm("确认知行删除计划操作？")){
	var params = new Map();
	params.put("note_id", note_id);
	Public.ajaxPost("/note/delete", params.toParamsJSON(), function(msg) {
		$.messenger("删除成功!");
		load_note_data(1);
	})
	}
});
var view_note = function(id){
	Public.ajaxGet("/note/view/"+id, {
	}, function(msg) {
		if(msg.result){
			$("#note_view_title").html(msg.data.NOTE_TITLE);
			$("#note_view_content").html(msg.data.NOTE_CONTENT);
			$("#note_view_type").html(note_type_info.note_type[msg.data.NOTE_TYPE]);
			$("#note_view_createtime").html($.getDateUtil(msg.data.CREATETIME, "yyyy-mm-dd hh:mi:ss"));
		}
	});
	
}
var edit_note = function(id){
	Public.ajaxGet("/note/view/"+id, {
	}, function(msg) {
		if(msg.result){
			control_display(4);
			$("#note_edit_title").val(msg.data.NOTE_TITLE);
			$("#note_edit_content").code(msg.data.NOTE_CONTENT);
			$("#note_edit_id").val(id);
			$.each(note_type_info.note_type,function(i,model){
					if(i==msg.data.NOTE_TYPE)
						$("select[name='note_edit_type']").append("<option selected=\"selected\" value="+i+">"+model+"</option>");
					else
						$("select[name='note_edit_type']").append("<option value="+i+">"+model+"</option>");
				});
				
		}
	});
	
//	$("#note_edit_content").html(content);
//	$("#note_edit_type").html(type);
//	$("#note_edit_createtime").html(time);
}
var note_type_info="";
$(document).ready(function(){
	 $('#reservation').daterangepicker();
        	load_note_data(1);
        	$(".summernote").summernote({
       		 height: 300
       	});
        	Public.ajaxGet("/dictionary/list",{}, function(dic) {
        		note_type_info = dic;
        	});
        	Public.ajaxGet("/dictionary/list",{}, function(msg) {
        		$.each(msg.note_type,function(i,model){
//        			alert(model)
        			$("select[name='add_note_type']").append("<option value="+i+">"+model+"</option>");
        		});
        		
        	});
        		$("#knowledge_save").click(function(){
//        			var params = new Map();
        			var note_title = $("input[name='note_title']").val();
        			var note_content = $("#note_content").code();
//    	    		params.put("NOTE_TITLE",$("input[name='note_title']").val());
//    	    		params.put("NOTE_CONTENT",$("#note_content").summernote('code'));
//    	    		params.put("NOTE_TYPE", $("select[name='add_note_type']").val());
        			Public.ajaxPost("/note/add","note_title="+note_title+"&note_content="+note_content+"&note_type="+$("select[name='add_note_type']").val(), function(msg) {
        				if(msg.result){
        					$.messenger("新增成功！",0);
        					$("#note_content").code('')
        					 $("input[name='note_title']").val('')
        				}else{
        				$.messenger("操作失败了");
        				}
        			})
        		});
        		$("#new_note").click(function(){
        			control_display(1);
        			
        		});
        		$("#note_edit_btn").click(function(){
        			var params = new Map();
        			params.put("NOTE_TITLE",$("#note_edit_title").val());
    	    		params.put("NOTE_CONTENT",$("#note_edit_content").code());
    	    		params.put("NOTE_TYPE", $("select[name='note_edit_type']").val());
        			params.put("NOTE_ID", $("#note_edit_id").val())
        			Public.ajaxPost("/note/update", params.toParamsJSON(), function(msg) {
        				if(msg.result){
        					$.messenger("修改成功！",0);
        					load_note_data(1);
        				}
        			})
        			
        		});
        		
        		
        	}); 
 
