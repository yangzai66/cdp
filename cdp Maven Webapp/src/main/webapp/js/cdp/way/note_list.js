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
			$("#note_list tbody").append("<tr><td><a href=\"note_view.jsp?m="+$.getUrlParam("m")+"&id="+model.NOTE_ID+"\">"+model.NOTE_TITLE+"</a></td><td>"+dic.note_type[model.NOTE_TYPE]+"</td><td>"+$.getDateUtil(model.CREATETIME, "yyyy-mm-dd hh:mi:ss")+"</td><td><a href=\"note_edit.jsp?m="+$.getUrlParam("m")+"&id="+model.NOTE_ID+"\" class=\"btn btn-info btn-xs edit\"><i class=\"fa fa-edit\"></i> Edit</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href=\"javascript:note_del("+model.NOTE_ID+")\" class=\"btn btn-danger btn-xs delete\"><i class=\"fa fa-trash-o\"></i> Delete</a></td></tr>");
			
		});
		})
		var options = {
				currentPage: msg.page_no,
				totalPages: msg.count,
				numberOfPages:5,
				onPageClicked:function(event,originalEvent,type,page){
					load_note_data(page);
				}
		}
		$('#page_div').bootstrapPaginator(options);
		
	});
	
}
var note_del = function(id){
	if(confirm("确认知行删除计划操作？")){
		var params = new Map();
		params.put("note_id", id);
		Public.ajaxPost("/note/delete", params.toParamsJSON(), function(msg) {
			$.messenger("删除成功!",0);
			load_note_data(1);
		})
		}
	
}
var note_type_info="";
$(document).ready(function(){
	 $('#reservation').daterangepicker();
     load_note_data(1);
     Public.ajaxGet("/dictionary/list",{}, function(dic) {
        		note_type_info = dic;
        	});
        	}); 
 
