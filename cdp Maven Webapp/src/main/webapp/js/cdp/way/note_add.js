var note_type_info="";
$(document).ready(function(){
	 $('#reservation').daterangepicker();
        	$(".summernote").summernote({
       		 height: 300
       	});
        	Public.ajaxGet("/dictionary/list",{}, function(dic) {
        		note_type_info = dic;
        	});
        	Public.ajaxGet("/dictionary/list",{}, function(msg) {
        		$.each(msg.note_type,function(i,model){
        			$("select[name='add_note_type']").append("<option value="+i+">"+model+"</option>");
        		});
        	});
        		$("#knowledge_save").click(function(){
        			var note_title = $("input[name='note_title']").val();
        			var note_content = $("#note_content").code();
        			Public.ajaxPost("/note/add","note_title="+note_title+"&note_content="+note_content+"&note_type="+$("select[name='add_note_type']").val(), function(msg) {
        				if(msg.result){
        					$.messenger("新增成功！",0);
        					$("#note_content").code('')
        					 $("input[name='note_title']").val('')
        				}else{
        					$.messenger("发生了异常错误！",1);
        				}
        			})
        		});
        		
        		
        	}); 
 
