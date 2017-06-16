var note_type_info="";
$(document).ready(function(){
        	$(".summernote").summernote({
       		 height: 300
       	});
        	Public.ajaxGet("/dictionary/list",{}, function(dic) {
        		note_type_info = dic;
        	});
        	
        	Public.ajaxGet("/note/view/"+$.getUrlParam("id"), {
        	}, function(msg) {
        		if(msg.result){
        			$("#note_edit_title").val(msg.data.NOTE_TITLE);
        			$("#note_edit_content").code(msg.data.NOTE_CONTENT);
        			$("#note_edit_id").val($.getUrlParam("id"));
                		$.each(note_type_info.note_type,function(i,model){
                			if(i==msg.data.NOTE_TYPE)
        						$("select[name='note_edit_type']").append("<option selected=\"selected\" value="+i+">"+model+"</option>");
        					else
        						$("select[name='note_edit_type']").append("<option value="+i+">"+model+"</option>");
                		});
        		}
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
        				}
        			})
        			
        		});
        		
        		
        	}); 
 
