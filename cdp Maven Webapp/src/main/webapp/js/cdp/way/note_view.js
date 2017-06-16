var note_type_info="";
$(document).ready(function(){
        	Public.ajaxGet("/dictionary/list",{}, function(dic) {
        		note_type_info = dic;
        	});
        	Public.ajaxGet("/note/view/"+$.getUrlParam("id"), {
        	}, function(msg) {
        		if(msg.result){
        			$("#note_view_title").html(msg.data.NOTE_TITLE);
        			$("#note_view_content").html(msg.data.NOTE_CONTENT);
        			$("#note_view_type").html(note_type_info.note_type[msg.data.NOTE_TYPE]);
        			$("#note_view_createtime").html($.getDateUtil(msg.data.CREATETIME, "yyyy-mm-dd hh:mi:ss"));
        		}
        	});
        	}); 
 
