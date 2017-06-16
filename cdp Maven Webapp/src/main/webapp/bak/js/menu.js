  	$(document).ready(function(){
  		$.getJSON("/cdp/menu/list",function(msg){
	  		$.each(msg,function(i,model){
	  		var childnode = "";
	  		var m_a = $.getUrlParam("m_a");
	  		var m_b = $.getUrlParam("m_b");
	  		var m_c = $.getUrlParam("m_c");
	  		if(model.level==3){
	  			$.each(model.child,function(k,m2){
	  			if(m_b==k){
	  				$.each(m2.child,function(j,m3){
	  					if(m_c ==j){
	  						$("#l_menu").append("<li class=\"active\"><a href=\""+m3.url+"\">"+m3.name+"</a></li>")
	  					}else{
	  						$("#l_menu").append("<li ><a href=\""+m3.url+"\">"+m3.name+"</a></li>")
	  					}
	  				});
	  			}
	  				childnode+="<li><a href=\""+m2.url+"\">"+m2.name+"</a></li>";
	  				
	  			});
	  			childnode="<ul class=\"dropdown-menu\">"+childnode+"</ul>";
	  			$("#c_menu").append("<li><a href=\""+model.url+"?\" class=\"dropdown-toggle\" data-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\" aria-expanded=\"false\">"+model.name+" <span class=\"caret\"></span></a>"+childnode+"</li>")
	  			
	  		}else{
	  			$.each(model.child,function(k,m2){
	  				if(m_c ==k){
  						$("#l_menu").append("<li class=\"active\"><a href=\""+m2.url+"?m_a="+i+"&m_c="+k+"\">"+m2.name+"</a></li>")
  					}else{
  						$("#l_menu").append("<li ><a href=\""+m2.url+"?m_a="+i+"&m_c="+k+"\">"+m2.name+"</a></li>")
  					}
	  			});
	  		$("#c_menu").append("<li><a href=\""+model.url+"?m_a="+i+"\" >"+model.name+"</a>"+childnode+"</li>")
	  		}
	  		});
  		
  		});
  		
  		
  	});
  		