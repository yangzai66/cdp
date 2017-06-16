var load_data = function(){
	var where= " WHERE CUSTOM_ID='1'";
	var params = new Map();
	params.put("order", order());
	params.put("where", where);
	$(".cl tbody").html("");
	Public.ajaxPost("/stock/custom/view",params.toParamsJSON(), function(msg) {
		var st_css="";
		$.each(msg.data,function(i,model){
			if(model.UPS_DOWNS_RATE<0){
				st_css='stock_down_rate';
	  		}else{
	  			st_css='stock_up_rate';
	  		}
			$(".cl tbody").append("<tr class='"+st_css+"'><td>"+model.STOCK_NO+"</td><td>"+model.STOCK_NAME+"</td><td>"+model.UPS_DOWNS_RATE+"%</td><td>"+model.UPS_DOWNS_PRICE+"</td><td>"+model.CUR_PRICE+"</td><td>"+model.HIGH_PRICE+"</td><td>"+model.LOW_PRICE+"</td><td>"+model.FUND_MAIN_PURE+"</td></tr>");
			
		});
	});
}



$(document).ready(function(){
    	
    		load_market();
    		 setInterval(function() {
    			  load_data();
    			  }, 5000);
    		
    	});
    	var load_market = function(){
    		Public.ajaxPost("/market/list", {}, function(msg) {
    		$.each(msg, function(i,model){
    			var rate_css = "bz pd";
    			if(model.UPS_DOWNS_RATE>0){
    				rate_css = "bz pg";
    			}
    			$("#market_div").append('<div class="gq gf ala" ><div class="apu"><div class="alz" style="padding:0px !important;"><span class="anj">'+model.STOCK_NAME+'</span><h2 class="ani">'+model.CUR_PRICE+'<small class="'+rate_css+'" style="margin-left:8px">'+model.UPS_DOWNS_RATE+'%</small></h2></div></div></div>');
    		});
    		});
    	}
    	function spi_tags(v){
    		var tags = "";
    		
    		
    		if(v.SPI_LXFL_4=="1"){
    			tags+="<small class='bz pg' style='margin-left:8px'>LXFL_4</small>";
    		}else{
    			if(v.SPI_LXFL_3=="1"){
        			tags+="<small class='bz pg' style='margin-left:8px'>LXFL_3</small>";
        		}else{
        			if(v.SPI_LXFL_2=="1"){
            			tags+="<small class='bz pg' style='margin-left:8px'>LXFL_2</small>";
            		}
        		}
    		}
    		
    		
    		if(v.SPI_LXSZ_4=="1"){
    			tags+="<small class='bz pg' style='margin-left:8px'>LXSZ_4</small>";
    		}else{
    			if(v.SPI_LXSZ_3=="1"){
        			tags+="<small class='bz pg' style='margin-left:8px'>LXSZ_3</small>";
        		}else{
        			if(v.SPI_LXSZ_2=="1"){
            			tags+="<small class='bz pg' style='margin-left:8px'>LXSZ_2</small>";
            		}
        		}
    		}
    		
    		
    		if(v.SPI_LXXD_4=="1"){
    			tags+="<small class='bz pg' style='margin-left:8px'>LXXD_4</small>";
    		}else{
    			if(v.SPI_LXXD_3=="1"){
        			tags+="<small class='bz pg' style='margin-left:8px'>LXXD_3</small>";
        		}else{
        			if(v.SPI_LXXD_2=="1"){
            			tags+="<small class='bz pg' style='margin-left:8px'>LXXD_2</small>";
            		}
        		}
    		}
    		
    		if(v.SPI_LXJLR_3=="1"){
    			tags+="<small class='bz pg' style='margin-left:8px'>SPI_LXJLR_3</small>";
    		}else{
    			if(v.SPI_LXJLR_2=="1"){
        			tags+="<small class='bz pg' style='margin-left:8px'>SPI_LXJLR_2</small>";
        		}
    		}
    		
    		if(v.SPI_LXJLC_3=="1"){
    			tags+="<small class='bz pg' style='margin-left:8px'>SPI_LXJLC_3</small>";
    		}else{
    			if(v.SPI_LXJLC_2=="1"){
        			tags+="<small class='bz pg' style='margin-left:8px'>SPI_LXJLC_2</small>";
        		}
    		}
    		
    		if(v.SPI_LXDD_3=="1"){
    			tags+="<small class='bz pg' style='margin-left:8px'>SPI_LXJLC_3</small>";
    		}else{
    			if(v.SPI_LXDD_2=="1"){
        			tags+="<small class='bz pg' style='margin-left:8px'>SPI_LXDD_2</small>";
        		}
    		}
    		return tags;
    	}
    	function order(){
		  	var query_order="order by ";
		  	var headers=$("th[class*=header]");
			 for(var i=0;i<headers.length;i++){
			 var bb= headers.get(i);
				if(headers.get(i).className.indexOf('headerSortDown')>0){
				query_order+=headers.get(i).dataset.sort+" asc";
					 break;
				}
				if(headers.get(i).className.indexOf('headerSortUp')>0){
				query_order+=headers.get(i).dataset.sort+" desc";
					 break;
				}
			 }
			 return query_order;
  	}
    	var spi_where = function(v){
    		where = " AND " +v +"='1'";
    		load_industry_plate();
    	}